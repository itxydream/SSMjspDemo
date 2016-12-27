package com.ssm.action;

import com.alibaba.fastjson.JSON;
import com.ssm.domain.Emp;
import com.ssm.service.EmpService;
import com.ssm.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2016/12/24.
 */
@Controller
public class UserGnController {
    @Autowired
    private EmpService empService;
    @RequestMapping("/MenuListAction")
    public ModelAndView find(HttpServletResponse response,HttpServletRequest request) {
        List<Emp> emps = empService.sectAll();
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        //构造要发送到前段的json格式数据
        List<Emp> rolesByPage = empService.findRolesByPage(Integer.parseInt(page), Integer.parseInt(rows));
        String res = "{\"total\":" + emps.size() + ",\"rows\":" + JSON.toJSONString(rolesByPage) + "}";
        try {
            ResponseUtil.write(response, res);
            System.out.println(res);
        } catch (Exception e) {
        }
        return new ModelAndView("/WEB-INF/manager/find.jsp", "emp", res);
    }

    @RequestMapping("/addUser")
    private String addUsers(String name, String pwd, Model model){
        boolean flaa = empService.addUser(name,pwd);
        model.addAttribute("flaa",flaa);
        return "forward:/WEB-INF/manager/user/find.jsp";
    }
    @RequestMapping("/UpdateAction")
    private String UpdataUser( Integer id,Emp emp, Model model,HttpServletResponse response){
        boolean flaa = empService.UpateEmpbyId(id,emp);
        model.addAttribute("flag",flaa);
        return "forward:/WEB-INF/manager/user/find.jsp";


    }
    @RequestMapping("/delterAction")
    private String Delete( Integer id ,Model model,HttpServletResponse response){
        boolean flaa = empService.DeleteUser(id);
        model.addAttribute("jieguo",flaa);
        return "forward:/WEB-INF/manager/user/find.jsp";


    }
}
