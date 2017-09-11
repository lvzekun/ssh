package com.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bean.Class;
import com.bean.Coures;
import com.dao.CouresDAO;

public class CouresDAOImpl extends HibernateDaoSupport implements CouresDAO {
    
	/*��һ���鿴ѧ��
	 * 
	 * 
	 * */
	
	public List<Coures> findAll() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from com.bean.Coures");
	}

	/*
	 *����id���鿴�û�*/
	
	public Coures get(String id) {
		// TODO Auto-generated method stub
		   return (Coures)this.getHibernateTemplate().get(Coures.class,id);
	}
   //��ӿγ̡�4/21
	public void save(Coures user) {
		// TODO Auto-generated method stub
		 this.getHibernateTemplate().save(user);
	}
    //�޸Ŀγ�4/21
	public void update(Coures user) {
		// TODO Auto-generated method stub
		 this.getHibernateTemplate().update(user);
	}
    //4/22ɾ���γ�
	public void delete(Coures user) {
		// TODO Auto-generated method stub
		 this.getHibernateTemplate().delete(user);
	}

}
