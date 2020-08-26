package com.hs.manage.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.hs.manage.entity.Wbs;

public interface WbsService {

	
	public ModelAndView wbslogincheck(String u_no, String u_password);

	public ModelAndView getwbsinfo(String u_no);
	
	public ModelAndView getJoin(String u_no, String date, String mod);
	
	public ModelAndView regWbs2020(String u_no , List<Wbs> wbsList);
}