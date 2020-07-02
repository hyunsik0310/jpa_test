package com.hs.manage.service;

import org.springframework.web.servlet.ModelAndView;

public interface WbsService {

	
	public ModelAndView wbslogincheck(String u_no, String u_password);

	public ModelAndView getwbsinfo(String u_no);
	
	public ModelAndView getJoin(String u_no);

	}
	
	

