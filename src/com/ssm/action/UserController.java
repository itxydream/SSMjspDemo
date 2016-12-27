package com.ssm.action;

import com.ssm.domain.Emp;
import com.ssm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2016/12/21.
 */
@Controller
@RequestMapping("/action/user")
public class UserController {

    @Autowired
    private EmpService empService;

    @RequestMapping("/login")
    public ModelAndView login(String empName, String empPwd) {
        if (empName != null && empPwd != null) {
            List<Emp> emps = empService.sectAll();
            if (emps != null) {
                return new ModelAndView("/WEB-INF/manager/index.jsp","emp", emps);
            }
        }
        return null;
    }
    @RequestMapping("/LogoutAction")
    public  String loginout(HttpServletRequest request){
            //注销的动作
            //从session中清除已经登录的用户.如果存在的话
            request.getSession().removeAttribute("user");
            return "/userLogin.jsp";
        }

}
