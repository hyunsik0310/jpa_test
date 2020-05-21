package com.hs.manage.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hs.manage.entity.User_Info;
import com.hs.manage.entity.Wbs_2020;
import com.hs.manage.entity.Workplaceinfo;

@Repository
public class WbsDaoImpl implements WbsDao {

	@Autowired
	Connection conn;
	
	@Override
	public List<User_Info> wbslogincheck(String u_no, String u_password){

		EntityManager em = conn.getConnection();
		
		List<User_Info> wbs1 = em.createNamedQuery("User_Info.findByuserinfo", User_Info.class).
				setParameter("u_no", u_no).
				setParameter("u_password", u_password).
				getResultList();
	
		return wbs1;
	}
	@Override
	public List<User_Info> wbsloginato(String u_no){
		EntityManager em = conn.getConnection();
		
		List<User_Info> wbs1 = em.createNamedQuery("User_Info.findByuserinfo2", User_Info.class).
				setParameter("u_no", u_no).
				getResultList();
	
		return wbs1;
	}
	
	@Override
	public List<Wbs_2020> wbsloginato2(String u_no){

		EntityManager em = conn.getConnection();
		
		List<Wbs_2020> wbs2 = em.createNamedQuery("Wbs_2020.wbscheck2", Wbs_2020.class).
				setParameter("u_no", u_no).
				getResultList();
	
		return wbs2;
	}
	@Override
	public List<Workplaceinfo> wbsloginato3(String u_no){

		EntityManager em = conn.getConnection();
		
		List<Workplaceinfo> wbs3 = em.createNamedQuery("Workplaceinfo.wbscheck3", Workplaceinfo.class).
				setParameter("u_no", u_no).
				getResultList();
	
		return wbs3;
	}

	

}
