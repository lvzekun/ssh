package com.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bean.Class;
import com.bean.Coures;
import com.dao.CouresDAO;

public class CouresDAOImpl extends HibernateDaoSupport implements CouresDAO {
    
	/*第一步查看学科
	 * 
	 * 
	 * */
	
	public List<Coures> findAll() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from com.bean.Coures");
	}

	/*
	 *根据id来查看用户*/
	
	public Coures get(String id) {
		// TODO Auto-generated method stub
		   return (Coures)this.getHibernateTemplate().get(Coures.class,id);
	}
   //添加课程、4/21
	public void save(Coures user) {
		// TODO Auto-generated method stub
		 this.getHibernateTemplate().save(user);
	}
    //修改课程4/21
	public void update(Coures user) {
		// TODO Auto-generated method stub
		 this.getHibernateTemplate().update(user);
	}
    //4/22删除课程
	public void delete(Coures user) {
		// TODO Auto-generated method stub
		 this.getHibernateTemplate().delete(user);
	}

}
