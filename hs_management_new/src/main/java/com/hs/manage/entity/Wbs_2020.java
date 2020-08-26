package com.hs.manage.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="wbs_2020")

@NamedQuery(	
        name = "Wbs_2020.findByu_no",
        query = "select u from Wbs_2020 u where u.u_no = :u_no"
)

@Getter @Setter 
public class Wbs_2020 {
		//@GeneratedValue
	    @Id
		private String date;
		private String u_no;
		private String start_time;
		private String end_time;
		private String rest_time;
		private String vacation_type;
		private String memo;
		private String reg_date;
		private String upd_date;
		
		
		

}