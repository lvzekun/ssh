package com.dao;


import java.util.List;


import com.bean.Sh;
import com.bean.ShId;
import com.bean.Studyer;
import com.bean.Coures;



public interface ShDAO {
    //5、14添加成绩
	public void save(Sh user);
	
	
    public void update(Sh user);
    //获取数据（两个主键）
    public  List<Sh> findAll();
    //按照 学号查看学生
	public Sh get( String number);
    public List<Sh> getGradeByStudentId(String number);

    //添加一个根据课程编号，获得信息方法
    public Coures get2(String id);
    public List<Coures> finAll();
    //根据课程编号来查看课程成绩；显示
    public List<Sh> getGradeByStudentId2(String id);
    

	
    

	


	
		

	


	


	//public Sh get(Integer number);
	
} 
