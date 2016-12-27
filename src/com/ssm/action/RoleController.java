package com.ssm.action;

import com.alibaba.fastjson.JSON;
import com.ssm.domain.Role;
import com.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/findRole")
    public void findRole(HttpServletRequest request, HttpServletResponse response){
        List<Role> allRoles = roleService.findAllRoles();
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        List<Role> roles = roleService.findRolesByPage(Integer.parseInt(page), Integer.parseInt(rows));
        String res = "{\"total\":" + allRoles.size() + ",\"rows\":" + JSON.toJSONString(roles) + "}";
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");
        try {
            response.getWriter().print(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/addRole")
    private String addRole(String roleName, Model model){
        boolean flag = roleService.addRole(roleName);
        model.addAttribute("flag",flag);
        return "forward:/WEB-INF/manager/role/find.jsp";
    }
}
