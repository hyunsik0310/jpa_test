package com.hs.manage.dao;

import java.util.List;

import com.hs.manage.entity.User_Info;
import com.hs.manage.entity.Wbs_2020;
import com.hs.manage.entity.Workplaceinfo;

public interface WbsDao {

	
	public List<User_Info> wbslogincheck(String u_no, String u_password);

	public List<User_Info> wbsloginato(String u_no);

	public List<Wbs_2020> wbsloginato2(String u_no);

	public List<Workplaceinfo> wbsloginato3(String u_no);

}
