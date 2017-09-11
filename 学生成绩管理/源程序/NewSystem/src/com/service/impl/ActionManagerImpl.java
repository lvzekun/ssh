package com.service.impl;

import java.util.List;

import org.apache.struts2.ServletActionContext;


import com.bean.Class;
import com.bean.Coures;
import com.bean.Login;
import com.bean.Sh;
import com.bean.ShId;

import com.bean.Studyer;

import com.dao.ClassDAO;
import com.dao.CouresDAO;
import com.dao.ShDAO;
import com.dao.StudyDAO;
import com.dao.UserDAO;
import com.service2.ActionManager;




public class ActionManagerImpl implements ActionManager 
{       
	    private UserDAO userDAO;
	    private ClassDAO classdao;
	    private CouresDAO couresDAO;
	    private StudyDAO studyDAO;
	    private ShDAO shDAO;
	    
 //userDAO调用
	    
	    
		
		public UserDAO getUserDAO()
	    {
	       return this.userDAO;
	    }
	    public void setUserDAO(UserDAO userDAO) 
	    {
		       this.userDAO = userDAO;
		}
//ClassDAO调用
	  		public ClassDAO getClassDAO()
	  		{
	  			// TODO Auto-generated method stub
	  			return this.classdao;
	  		}

	  		public void setClassDAO(ClassDAO classdao)
	  		{
	  			// TODO Auto-generated method stub
	  			this.classdao=classdao;
	  		}
//CouresDAO、、2017/4/19吕泽坤
	  		public CouresDAO getCouresDAO() 
	  		{
				// TODO Auto-generated method stub
				return couresDAO;
			}
	  		
			public void setCouresDAO(CouresDAO couresDAO)
			{
			   this.couresDAO=couresDAO;
			}
//StudyDAO //4/24
			public StudyDAO getStudyDAO() {
				// TODO Auto-generated method stub
				return studyDAO;
			}
			public void setStudyDAO(StudyDAO studyDAO) {
				// TODO Auto-generated method stub
				this.studyDAO=studyDAO;
			}	
//ShDAO
			public ShDAO getShDAO() {
				// TODO Auto-generated method stub
				return this.shDAO;
			}
			public void setShDAO(ShDAO shDAO) {
				// TODO Auto-generated method stub
				this.shDAO=shDAO;
			}
			
		
//方法如下		
		//登录判断
		public Integer validLogin(String username, String password)
		{
	      
	            try {
	                  Login user = userDAO.findUserByNameAndPass(username, password);
	                  if (user!= null)
	                  {
	                     return user.getId();
	                  }
	            }
	            catch (Exception e)
	            {
	                   System.out.println(e.getMessage());
	            }
	             return null;
	    }
		public boolean adduser(Login user) {
			// TODO Auto-generated method stub
			 if (userDAO.get(user.getId())==null)
	            {
	            	
				 userDAO.save(user);
	                System.out.println("添加成功编号不重复");
	            }
	            else
	                return false;
	            return true;
		}
		

//查询列表
		public List<Class> queryAllClass()
		{
			// TODO Auto-generated method stub
			   return classdao.findAll(); 
		}
		//班级更新管理
		public boolean updateClass(Class user)
		{
			// TODO Auto-generated method stub
			  if (classdao.get(user.getId())!=null)
	                classdao.update(user);
	            else
	                return false;
	            return true;

			
		}
		//根据id来查看班级信息
		public Class queryUserByID(int id)
		{
			// TODO Auto-generated method stub
			  return classdao.get(id);

		}
		public boolean addClass(Class user)
		{
			// TODO Auto-generated method stub
			 if (classdao.get(user.getId())==null)
	            {
	            	
	                classdao.save(user);
	                System.out.println("添加班级成功编号不重复");
	            }
	            else
	                return false;
	            return true;
			
		}
		//删除班级
		public boolean deleteClass(Class user) 
		{
			// TODO Auto-generated method stub
			 if (classdao.get(user.getId())!=null)
	                classdao.delete(user);
	            else
	                return false;
	            return true;

			//return false;
		}
		
//课程管理调用方法如下		
		//列出所有课程。
		public List<Coures> queryAllCoures()
		{
			// TODO Auto-generated method stub
			  return couresDAO.findAll();
		}
		//4/21添加课程
        public boolean addCoures(Coures user)
          {
	// TODO Auto-generated method stub
	      if (couresDAO.get(user.getId())==null)
             {
     	
               couresDAO.save(user);
               System.out.println("添加班级成功编号不重复");
             }
          else
            return false;
          return true;
          }
        /***课程管理信息*/
        //获得课程信息
		public Coures queryCouresByID(String id)
		{
			// TODO Auto-generated method stub
			System.out.println("开始获得课程的信息：");
			return couresDAO.get(id);
		}
		//更新课程信息
		public boolean updateCoures(Coures user)
		{
			// TODO Auto-generated method stub
			try
			{
			   if (couresDAO.get(user.getId())!=null)
				 couresDAO.update(user);
				 return true;
			}
			catch (Exception e)
			{
				e.printStackTrace();
				 return false;
			}
			 /* if (couresDAO.get(user.getId())!=null)
				  couresDAO.update(user);
	            else
	                return false;
	            return true;*/
		}
		public boolean deleteCoures(Coures user) 
		{
			// TODO Auto-generated method stub
			 if (couresDAO.get(user.getId())!=null)
	                couresDAO.delete(user);
	            else
	                return false;
	           return true;
		}
//*进行学生的处理方法操作**//		
		
