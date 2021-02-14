package com.offcn.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.entity.Doctor;
import com.offcn.util.PageUtil;


public class DoctorDao {
	ComboPooledDataSource ds = new ComboPooledDataSource();
	QueryRunner qr = new QueryRunner(ds);
	//��ҳչʾ����ҽ����������
	public int getCountRows() {
		int CountRows = 0;
		String sql = "select count(*) from tb_doctor";
		try {
			CountRows = (int)(long)qr.query(sql, new ScalarHandler());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CountRows;
	}
	
	//��ҳ��ѯҽ����Ϣ
	public List<Doctor> getDoctorByPage(PageUtil pageUtil){
		List<Doctor> list = null;
		String sql = "select * from tb_doctor limit ?,?";
		try {
			list = qr.query(sql, new BeanListHandler<>(Doctor.class),pageUtil.getIndex(),pageUtil.getSize());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	//����ɾ��
	public int delDocByDid(int did) {
		int rows = 0;
		String sql = "delete from tb_doctor where did =?";
		try {
			rows = qr.update(sql, did);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}
	
	//���ҽ��
	public int addDoctor(Doctor doctor) {
		int rows = 0;
		String sql = "insert into tb_doctor(dname,idcard,phone,sex,age,birthday,email,department,education,remark) values(?,?,?,?,?,?,?,?,?,?)";
		try {
			rows = qr.update(sql,doctor.getDname(),doctor.getIdcard(),doctor.getPhone(),doctor.getSex(),doctor.getAge(),doctor.getBirthday(),doctor.getEmail(),doctor.getDepartment(),doctor.getEducation(),doctor.getRemark());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}
	
	//����������ѯ��������
	public int getCountRowsBySth(String dname, int department) {
		int countRows = 0;
		String sql = "select count(*) from tb_doctor where 1=1";
		if(dname !=null && !"".equals(dname)) {
			sql += " and dname like '%"+dname+"%'";
		}
		if(department != 0) {
			sql += " and department=" + department;
		}
		try {
			countRows = (int)(long)qr.query(sql, new ScalarHandler<>());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return countRows;
	}
	
	//�������������з�ҳ��ѯ
	public List<Doctor> getDoctorBySth(String dname, int department,PageUtil pu){
		List<Doctor> list = null;
		String sql = "select * from tb_doctor where 1=1 ";
		if(dname != null && !"".equals(dname)) {
			sql += " and dname like '%"+dname+"%'";
		}
		if(department !=0) {
			sql += " and department=" + department;
		}
		sql+=" limit ?,?";
		try {
			list = qr.query(sql, new BeanListHandler<>(Doctor.class), pu.getIndex(),pu.getSize());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
	
	
	
	
	
	
	
}
