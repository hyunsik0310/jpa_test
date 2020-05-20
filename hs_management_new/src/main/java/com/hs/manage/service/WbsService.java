package com.hs.manage.service;

import org.springframework.web.servlet.ModelAndView;

public interface WbsService {

	
	public ModelAndView wbslogincheck(String u_no, String u_password);

	public ModelAndView wbsloginato(String u_no);

	}
	
	

