package com.dao.impl;
//吕泽坤
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bean.CarBackUp;
import com.bean.Cartime;

import com.dao.CarDAO;

public class CarDAOImpl extends HibernateDaoSupport implements CarDAO {
 ///查看停车场
	public List<Cartime> findAll() {
		// TODO Auto-generated method stub
		 return getHibernateTemplate().find("from com.bean.Cartime");
	}
//获取汽车数据
	public Cartime get(String numcar) {
		// TODO Auto-generated method stub
		  return (Cartime)this.getHibernateTemplate().get(Cartime.class,numcar);
	}
	public void save(Cartime user) {
		// TODO Auto-generated method stub
		  this.getHibernateTemplate().save(user);
	}
	public void delete(Cartime user) {
		// TODO Auto-generated method stub
		 this.getHibernateTemplate().delete(user);
	}
	

}
