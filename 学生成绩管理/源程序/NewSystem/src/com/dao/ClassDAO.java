package com.dao;

import java.util.List;

import com.bean.Class;
 


public interface ClassDAO {
	 /**
     *列出所有班级
     */
    public  List<Class> findAll();
    //更新用户
    public void update(Class user);
    //按ID查询用户
    public Class get(Integer uid);
    //添加班级信息的方法、、2017/4/19
    public void save(Class user);
    //删除班级成员
  //鍒犻櫎鐢ㄦ埛
  	public void delete(Class user);

}
