package com.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;


import com.bean.Coures;
import com.bean.Sh;
import com.bean.ShId;
import com.bean.Studyer;

import com.dao.ShDAO;
//import com.xuan.cms.entities.Grade;

public  class ShDAOImpl  extends HibernateDaoSupport   implements ShDAO {

	//实现添加成绩
	public void save(Sh user) {
		// TODO Auto-generated method stub
		 this.getHibernateTemplate().save(user);
		
	}
//根据学号，成绩分别来产看数据记录get,get2

	
	//进行跟新
	public void update(Sh user) {
		// TODO Auto-generated method stub
		 this.getHibernateTemplate().update(user);
	}




	



	public List<Sh> findAll() {
		// TODO Auto-generated method stub
		 return getHibernateTemplate().find("from com.bean.Sh");
	}
	public Sh get(String number) {
		// TODO Auto-generated method stub
		   return (Sh)this.getHibernateTemplate().get(Sh.class,number);
	}
	public Coures get2(String id) {
		// TODO Auto-generated method stub
		   return (Coures)this.getHibernateTemplate().get(Coures.class,id);
	}
	@Transactional
	public List<Sh> getGradeByStudentId(String number) {
		List<Sh> list = null;
		Studyer stu = new Studyer();
		stu.setNumber(number);
		ShId sh = new ShId();
		sh.setStudyer(stu);
		//System.out.println(sh);
		try
		{
			list = getHibernateTemplate().find("from com.bean.Sh u where u.id.studyer.number="+number);
			//return getHibernateTemplate().find("from com.bean.Sh u where u.id.studyer.number=?",number);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
		// TODO Auto-generated method stub
		 
		
	}

//根据课程编号主键，获取成绩表中的成绩显示
	

	public List<Sh> getGradeByStudentId2(String id) {
		// TODO Auto-generated method stub
		List<Sh> list = null;
		
		//System.out.println(sh);
		
		try
		{
			list = getHibernateTemplate().find("from com.bean.Sh u where u.id.coures.id= "+id);
			System.out.println(id);
			//return getHibernateTemplate().find("from com.bean.Sh u where u.id.studyer.number=?",number);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
		// TODO Auto-generated method stub
		 
		
	}


	public List<Coures> finAll() {
		// TODO Auto-generated method stub
		return  getHibernateTemplate().find("from com.bean.Coures");
	}
	

	



	

	
}
