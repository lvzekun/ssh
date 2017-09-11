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
//��Ӱ༶
	public String addclass() throws  Exception 
	{
		Class user=new Class();
    	//user.setId(id);
        user.setId(id);
        user.setClassName(className);
        
        if (dao.addClass(user))
        {
        	System.out.print(id+className+"��Ӱ༶�ɹ�");
            return "SUCCESS";
        }
        else
            return "ERROR";
		//return "SUCCESS";
	}

	
    //�г����а༶��Ϣ
	public String list() throws  Exception 
	   {
		 List<Class> allUserList=dao.queryAllClass();
		 ServletActionContext.getRequest().setAttribute("allUserList", allUserList);
		   //返回请求allUserList给ListAllUser.jsp
	     return "SUCCESS";
	    }
	
	
	/*�޸���Ϣ���ȱ༭һ���༶��Ϣ�����޸İ༶��Ϣ*/
	//�༭һ��
	public String preupdate() throws  Exception 
	{
		 Class user=dao.queryUserByID(id);
         ServletActionContext.getRequest().setAttribute("user",user);//��ֵ��jsp����
         return "SUCCESS";

		
	}
	
	
	
	//���а༶��Ϣ���޸�
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
	//ɾ���༶
	public String  d() throws Exception
	{
		System.out.println("��ʼɾ��");
	    Class user=dao.queryUserByID(id);
	    user.setId(id);
	    
        ServletActionContext.getRequest().setAttribute("user",user);
        System.out.println(user+"�༶");
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
