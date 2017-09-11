package com.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
//import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bean.Class;
import com.dao.ClassDAO;

public class ClassDAOImpl extends HibernateDaoSupport  implements ClassDAO {
     //列出班级所偶有信息
	public List<Class> findAll() {
		// TODO Auto-generated method stub
		 return getHibernateTemplate().find("from com.bean.Class");
	}
     //更新修改班级
	public void update(Class user) {
		// TODO Auto-generated method stub
		  this.getHibernateTemplate().update(user);

	}
	
	//根据班级编号查看班级信息
	public Class get(Integer id) {
		// TODO Auto-generated method stub
		   return (Class)this.getHibernateTemplate().get(Class.class,id);
	}
	//添加班级信息4/19
	
	public void save(Class user) {
		// TODO Auto-generated method stub
         this.getHibernateTemplate().save(user);
	}
	//删除班级成员4/19
	public void delete(Class user) {
		
	
	  this.getHibernateTemplate().delete(user);
	}
	/*public Object doInHibernate(Session arg0) throws HibernateException,
			SQLException {
		// TODO Auto-generated method stub
		return null;
	}*/
	
	
   }
