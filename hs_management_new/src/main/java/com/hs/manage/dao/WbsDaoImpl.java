package com.hs.manage.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hs.manage.entity.Calendar;
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

	@Override
	public List<Calendar> getJoin(String date) {
		EntityManager em = conn.getConnection();
		List<Calendar> result = em.createNamedQuery("Calendar.jointest", Calendar.class).
				setParameter("yyyy", date.substring(0, 4)).
				setParameter("mm", date.substring(4, 6)).
				getResultList();
				
		return result;
	}

	@Override
	public int regWbs2020(List<Wbs_2020> wbsList) {
		EntityManager em = conn.getConnection();	
		
		em.getTransaction().begin();
		try {
			for(Wbs_2020 wbs : wbsList) {
				em.persist(wbs);
			}
			em.getTransaction().commit();
			
			return wbsList.size();
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			return 8;
		}
		
		
	}

	
	

}
