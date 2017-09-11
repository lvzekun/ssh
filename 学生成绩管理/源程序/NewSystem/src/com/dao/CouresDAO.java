package com.dao;//2017/4/19下午吕泽坤进行课程的crud
import java.util.List;


import com.bean.Coures;
public interface CouresDAO{
	/*列出所有班级
    */
   public  List<Coures> findAll();
   
   //按照 ID查看学科
   public Coures get(String id);
   //添加课程信息的方法、、2017/4/19
   public void save(Coures user);
   //修改课程信息。2017、4/21吕泽坤
   public void update(Coures user);
   //删除班级成员
   //鍒犻櫎鐢ㄦ埛
   	public void delete(Coures user);
}
