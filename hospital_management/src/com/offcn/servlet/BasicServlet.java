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
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String flag = request.getParameter("flag");
		try {
			//根据参数找到指定的方法
			Method m = this.getClass()
					.getDeclaredMethod(flag, HttpServletRequest.class,HttpServletResponse.class);
			//打破方法的访问修饰符带来的限制
			m.setAccessible(true);
			//运行该方法
			m.invoke(this, request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
