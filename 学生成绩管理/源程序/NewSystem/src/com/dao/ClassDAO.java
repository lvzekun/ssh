package com.dao;

import java.util.List;

import com.bean.Class;
 


public interface ClassDAO {
	 /**
     *�г����а༶
     */
    public  List<Class> findAll();
    //�����û�
    public void update(Class user);
    //��ID��ѯ�û�
    public Class get(Integer uid);
    //��Ӱ༶��Ϣ�ķ�������2017/4/19
    public void save(Class user);
    //ɾ���༶��Ա
  //删除用户
  	public void delete(Class user);

}
