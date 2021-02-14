package com.offcn.entity;

import java.util.Date;

public class Doctor {
	private int did;
	private String dname;
	private String idcard;
	private String phone;
	private int sex;
	private int age;
	private Date birthday;
	private String email;
	private int department;
	private int education;
	private String remark;
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor(int did, String dname, String idcard, String phone, int sex, int age, Date birthday, String email,
			int department, int education, String remark) {
		super();
		this.did = did;
		this.dname = dname;
		this.idcard = idcard;
		this.phone = phone;
		this.sex = sex;
		this.age = age;
		this.birthday = birthday;
		this.email = email;
		this.department = department;
		this.education = education;
		this.remark = remark;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getDepartment() {
		return department;
	}
	public void setDepartment(int department) {
		this.department = department;
	}
	public int getEducation() {
		return education;
	}
	public void setEducation(int education) {
		this.education = education;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Doctor [did=" + did + ", dname=" + dname + ", idcard=" + idcard + ", phone=" + phone + ", sex=" + sex
				+ ", age=" + age + ", birthday=" + birthday + ", email=" + email + ", department=" + department
				+ ", education=" + education + ", remark=" + remark + "]";
	}
	
}
