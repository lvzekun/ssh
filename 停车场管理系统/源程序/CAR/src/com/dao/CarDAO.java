package com.dao;

import java.util.List;

import com.bean.CarBackUp;
import com.bean.Cartime;




public interface CarDAO {
	 /**
     *列出所有汽车
     */
    public  List<Cartime> findAll();
    
    //按车辆查询用户
    public Cartime get(String numcar);
    
    //添加信息的方法、、2017/4/19
    public void save(Cartime user);
    public void delete(Cartime user);
    
    
}
