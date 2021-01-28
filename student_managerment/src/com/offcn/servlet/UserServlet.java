package com.offcn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.dao.UserDao;
import com.offcn.entity.User;
import com.offcn.service.UserService;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(name = "UserServlet", urlPatterns = { "/UserServlet1" })
public class UserServlet extends BasicServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	UserService us = new UserService();
	protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("username");
		String pwd = request.getParameter("password");
		boolean i = us.addUser(uname, pwd);
		if(i==true) {
			response.sendRedirect("login.html");
		}else {
			response.sendRedirect("register.html");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String uname = request.getParameter("username");
			String pwd = request.getParameter("password");
			boolean res = us.getUserByNameAndPwd(uname, pwd);
			if(!res) {
				response.sendRedirect("login.html");
			}else {
				response.sendRedirect("index.html");
			}
	

	}

	
	
	
	
	
	
	
	
	
	
}
