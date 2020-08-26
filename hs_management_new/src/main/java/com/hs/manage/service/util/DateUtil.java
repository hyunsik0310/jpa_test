package com.hs.manage.service.util;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class DateUtil {
//근무형태 변환 기능
	// 0 : 미표시
	// 1 : 오전휴가
	// 2 : 오후휴가
	// 3 : 종일휴가
	// 4 : 조퇴
	public String vacationCatConv(String vacationcode) {
		if("0".equals(vacationcode)) {
			return "";
		} else if ("1".equals(vacationcode)) {
			return "오전휴가";
		} else if ("2".equals(vacationcode)) {
		 	return "오후휴가";
		} else if ("3".equals(vacationcode)) {
			return "종일휴가";
		} else if ("4".equals(vacationcode)) {
			return "조퇴";
		} else {
			return "";
		}
	}
	
	
	public String timeConv(String startTime, String endTime, String restTime) {
		
		//시작시간
		float start_h = (Float.parseFloat(startTime.substring(0,2)));
		float start_m = (Float.parseFloat(startTime.substring(2,4)));
		//종료시간
		float end_h = (Float.parseFloat(endTime.substring(0,2)));
		float end_m = (Float.parseFloat(endTime.substring(2,4)));
		//휴식시간
		float break_h = (Float.parseFloat(restTime.substring(0,2)));
		float break_m = (Float.parseFloat(restTime.substring(2,4)));
		
		//일근무합계시간 = 종료시간-시작시간-휴식시간
		float totalTime = end_h + (end_m / 60) - (start_h + (start_m / 60)) - (break_h + (break_m / 60));
		
		//소수점.00까지표시되는 처리
		DecimalFormat formatter = new DecimalFormat("0.00");
		String totalTimeString = formatter.format(totalTime);
		
		return totalTimeString;
	}
	
		//날짜변환
		public String dayColorConv(String day) {
			if("5".equals(day)) {
				return "blue";
			} else if("6".equals(day)) {
				return "red";
			} else {
				return "black";
			}
		}
		
		//날짜 주말 색표시
		public String dayConv(String day) {
			if("0".equals(day)) {
				return "(MON)";
			} else if("1".equals(day)) {
				return "(TUE)";
			} else if("2".equals(day)) {
				return "(WED)";
			} else if("3".equals(day)) {
				return "(TUR)";
			} else if("4".equals(day)) {
				return "(FRI)";
			} else if("5".equals(day)) {
				return "(SAT)";
			} else if("6".equals(day)) {
				return "(SUN)";
			} else {
				return "";
			}
		}


		public String[] getToday() {
			LocalDate today = LocalDate.now();
			String yyyy = today.toString().substring(0, 4);
			String mm = today.toString().substring(5, 7);
			String[] date = {yyyy,mm};
			
			return date;
		}
}
