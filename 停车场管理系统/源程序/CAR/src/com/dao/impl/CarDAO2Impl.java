package com.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bean.CarBackUp;

import com.dao.CarDAO2;

public class CarDAO2Impl extends HibernateDaoSupport implements CarDAO2 {
 ///查看停车场
	public List<CarBackUp> findAll() {
		// TODO Auto-generated method stub
		 return getHibernateTemplate().find("from com.bean.CarBackUp");
	}
//获取汽车数据
	public CarBackUp get(String numcar) {
		// TODO Auto-generated method stub
		  return (CarBackUp)this.getHibernateTemplate().get(CarBackUp.class,numcar);
	}
	public void save(CarBackUp user) {
		// TODO Auto-generated method stub
		  this.getHibernateTemplate().save(user);
	}

}
