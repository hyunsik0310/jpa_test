package com.hs.manage.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter
@ToString
public class WbsInfoVo {
	
	private String u_no;
	private String u_name;
	private String min_time;
	private String max_time;
	List<Wbs> wbslist = new ArrayList<Wbs>();
	
	
}
