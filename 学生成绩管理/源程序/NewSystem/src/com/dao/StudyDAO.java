package com.dao;

import java.util.List;




import com.bean.Studyer;

public interface StudyDAO {
	/*列出所有班级
	    */
	   public  List<Studyer> findALL();
	  //按照 学号查看学生
	   public Studyer get(String id);
	  //添加课程信息的方法、、2017/4/19
	   public void save(Studyer user);
	   //删除学生信息
	   public void delete(Studyer user);
	   //更新用户
	    public void update(Studyer user);
		
	
}
