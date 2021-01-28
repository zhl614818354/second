package com.offcn.service;

import java.util.List;

import com.offcn.dao.StudentDao;
import com.offcn.entity.Student;

public class StudentService {
	
	StudentDao sd = new StudentDao();
	//查询所有数据
	public List<Student> getAllStudent(){
		return sd.getAllStudent();	
	}
	//新增学生
	public boolean addStudent(String sname,int sage,String ssex,String semail) {
		int i = sd.addStudent(sname, sage, ssex, semail);
		boolean res = true;
		if(i == 0 ) {
			res =false;
		}
		return res;
	}
	//删除学生
	public boolean delStudent(int sid) {
		int i = sd.delStudent(sid);
		boolean res = true;
		if(i == 0 ) {
			res =false;
		}
		return res;
		
	}
}
