package com.offcn.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.entity.Student;



public class StudentDao {
	ComboPooledDataSource ds = new ComboPooledDataSource();
	QueryRunner qr = new QueryRunner(ds);
	
	//查询显示所有学生信息
	public List<Student> getAllStudent(){
		List<Student> list = new ArrayList<Student>();
		String sql = "select * from tb_student";
		try {
			list = qr.query(sql, new BeanListHandler<>(Student.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	//新增学生信息
	public int addStudent(String sname,int sage,String ssex,String semail) {
		int i = 0;
		String sql = "insert into tb_student (sname,sage,ssex, semail) values (?,?,?,?)";
		try {
			i = qr.update(sql, sname,sage,ssex,semail);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
		
	}
	
	//删除学生信息
	public int delStudent(int sid) {
		int i = 0;
		String sql = "delete from tb_student where sid = ?";
		try {
			i = qr.update(sql, sid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
		
	}
}