		/*列出方法获得学生信息*/
		public List<Studyer> queryAllStudyer() {
			// TODO Auto-generated method stub
			return studyDAO.findALL();
		
		}
		public boolean addStudyer(Studyer user) {
			// TODO Auto-generated method stub
			
			 if (studyDAO.get(user.getNumber())==null)
	            {
				   System.out.println("添加学生成功编号不重复");
				  studyDAO.save(user);
	           
	           }
	          else
	            return false;
	          return true;
		}
		///删除信息
		public boolean deletestudyer(Studyer user) {
			// TODO Auto-generated method stub
			 if (studyDAO.get(user.getNumber())!=null)
				 studyDAO.delete(user);
	            else
	                return false;
	            return true;

		}
		//获取信息，
		public Studyer queryStudyerByID(String id) {
			// TODO Auto-generated method stub
			return studyDAO.get(id);
		}
		public boolean updateStudyer(Studyer user) {
			// TODO Auto-generated method stub
			if (studyDAO.get(user.getNumber())!=null)
				studyDAO.update(user);
            else
                return false;
            return true;
		}
		
		
/*5、14*/	
		//对于成绩的操作；
		
		public boolean addScore(Sh user)
		{
			//首先  判断是否存在重复。
			//if(shDAO.get(user.getId().getStudyer())==null||shDAO.get2(user.getId().getCoures()))
		    //利用try catch 判断捕获异常进行更新操作； 
			/**当输入如重复无法插入时，捕获异常，返回false,进行数据更新操作。*/
			try{
				shDAO.save(user);
				 return true;
			}catch (Exception e)
			{
				
				e.printStackTrace();
				return false;
				
			}
		      
		          //return true;
			
		}
		
		//根据学号信息获取
		/*public Sh queryShByID(int id) {
			// TODO Auto-generated method stub
			//return shDAO.get(id);
		}
		*/
		//根据课程编号信息获取
	    
		
		public boolean updateScore(Sh user) {
			// TODO Auto-generated method stub
			 
				shDAO.update(user);
          
                return true;
		}
		public List<Sh> queryAllScore() {
			// TODO Auto-generated method stub
			return shDAO.findAll();
		}
		public Sh queryShByScore(String number) {
			// TODO Auto-generated method stub
			return  shDAO.get( number);
		}
		public List<Sh> getByStudentId(String number) {
			System.out.println("开始：");
			// TODO Auto-generated method stub
			return shDAO.getGradeByStudentId(number);
		}
		public Coures queryCouresID(String id) {
			// TODO Auto-generated method stub
			return shDAO.get2(id);
			}
		//根据课程编号获取成绩信息
		
		public List<Sh> getById2(String id) {
			// TODO Aut	return shDAO.getGradeByStudentId(number);o-generated method stub
			return shDAO.getGradeByStudentId2(id);
		}
		public List<Coures> queryAllCoures2() {
			// TODO Auto-generated method stub
			return shDAO.finAll();
		}
		/**用户注册*/
						
		

		
		
		
		
		
		
		

			   
		

		
		
		

		
		
			

		

		

		

		

}
