package com.offcn.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.entity.User;
import com.sun.org.apache.bcel.internal.generic.NEW;


public class UserDao {
	ComboPooledDataSource ds = new ComboPooledDataSource();
	QueryRunner qr = new QueryRunner(ds);
	//通过账号查询用户信息
	public User getUserByUsername(String username) {
		User user = null;
		String sql = "select * from tb_user where username =?";
		try {
			user = qr.query(sql, new BeanHandler<>(User.class),username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	//通过邮箱查询用户信息
	public User getuUserByEmail(String email) {
		User user = null;
		String sql = "select * from tb_user where email = ?";
		try {
			user = qr.query(sql, new BeanHandler<>(User.class),email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	//新增管理员
	public int regist(User user) {
		int rows = 0;
		String sql = "insert into tb_user(username,pwd,uname,email,cdate) values(?,?,?,?,?)";
		try {
			rows = qr.update(sql, user.getUsername(),user.getPwd(),user.getUname(),user.getEmail(),user.getcDate());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	} 
	
	//登录
	public User login(String username, String pwd) {
		User user = null;
		String sql = "select * from tb_user where username = ? and pwd = ?";
		try {
			user = qr.query(sql, new BeanHandler<>(User.class),username,pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
    
	
}
