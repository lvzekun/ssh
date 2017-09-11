package com.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import com.bean.Studyer;
import com.dao.StudyDAO;

public class StudyDAOImpl  extends HibernateDaoSupport implements StudyDAO {
/*4/24号列出学生信息*/
	public List<Studyer> findALL() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from com.bean.Studyer");
	}
//获取学生信息
	public Studyer get(String number) {
		// TODO Auto-generated method stub
		  return (Studyer)this.getHibernateTemplate().get(Studyer.class,number);
	}

	public void save(Studyer user) {
		// TODO Auto-generated method stub
		 this.getHibernateTemplate().save(user);
	}

	public void delete(Studyer user) {
		// TODO Auto-generated method stub
		  this.getHibernateTemplate().delete(user);
	}
	//修改学生信息
	public void update(Studyer user) {
		// TODO Auto-generated method stub
		 this.getHibernateTemplate().update(user);
	}


}
