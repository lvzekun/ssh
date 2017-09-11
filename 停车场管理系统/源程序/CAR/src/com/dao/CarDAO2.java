package com.dao;

import java.util.List;

import com.bean.CarBackUp;



public interface CarDAO2 {
	 /**
     *列出所有班级
     */
    public  List<CarBackUp> findAll();
    
    //按车辆查询用户
    public CarBackUp get(String numcar);
    
    //添加信息的方法、、2017/4/19
    public void save(CarBackUp user);
}
