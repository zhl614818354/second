package com.offcn.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.entity.User;



public class UserDao {
	//�����˺�������в�ѯ����ɵ�¼����
	public User getUserByNameAndPwd(String uname,String pwd) {
		User user = null;
		ComboPooledDataSource ds = new ComboPooledDataSource();
		QueryRunner qr = new QueryRunner(ds);
		String sql = "select uname,pwd from tb_user where uname=? and pwd = ?";
		try {
			 user = qr.query(sql, new BeanHandler<>(User.class),uname,pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
		
	}
	
	//����û�
	public int addUser(String uname,String pwd) {
		int i = 0;
		ComboPooledDataSource ds = new ComboPooledDataSource();
		QueryRunner qr = new QueryRunner(ds);
		String sql= "insert into tb_user (uname,pwd)values (?,?)";
		try {
			i = qr.update(sql,uname,pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
		
	}
}
