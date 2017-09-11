package com;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.bean.Class;
import com.dao.ClassDAO;
import com.dao.impl.ClassDAOImpl;

import com.opensymphony.xwork2.ActionSupport;
import com.service2.ActionManager;





public class ClassAction extends ActionSupport {
	 private ClassDAO classdao = new ClassDAOImpl();
	
	 private ActionManager dao;
	 private int id;
		// Integer id;
	 private String className;
	 
	 public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public ActionManager getDao() {
		return dao;
	}

	public void setDao(ActionManager dao) {
		this.dao = dao;
	}
	
	public ClassDAO getClassdao() {
		return classdao;
	}

	public void setClassdao(ClassDAO classdao) {
		this.classdao = classdao;
	}
//添加班级
	public String addclass() throws  Exception 
	{
		Class user=new Class();
    	//user.setId(id);
        user.setId(id);
        user.setClassName(className);
        
        if (dao.addClass(user))
        {
        	System.out.print(id+className+"添加班级成功");
            return "SUCCESS";
        }
        else
            return "ERROR";
		//return "SUCCESS";
	}

	
    //列出所有班级信息
	public String list() throws  Exception 
	   {
		 List<Class> allUserList=dao.queryAllClass();
		 ServletActionContext.getRequest().setAttribute("allUserList", allUserList);
		   //杩斿洖璇锋眰allUserList缁橪istAllUser.jsp
	     return "SUCCESS";
	    }
	
	
	/*修改信息：先编辑一个班级信息，在修改班级信息*/
	//编辑一个
	public String preupdate() throws  Exception 
	{
		 Class user=dao.queryUserByID(id);
         ServletActionContext.getRequest().setAttribute("user",user);//传值到jsp界面
         return "SUCCESS";

		
	}
	
	
	
	//所有班级信息的修改
	public String update() throws  Exception 
	
	{
		Class user=new Class();
		user.setId(id);
		user.setClassName(className);
		if(dao.updateClass(user))
		{
			
			
			    
			   
			return "SUCCESS";
		}
	      else
	           {return "ERROR";}
		
	}
	//删除班级
	public String  d() throws Exception
	{
		System.out.println("开始删除");
	    Class user=dao.queryUserByID(id);
	    user.setId(id);
	    
        ServletActionContext.getRequest().setAttribute("user",user);
        System.out.println(user+"班级");
	   if(dao.deleteClass(user))
	   {
		    return "SUCCESS";
	   }
	   else
	   {
		   return "ERROR";	   }
	//return className;
		
	}
}
