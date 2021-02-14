package com.offcn.service;

import com.offcn.dao.UserDao;
import com.offcn.entity.User;

public class UserService {
	UserDao uDao = new UserDao();
	//通过账号查询哦用户信息
	public boolean getUserByUsername(String username) {
		return uDao.getUserByUsername(username) == null ? true : false;
	}
	//通过邮箱查询哦用户信息
	public boolean getuUserByEmail(String email) {
		return uDao.getUserByUsername(email) == null ? true : false;
	}
	//新增管理员
	public boolean regist(User user) {
		return uDao.regist(user) == 0 ? false :true;
	}
	//登录
	public boolean login(String username,String pwd) {
		return uDao.login(username, pwd)==null ? false : true;
	} 
}
