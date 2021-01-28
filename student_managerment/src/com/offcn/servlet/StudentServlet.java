package com.offcn.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.entity.Student;
import com.offcn.service.StudentService;


/**
 * Servlet implementation class StudentServlet
 */
@WebServlet(name = "StudentServlet", urlPatterns = { "/StudentServlet" })
public class StudentServlet extends BasicServlet {
	private static final long serialVersionUID = 1L;
       
	StudentService studentService = new StudentService();
	protected void getAllStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("*********");
		List<Student> list = studentService.getAllStudent();
		System.out.println(list);
		
		request.setAttribute("stuList", list);
		
		request.getRequestDispatcher("student.jsp").forward(request, response);
	}

	public void addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sname = request.getParameter("sname");
		int sage = Integer.parseInt(request.getParameter("sage"));
		String ssex = request.getParameter("ssex");
		String semail = request.getParameter("semail");
		Student student = new Student(0, sname, sage, ssex, semail);
		boolean res = studentService.addStudent(sname, sage, ssex, semail);
		if(res) {
			getAllStudent(request, response);
		}else {
			response.sendRedirect("add.html");
		}
	}

	protected void delStuBySid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		int sid = Integer.parseInt(request.getParameter("sid"));
		boolean res = studentService.delStudent(sid);
		if(res) {
			getAllStudent(request, response);
		}else {
			PrintWriter out = response.getWriter();
			out.print("É¾³ýÊ§°Ü");
			out.close();
		}
	}
}
