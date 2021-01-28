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
    	//��ȡflag��ֵ������Ҫ���õķ���������
    	String flag = req.getParameter("flag");
    	try {
    		//���ݲ����ҵ�ָ���ķ���
			Method m = this.getClass()
					.getDeclaredMethod(flag, HttpServletRequest.class, HttpServletResponse.class);
			//���Ʒ����ķ������η�������
			m.setAccessible(true);
			//ִ�з���
			m.invoke(this, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		} 		
    }
}
