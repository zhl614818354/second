package com.offcn.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BasicServlet")
public class BasicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BasicServlet() {
        super();
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) 
    		throws ServletException, IOException {
    	req.setCharacterEncoding("utf-8");
    	resp.setContentType("text/html;charset=utf-8");
    	//获取flag的值，就是要调用的方法的名字
    	String flag = req.getParameter("flag");
    	try {
    		//根据参数找到指定的方法
			Method m = this.getClass()
					.getDeclaredMethod(flag, HttpServletRequest.class, HttpServletResponse.class);
			//打破方法的访问修饰符的限制
			m.setAccessible(true);
			//执行方法
			m.invoke(this, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		} 		
    }
}
