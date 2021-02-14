package com.offcn.service;

import java.util.List;

import com.offcn.dao.DoctorDao;
import com.offcn.entity.Doctor;
import com.offcn.util.PageUtil;

public class DoctorService {
	DoctorDao dao = new DoctorDao();
	//查询医生信息总条数
	public int getCountRows() {
		return dao.getCountRows();
	}
	//分页查询医生信息
	public List<Doctor> getAllDoctorByPage(PageUtil pUtil){
		return dao.getDoctorByPage(pUtil);
	}
	//单条删除
	public boolean delDocByDid(int did) {
		return dao.delDocByDid(did) == 0 ? false: true;
	}
	//添加医生
	public boolean addDoctor(Doctor doctor) {
		return dao.addDoctor(doctor) == 0 ? false: true;
	}
	//根据条件及逆行分页查询
	public List<Doctor> getDoctorBySth (String dname, int department,PageUtil pu){
		return dao.getDoctorBySth(dname, department, pu);
	}
}
