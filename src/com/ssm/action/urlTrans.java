package com.ssm.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/12/22.
 */
@Controller
public class urlTrans {
    @RequestMapping("/urlzhuagnhuagn")
    public String Urlzhuagnhuagn(String url){
        System.out.println("url");
        return "forward:/WEB-INF/manager/"+url;
    }
}
