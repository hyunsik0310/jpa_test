package com.hs.manage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.hs.manage.dao.WbsDao;
import com.hs.manage.entity.Calendar;
import com.hs.manage.entity.User_Info;
import com.hs.manage.entity.Wbs;
import com.hs.manage.entity.WbsInfoVo;
import com.hs.manage.entity.Wbs_2020;
import com.hs.manage.entity.WorkPlaceInfo;
import com.hs.manage.service.util.DateUtil;

@Service
public class WbsServiceImpl implements WbsService {

	@Autowired
	WbsDao wbsdao;
	
	@Override
	public ModelAndView wbslogincheck (String u_no, String u_password) {
		
		List<User_Info> result = wbsdao.wbslogincheck(u_no, u_password);
		
		int count = result.size();		
		
		ModelAndView mv = new ModelAndView();
		
		if(count == 1) {
			mv.addObject("u_no", u_no);
			mv.setViewName("redirect:getwbsinfo");
		}else {
			mv.setViewName("home");
		}
		
		return mv;
	}@Override
	public ModelAndView getwbsinfo (String u_no) {
		
		ModelAndView mv = new ModelAndView("wbs");
		DateUtil dateUtil = new DateUtil();
		
		List<Wbs_2020> wbs_2020 = new ArrayList<Wbs_2020>();
		List<User_Info> user_info = new ArrayList<User_Info>();
		List<WorkPlaceInfo> workplaceinfo = new ArrayList<WorkPlaceInfo>();
		
		user_info = wbsdao.getuserinfo(u_no);
		wbs_2020 = wbsdao.getwbs2020(u_no);
		workplaceinfo = wbsdao.getworkplaceinfo(u_no);
		
		WbsInfoVo vo = new WbsInfoVo();
		vo.setU_name(user_info.get(0).getU_name());
		vo.setU_no(user_info.get(0).getU_no());
		vo.setMax_time(String.valueOf(workplaceinfo.get(0).getMax_time()));
		vo.setMin_time(String.valueOf(workplaceinfo.get(0).getMin_time()));
		
		List<Wbs> wbslist = new ArrayList<Wbs>();
		
		for(Wbs_2020 wbs : wbs_2020) {
			Wbs wbsvo = new Wbs();
			wbsvo.setDate(wbs.getDate());
			wbsvo.setStart_h(wbs.getStart_time().substring(0,2));
			wbsvo.setStart_m(wbs.getStart_time().substring(2,4));
			wbsvo.setEnd_h(wbs.getEnd_time().substring(0, 2));
			wbsvo.setEnd_m(wbs.getEnd_time().substring(2, 4));
			
//			int time = (((Integer.valueOf(wbsvo.getEnd_h())*60 + Integer.valueOf(wbsvo.getEnd_m())) -
//					(Integer.valueOf(wbsvo.getStart_h())*60 + Integer.valueOf(wbsvo.getStart_m())))/60);
//			int minute = (((Integer.valueOf(wbsvo.getEnd_h())*60 + Integer.valueOf(wbsvo.getEnd_m())) -
//					(Integer.valueOf(wbsvo.getStart_h())*60 + Integer.valueOf(wbsvo.getStart_m())))%60);
//
//			int totaltime = time*60 + minute; 
//			
//			wbsvo.setTotal_h(String.valueOf(time));
//			wbsvo.setTotal_m(String.valueOf(minute));
//			
//			wbsvo.setTotaltime_h(totaltime);

			wbsvo.setRest_h(wbs.getRest_time().substring(0,2));
			wbsvo.setRest_m(wbs.getRest_time().substring(2,4));
			wbsvo.setTotal_h(String.valueOf(dateUtil.timeConv(wbs.getStart_time(), wbs.getEnd_time(), wbs.getRest_time())));
//			wbsvo.setVacation_type(dateUtil.vacationCatConv(wbs.getVacation_type()));
			wbsvo.setVacation_type(wbs.getVacation_type());
			wbsvo.setMemo(wbs.getMemo());

			wbslist.add(wbsvo);
		}
		
		vo.setWbslist(wbslist);
		
		mv.addObject("wbsinfo", vo);
		
		return mv;
	}
	
	@Override
	public ModelAndView getJoin(String u_no) {
		
		ModelAndView mv = new ModelAndView("wbs");
		DateUtil dateUtil = new DateUtil();
		
		List<Calendar> calendarList = new ArrayList<Calendar>();
		List<User_Info> user_Info = new ArrayList<User_Info>();
		List<WorkPlaceInfo> workplaceinfo = new ArrayList<WorkPlaceInfo>();
		//List<Wbs_2020> wbs_2020 = new ArrayList<Wbs_2020>();
		
		user_Info = wbsdao.getuserinfo(u_no);
		workplaceinfo = wbsdao.getworkplaceinfo(u_no);
		calendarList = wbsdao.getJoin();
		
		WbsInfoVo vo = new WbsInfoVo();
		
		vo.setU_name(user_Info.get(0).getU_name());
		vo.setU_no(user_Info.get(0).getU_no());
		vo.setMin_time(String.valueOf(workplaceinfo.get(0).getMin_time()));
		vo.setMax_time(String.valueOf(workplaceinfo.get(0).getMax_time()));
		
		List<Wbs> wbslist = new ArrayList<Wbs>();
		
		for(Calendar calendar : calendarList) {
			Wbs wbsvo = new Wbs();
			Wbs_2020 wbs_2020 = calendar.getWbs_2020();
			wbsvo.setDate(calendar.getYyyymmdd());
			
	         if(wbs_2020 != null) {
	             wbsvo.setStart_h(wbs_2020.getStart_time().substring(0, 2));
	             wbsvo.setStart_m(wbs_2020.getStart_time().substring(2, 4));
	             wbsvo.setEnd_h(wbs_2020.getEnd_time().substring(0, 2));
	             wbsvo.setEnd_m(wbs_2020.getEnd_time().substring(2, 4));
	             wbsvo.setTotal_h(dateUtil.timeConv(wbs_2020.getStart_time(), wbs_2020.getEnd_time(), wbs_2020.getRest_time()));
	             wbsvo.setVacation_type(dateUtil.vacationCatConv(wbs_2020.getVacation_type())); // 과제
	             wbsvo.setMemo(wbs_2020.getMemo());
	          } else {
	             wbsvo.setStart_h("00");
	             wbsvo.setStart_m("00");
	             wbsvo.setEnd_h("00");
	             wbsvo.setEnd_m("00");
	             wbsvo.setTotal_h("0.00");
	             wbsvo.setVacation_type(""); // 과제
	             wbsvo.setMemo("");
	          }
			wbslist.add(wbsvo);
		}
		
		vo.setWbslist(wbslist);
		
		mv.addObject("wbsinfo", vo);
		
		return mv;
		
	}
	
	
}
