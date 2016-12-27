package com.ssm.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

//统一的向页面进行结果输出的工具类
public class ResponseUtil {
	public static void write(HttpServletResponse response,Object result) throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(result.toString());
		out.flush();
		out.close();
	}
}
