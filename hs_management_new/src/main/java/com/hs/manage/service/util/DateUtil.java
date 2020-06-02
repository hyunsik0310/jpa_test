package com.hs.manage.service.util;

public class DateUtil {

	
	//근무형태 변환 가능
	// 0 : 미표시
	// 1 : 오전휴가
	// 2 : 오후휴가
	// 3 : 종일휴가
	// 4 : 조퇴

	public String vacationCatConv(String vacationCode) {
		
		if("0".equals(vacationCode)) {
			return "";
		}
		else if("1".equals(vacationCode)) {
			return "오전휴가";
		}
		else if("2".equals(vacationCode)) {
			return "오후휴가";
		}
		else if("3".equals(vacationCode)) {
			return "종일휴가";
		}
		else if("4".equals(vacationCode)) {
			return "조퇴";
		}
		else {
			return "";
		}
	}
	
	public double timeConv(String startTime, String endTime, String restTime) {
		
		float start_h = Float.parseFloat(startTime.substring(0,2));
		float start_m = Float.parseFloat(startTime.substring(2,4));
		float end_h = Float.parseFloat(endTime.substring(0,2));
		float end_m = Float.parseFloat(endTime.substring(2,4));
		float rest_h = Float.parseFloat(restTime.substring(0,2));
		float rest_m = Float.parseFloat(restTime.substring(2,4));
		
		float totaltime = end_h + (end_m / 60) - (start_h + (start_m / 60)) - (rest_h + (rest_m / 60));
		
		double result = Math.floor(totaltime*100)/100;
		
		return result;
		
		
		
	}

}
