package com.hs.manage.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="wbs_2020")

@NamedQuery(	
        name = "Wbs_2020.wbscheck2",
        query = "select u from Wbs_2020 u where u.u_no = :u_no"
)

 
public class Wbs_2020 {
	
	   @Id
	   private int no;
	   private String u_no;
	   private String date;
	   private String start_time;
	   private String end_time;
	   private String rest_time;
	   private String vacation_type;
	   private String memo;
	   private String reg_date;
	   private String upd_date;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getRest_time() {
		return rest_time;
	}
	public void setRest_time(String rest_time) {
		this.rest_time = rest_time;
	}
	public String getVacation_type() {
		return vacation_type;
	}
	public void setVacation_type(String vacation_type) {
		this.vacation_type = vacation_type;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
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
	@Override
	public String toString() {
		return "Wbs_2020 [no=" + no + ", u_no=" + u_no + ", date=" + date + ", start_time=" + start_time + ", end_time="
				+ end_time + ", rest_time=" + rest_time + ", vacation_type=" + vacation_type + ", memo=" + memo
				+ ", reg_date=" + reg_date + ", upd_date=" + upd_date + "]";
	}

}