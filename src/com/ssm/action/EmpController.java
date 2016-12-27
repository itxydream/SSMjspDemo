package com.ssm.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.ssm.domain.Emp;
import com.ssm.domain.json.Attribute;
import com.ssm.domain.json.ChildNode;
import com.ssm.domain.json.TreeNode;
import com.ssm.service.EmpService;
import com.ssm.utils.DBUtil;
import com.ssm.utils.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/12/20.
 */

@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    @RequestMapping("/login")
    public ModelAndView login(String empName, String empPwd) {
        if (empName != null && empPwd != null) {
            Emp  emp = empService.login(empName, empPwd);
            if (emp != null) {
                return new ModelAndView("/WEB-INF/manager/index.jsp","emp", emp);
            }
        }
        return null;
    }

    @RequestMapping("/json")
    public void json(int empId, HttpServletResponse response, HttpServletRequest request) throws SQLException, IOException {
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  //http://localhost:8080/ssm/
        System.out.println(basePath);
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps1 = conn.prepareStatement(SQL.sql1);
        ps1.setInt(1, empId);
        ResultSet rs1 = ps1.executeQuery();

        int i = 1;
        String json = "[";
        String temp = "";
        TreeNode treeNode = null;
        while (rs1.next()) {
            String authgroupName = rs1.getString("tb_authgroup.name");
            if (temp.equals("") || !temp.equals(authgroupName)) {
                String s = JSON.toJSONString(treeNode);
                if (!s.equals("null"))
                    json += s + ",";
                treeNode = new TreeNode();
                treeNode.setId(i++);

                treeNode.setText(authgroupName);
                treeNode.setState("opened");
                temp = authgroupName;
            }
            ChildNode childNode = new ChildNode();
            childNode.setId(rs1.getInt("id"));
            childNode.setText(rs1.getString("tb_auth.name"));

            Attribute attribute = new Attribute();
            attribute.setUrl( rs1.getString("url") + "/" + rs1.getString("op")+".jsp");
            childNode.setAttributes(attribute);

            treeNode.getChildren().add(childNode);
        }
        json += JSON.toJSONString(treeNode) + ",";
        System.out.println(json);

        PreparedStatement ps2 = conn.prepareStatement(SQL.sql2);
        ps2.setInt(1, empId);
        ResultSet rs2 = ps2.executeQuery();
        PropertyFilter profilter = new PropertyFilter() {
            @Override
            public boolean apply(Object object, String name, Object value) {
                if (name.equalsIgnoreCase("children")) {      //false表示last字段将被排除在外
                    return false;
                }
                return true;
            }

        };
        while (rs2.next()) {
            TreeNode treeNode1 = new TreeNode();
            treeNode1.setId(i++);
            treeNode1.setText(rs2.getString("tb_auth.name"));
            Attribute attribute = new Attribute();
            //basePath+rs2.getString("url") + "/" + rs2.getString("op")+".do"、、
            attribute.setUrl(rs2.getString("url") + "/" + rs2.getString("op")+".jsp");

            treeNode1.setAttributes(attribute);
            json += JSON.toJSONString(treeNode1, profilter) + ",";
        }

        json = json.substring(0, json.length() - 1);
        json += "]";

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/json");
        PrintWriter out = response.getWriter();
        out.println(json);
        out.flush();
//        DBUtil.close();
    }

}
