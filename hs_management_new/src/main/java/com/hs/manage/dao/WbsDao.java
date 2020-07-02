package com.hs.manage.dao;

import java.util.List;

import com.hs.manage.entity.Calendar;
import com.hs.manage.entity.User_Info;
import com.hs.manage.entity.Wbs_2020;
import com.hs.manage.entity.WorkPlaceInfo;

public interface WbsDao {

	
	public List<User_Info> wbslogincheck(String u_no, String u_password);

	public List<User_Info> getuserinfo(String u_no);

	public List<Wbs_2020> getwbs2020(String u_no);

	public List<WorkPlaceInfo> getworkplaceinfo(String u_no);

	public List<Calendar> getJoin();

}
