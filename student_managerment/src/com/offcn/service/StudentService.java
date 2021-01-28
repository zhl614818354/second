package com.offcn.service;

import java.util.List;

import com.offcn.dao.StudentDao;
import com.offcn.entity.Student;

public class StudentService {
	
	StudentDao sd = new StudentDao();
	//��ѯ��������
	public List<Student> getAllStudent(){
		return sd.getAllStudent();	
	}
	//����ѧ��
	public boolean addStudent(String sname,int sage,String ssex,String semail) {
		int i = sd.addStudent(sname, sage, ssex, semail);
		boolean res = true;
		if(i == 0 ) {
			res =false;
		}
		return res;
	}
	//ɾ��ѧ��
	public boolean delStudent(int sid) {
		int i = sd.delStudent(sid);
		boolean res = true;
		if(i == 0 ) {
			res =false;
		}
		return res;
		
	}
}
