package com.offcn.service;

import com.offcn.dao.UserDao;
import com.offcn.entity.User;

public class UserService {
	UserDao ud = new UserDao();
	//��¼����
	public boolean getUserByNameAndPwd(String uname,String pwd) {
		User user = ud.getUserByNameAndPwd(uname, pwd);
		boolean res = true;
		if(user==null) {
			res = false;
		}
		return res;
	}
	//ע�����
	public boolean addUser(String uname,String pwd) {
		int rows = ud.addUser(uname, pwd);
		boolean res = true;
		if(rows == 0 ) {
			res = false;
		}
		return res;
	}
}
