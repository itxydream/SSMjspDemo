package com.ssm.action;

import com.alibaba.fastjson.JSON;
import com.ssm.domain.Goods;
import com.ssm.service.GoodsService;
import com.ssm.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2016/12/22.
 */
@Controller
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    // 打开界面就显示数据，构造json显示到前端页面
    @RequestMapping(value = "/showAllGoods", method = {RequestMethod.GET,RequestMethod.POST})
    public void showAllGoods(HttpServletRequest request,HttpServletResponse response)  {
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        int page2 = 1;
        int rows2 = 10;// 初始默认从第1页开始，显示10条
        if (page != null && rows != null) {
            // 如果客户端传递过来的页码和条数不为空
            page2 = Integer.parseInt(page);
            rows2 = Integer.parseInt(rows);
        }
        List<Goods> allGoods = goodsService.findAll();
        List<Goods> goodsList = goodsService.findbyPage(page2,rows2);
        //构造要发送到前段的json格式数据

        String json = JSON.toJSONString(goodsList);
        String res = "{\"total\":" + allGoods.size() + ",\"rows\":" + JSON.toJSONString(goodsList) + "}";
        try {
            ResponseUtil.write(response,res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/addGoods")
    public String add(Model model,Goods goods){
        Boolean addGoods = goodsService.addGoods(goods);
        model.addAttribute("addGoods",addGoods);
        return "/WEB-INF/manager/goods/find.jsp";
    }
    @RequestMapping(value = "/deleteGoods", method = {RequestMethod.GET,RequestMethod.POST})
    public String deleteGoods(Model model, int id) throws Exception {
        boolean res = goodsService.deleteGoods(id);
        model.addAttribute("res", res);
        return "/WEB-INF/manager/goods/find.jsp"; //此处的'/'表示项目根目录
    }

    @RequestMapping(value = "/editGoods", method = {RequestMethod.GET, RequestMethod.POST})
    public String editGoods(Model model, int id, Goods goods) throws Exception {
        //处理器适配器调用SpringMVC的参数绑定组件，会将客户端提交的key/value形式的数据转换成Controller方法的形参，形参的名称即为key
        boolean res = goodsService.updateGoods(id,goods);
        model.addAttribute("res",res);
        return "/WEB-INF/manager/goods/find.jsp";
    }

}
