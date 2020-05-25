package com.hs.manage.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hs.manage.entity.User_Info;
import com.hs.manage.entity.Wbs_2020;
import com.hs.manage.entity.WorkPlaceInfo;

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
	public List<User_Info> getuserinfo(String u_no) {

		EntityManager em = conn.getConnection();
		
		List<User_Info> result = em.createNamedQuery("User_Info.findByu_no", User_Info.class).
				setParameter("u_no", u_no).
				getResultList();
	
		return result;
	}

	@Override
	public List<Wbs_2020> getwbs2020(String u_no) {

		EntityManager em = conn.getConnection();
		
		List<Wbs_2020> result = em.createNamedQuery("Wbs_2020.findByu_no", Wbs_2020.class).
				setParameter("u_no", u_no).
				getResultList();
	
		return result;
	}

	@Override
	public List<WorkPlaceInfo> getworkplaceinfo(String u_no) {

		EntityManager em = conn.getConnection();
		
		List<WorkPlaceInfo> result = em.createNamedQuery("WorkPlaceInfo.findByu_no", WorkPlaceInfo.class).
				setParameter("u_no", u_no).
				getResultList();
	
		return result;
	}
	
	

}
