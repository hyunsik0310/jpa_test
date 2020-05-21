package com.hs.manage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
@NamedQueries({ 
	@NamedQuery(name = "User_Info.wbscheck", query = "select u from User_Info u where u.u_no = :u_no"),
	@NamedQuery(name = "User_Info.findByuserinfo", query = "select u from User_Info u where u.u_no = :u_no and u.u_password = :u_password"),
	@NamedQuery(name = "User_Info.findByuserinfo2", query = "select u from User_Info u where u.u_no = :u_no")

})
public class User_Info {

	@Id
	private int no;
	@Column(insertable = false)
	private String u_no;
	@Column(insertable = false)
	private String u_name;
	@Column(insertable = false)
	private String u_password;
	@Column(insertable = false)
	private String gender;
	@Column(insertable = false)
	private String address;
	@Column(insertable = false)
	private String mobile_number;
	@Column(insertable = false)
	private String birth_day;
	@Column(insertable = false)
	private String hire_date;
	@Column(insertable = false)
	private String reg_date;
	@Column(insertable = false)
	private String upd_date;
	@Column(insertable = false)
	private String upd_user;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getU_no() {
		return u_no;
	}

	public void setU_no(String u_no) {
		this.u_no = u_no;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_password() {
		return u_password;
	}

	public void setU_password(String u_password) {
		this.u_password = u_password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getBirth_day() {
		return birth_day;
	}

	public void setBirth_day(String birth_day) {
		this.birth_day = birth_day;
	}

	public String getHire_date() {
		return hire_date;
	}

	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getUpd_date() {
		return upd_date;
	}

	public void setUpd_date(String upd_date) {
		this.upd_date = upd_date;
	}

	public String getUpd_user() {
		return upd_user;
	}

	public void setUpd_user(String upd_user) {
		this.upd_user = upd_user;
	}

	@Override
	public String toString() {
		return "User_Info [no=" + no + ", u_no=" + u_no + ", u_name=" + u_name + ", u_password=" + u_password
				+ ", gender=" + gender + ", address=" + address + ", mobile_number=" + mobile_number + ", birth_day="
				+ birth_day + ", hire_date=" + hire_date + ", reg_date=" + reg_date + ", upd_date=" + upd_date
				+ ", upd_user=" + upd_user + "]";
	}

}
