package com.dao;

import java.util.List;

import com.bean.CarBackUp;
import com.bean.Cartime;




public interface CarDAO {
	 /**
     *�г���������
     */
    public  List<Cartime> findAll();
    
    //��������ѯ�û�
    public Cartime get(String numcar);
    
    //�����Ϣ�ķ�������2017/4/19
    public void save(Cartime user);
    public void delete(Cartime user);
    
    
}
