package com.offcn.service;

import com.offcn.dao.UserDao;
import com.offcn.entity.User;

public class UserService {
	UserDao uDao = new UserDao();
	//ͨ���˺Ų�ѯŶ�û���Ϣ
	public boolean getUserByUsername(String username) {
		return uDao.getUserByUsername(username) == null ? true : false;
	}
	//ͨ�������ѯŶ�û���Ϣ
	public boolean getuUserByEmail(String email) {
		return uDao.getUserByUsername(email) == null ? true : false;
	}
	//��������Ա
	public boolean regist(User user) {
		return uDao.regist(user) == 0 ? false :true;
	}
	//��¼
	public boolean login(String username,String pwd) {
		return uDao.login(username, pwd)==null ? false : true;
	} 
}
