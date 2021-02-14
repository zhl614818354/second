package com.offcn.service;

import java.util.List;

import com.offcn.dao.DoctorDao;
import com.offcn.entity.Doctor;
import com.offcn.util.PageUtil;

public class DoctorService {
	DoctorDao dao = new DoctorDao();
	//��ѯҽ����Ϣ������
	public int getCountRows() {
		return dao.getCountRows();
	}
	//��ҳ��ѯҽ����Ϣ
	public List<Doctor> getAllDoctorByPage(PageUtil pUtil){
		return dao.getDoctorByPage(pUtil);
	}
	//����ɾ��
	public boolean delDocByDid(int did) {
		return dao.delDocByDid(did) == 0 ? false: true;
	}
	//���ҽ��
	public boolean addDoctor(Doctor doctor) {
		return dao.addDoctor(doctor) == 0 ? false: true;
	}
	//�������������з�ҳ��ѯ
	public List<Doctor> getDoctorBySth (String dname, int department,PageUtil pu){
		return dao.getDoctorBySth(dname, department, pu);
	}
}
