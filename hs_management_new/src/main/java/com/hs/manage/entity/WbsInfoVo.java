package com.hs.manage.entity;

import java.util.ArrayList;
import java.util.List;



public class WbsInfoVo {
	
	private String u_no;
	private String u_name;
	private int min_time;
	private int max_time;
	List<Wbs_2020> wbsinfovo_list = new ArrayList<Wbs_2020>();

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
	public int getMin_time() {
		return min_time;
	}
	public void setMin_time(int min_time) {
		this.min_time = min_time;
	}
	public int getMax_time() {
		return max_time;
	}
	public void setMax_time(int max_time) {
		this.max_time = max_time;
	}
	public List<Wbs_2020> getWbsinfovo_list() {
		return wbsinfovo_list;
	}
	public void setWbsinfovo_list(List<Wbs_2020> wbsinfovo_list) {
		this.wbsinfovo_list = wbsinfovo_list;
	}
	@Override
	public String toString() {
		return "WbsInfoVo [u_no=" + u_no + ", u_name=" + u_name + ", min_time=" + min_time + ", max_time=" + max_time
				+ ", wbsinfovo_list=" + wbsinfovo_list + "]";
	}


}
