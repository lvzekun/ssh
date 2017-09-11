package com.service2;
import java.util.List;

import com.bean.Coures;
import com.bean.Login;
import com.bean.Class;
import com.bean.Sh;
import com.bean.ShId;

import com.bean.Studyer;

import com.dao.ClassDAO;
import com.dao.CouresDAO;
import com.dao.ShDAO;
import com.dao.StudyDAO;
import com.dao.UserDAO;


public interface ActionManager {
	    //登录判断
	    public Integer validLogin(String username , String password);
	    //注册
	    public boolean adduser(Login user);
	    //public boolean addUser(User user);
        //userdao
	    public UserDAO getUserDAO();
	    public void setUserDAO(UserDAO userDAO);
	    
	  //方法查看班级
	    public ClassDAO getClassDAO();
	    
	    public void setClassDAO(ClassDAO classdao);
	   //方法对课程 
	   public CouresDAO getCouresDAO();
	   public void setCouresDAO(CouresDAO couresDAO);
	  //方法对学生的操作
	    public StudyDAO getStudyDAO();
	    public void setStudyDAO(StudyDAO studyDAO);
	  //方法成绩的操作
	    public ShDAO getShDAO();
	    public void setShDAO(ShDAO shDAO);
	    
	    /* 班级查看列表*/
	    
	        public List<Class> queryAllClass();
        
        
        /*班级修改信息*/
        
            //按ID查询用户
             public Class queryUserByID(int id);
            //更新用户
             public boolean updateClass(Class user);
       //添加班级信息、、4/19
        public boolean addClass(Class user);
        //删除用户
        public boolean deleteClass(Class user);
		//public void deleteClass(Object user);
	    
        
        
    /**课程管理方法应用*/  
        
        
        /*列出课程信息*/
        /* 班级查看列表*/
	    
        public List<Coures> queryAllCoures();
        /**/
        public  boolean addCoures(Coures user);
        /*修改课程信息*/	  
                //按ID查询用户
                public Coures queryCouresByID(String id);
                //更新用户
                public boolean updateCoures(Coures user);
        /*删除课程*/
        //删除课程
        public boolean deleteCoures(Coures user);
        
        
 /**4/24进行学生信息的处理操作**/
        /*罗列出学生信息*/
        public List<Studyer> queryAllStudyer();
        //5/1/2017
       //添加学生
        public  boolean addStudyer(Studyer user);
        //修改删除信息
              //按ID查询用户
                  public Studyer queryStudyerByID(String number);
                //更新学生
                  public boolean updateStudyer(Studyer user);
        //删除学生          
        public boolean deletestudyer(Studyer user);
        
        
  /***对于成绩的操作*///5、14
        public boolean addScore(Sh user);
      
      //更新成绩
        public boolean updateScore(Sh user);
        //列出成绩
        public List<Sh> queryAllScore();
        //按ID查询用户
        public Sh queryShByScore(String number);
       //根据课程编号
        //public Sh queryShById2(String couresName);
	
      //获取学生课程信息--studentId
    	
		public List<Sh> getByStudentId(String number);
		
		
		 /*在ShDAO里面调用表Coures*/
		  public Coures queryCouresID(String id);
		  public List<Coures> queryAllCoures2();
	//根据课程编号获取成绩信息	
	
		public List<Sh> getById2(String id);
		//public List<Coures> queryAllCoures2();
		
    
        
}
