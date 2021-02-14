package com.offcn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.offcn.entity.User;
import com.offcn.service.UserService;
import com.offcn.util.VerifyCodeUtils;

import sun.awt.RepaintArea;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends BasicServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    UserService userService = new UserService();
	protected void checkUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		boolean res = userService.getUserByUsername(username);
		PrintWriter out = response.getWriter();
		out.print(res);
		out.close();
	}
	
	protected void checkEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		boolean res = userService.getUserByUsername(email);
		PrintWriter out = response.getWriter();
		out.print(res);
		out.close();
	}
	
	protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String uname = request.getParameter("uname");
		String email = request.getParameter("email");
		User user = new User(0, username, pwd, uname, email, new Date());
		boolean res = userService.regist(user);
		PrintWriter out = response.getWriter();
		out.print(res);
		out.close();
	}
	
	protected void createVerifyCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-control");
		response.setContentType("image/ipeg");
		
		//Éú²úËæ»ú×Ö·û´®
		String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
		HttpSession session = request.getSession();
		session.removeAttribute("verCode");
		session.setAttribute("verCode", verifyCode.toLowerCase());
		
		int w = 100, h=30;
		VerifyCodeUtils.outputImage(w, h, response.getOutputStream(),verifyCode);
		
	}
	protected void checkCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		String verCode = (String)request.getSession().getAttribute("verCode");
		boolean res = true;
		if(!code.equalsIgnoreCase(verCode)) {
			res = false;
		}
		PrintWriter out = response.getWriter();
		out.print(res);
		out.close();
	}
	
	//µÇÂ¼
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		boolean res = userService.login(username, pwd);
		HttpSession session = request.getSession();
		if(res) {
			session.removeAttribute("msg");
			session.setAttribute("username", username);
			response.sendRedirect("index.jsp");
		}else {
			session.setAttribute("msg", "ÕÊºÅÃÜÂëÓÐÎó£¬ÇëÖØÐÂÊäÈë");
			response.sendRedirect("login.jsp");
		}
	}
	
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("login.jsp");
	}

}
