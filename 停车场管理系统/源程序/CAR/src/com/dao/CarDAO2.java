package com.dao;

import java.util.List;

import com.bean.CarBackUp;



public interface CarDAO2 {
	 /**
     *�г����а༶
     */
    public  List<CarBackUp> findAll();
    
    //��������ѯ�û�
    public CarBackUp get(String numcar);
    
    //�����Ϣ�ķ�������2017/4/19
    public void save(CarBackUp user);
}
