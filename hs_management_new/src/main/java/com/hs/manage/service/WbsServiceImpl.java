package com.hs.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.hs.manage.dao.WbsDao;
import com.hs.manage.entity.User_Info;
import com.hs.manage.entity.WbsInfoVo;
import com.hs.manage.entity.Wbs_2020;
import com.hs.manage.entity.Workplaceinfo;

@Service
public class WbsServiceImpl implements WbsService {

	@Autowired
	WbsDao wbsdao;
	
	
	@Override
	public ModelAndView wbslogincheck (String u_no, String u_password) {
		
		List<User_Info> wbs1 = wbsdao.wbslogincheck(u_no, u_password);
		
		ModelAndView mv = new ModelAndView();
		
		int count = wbs1.size();		
		
		if(count == 1) {
			mv.setViewName("redirect:/wbsloginato");
		}else {
			mv.setViewName("home");
		}
		
		return mv;
	}@Override
	public ModelAndView wbsloginato (String u_no) {
		
		ModelAndView mv = new ModelAndView();
		
		WbsInfoVo wbsinfovo = new WbsInfoVo();

		List<User_Info> wbs1 = wbsdao.wbsloginato(u_no);
			for (User_Info user_info : wbs1) {
			wbsinfovo.setU_name(user_info.getU_name());
			wbsinfovo.setU_no(user_info.getU_no());
			}
		List<Wbs_2020> wbs2 = wbsdao.wbsloginato2(u_no);
			wbsinfovo.setWbsinfovo_list(wbs2);
		
		List<Workplaceinfo> wbs3 = wbsdao.wbsloginato3(u_no);
			for (Workplaceinfo workplaceinfo : wbs3) {
				wbsinfovo.setMin_time(workplaceinfo.getMin_time());
				wbsinfovo.setMax_time(workplaceinfo.getMax_time());
			}
		
			mv.addObject("wbsinfovo", wbsinfovo);
			mv.setViewName("wbs");

		return mv;
	}
	
	
	
}
