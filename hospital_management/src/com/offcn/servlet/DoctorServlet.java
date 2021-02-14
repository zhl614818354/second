package com.offcn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.entity.Doctor;
import com.offcn.service.DoctorService;
import com.offcn.util.DateUtil;
import com.offcn.util.PageUtil;

/**
 * Servlet implementation class DoctorServlet
 */
@WebServlet("/DoctorServlet")
public class DoctorServlet extends BasicServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    DoctorService ds = new DoctorService();
	protected void getAllDoctorByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		int size = 5;
		int countRows = ds.getCountRows();
		PageUtil pu = new PageUtil(size, page, countRows);
		List<Doctor> list = ds.getAllDoctorByPage(pu);
		request.setAttribute("pu", pu);
		request.setAttribute("list", list);
		request.getRequestDispatcher("doctor/index.jsp").forward(request, response);
	}
	
	protected void delDocByDid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int did = Integer.parseInt(request.getParameter("did"));
		boolean res = ds.delDocByDid(did);
		PrintWriter out = response.getWriter();
		out.print(res);
		out.close();
	}
	
	//Ìí¼Ó
	protected void addDoctor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dname = request.getParameter("dname");
		String idcard = request.getParameter("idcard");
		String phone = request.getParameter("phone");
		int sex  = Integer.parseInt(request.getParameter("sex"));
		Date birthday = DateUtil.stringToDate(request.getParameter("birthday"));
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		int department = Integer.parseInt(request.getParameter("department"));
		int education = Integer.parseInt(request.getParameter("education"));
		String remark = request.getParameter("remark");
		Doctor doctor = new Doctor(0, dname, idcard, phone, sex, age, birthday, email, department, education, remark);
		boolean res = ds.addDoctor(doctor);
		PrintWriter out = response.getWriter();
		out.print(res);
		out.close();	
	}
	
	protected void getDoctorBySth(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dname = request.getParameter("dname");
		int department = 0;
		if(request.getParameter("department")!=null && !"".equals(request.getParameter("department"))) {
			department = Integer.parseInt(request.getParameter("department"));
		}
		String page = request.getParameter("page");
		int size = 2;
		int countRows = ds.getCountRows();
		PageUtil pu = new PageUtil(size, page, countRows);
		List<Doctor> list = ds.getDoctorBySth(dname, department, pu);
		request.setAttribute("pu", pu);
		request.setAttribute("list", list);
		request.getRequestDispatcher("doctor/index.jsp").forward(request, response);
	}

}
