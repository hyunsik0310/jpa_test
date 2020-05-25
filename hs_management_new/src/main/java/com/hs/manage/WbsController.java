package com.hs.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hs.manage.service.WbsService;

@Controller
public class WbsController {

	
	@Autowired
	WbsService WbsService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		
		ModelAndView mv = new ModelAndView("home");

		return mv;
	}
	
	
	@RequestMapping("wbslogincheck")
	public ModelAndView wbslogincheck (String u_no , String u_password) {
		
		ModelAndView mv = WbsService.wbslogincheck(u_no, u_password);

		return mv;
	}
	

	@RequestMapping("getwbsinfo")
	public ModelAndView getwbsinfo(String u_no) {

		ModelAndView mv = WbsService.getwbsinfo(u_no);

		return mv;
	}
	
	
}
