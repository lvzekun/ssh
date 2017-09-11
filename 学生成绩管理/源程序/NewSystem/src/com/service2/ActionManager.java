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
	    //��¼�ж�
	    public Integer validLogin(String username , String password);
	    //ע��
	    public boolean adduser(Login user);
	    //public boolean addUser(User user);
        //userdao
	    public UserDAO getUserDAO();
	    public void setUserDAO(UserDAO userDAO);
	    
	  //�����鿴�༶
	    public ClassDAO getClassDAO();
	    
	    public void setClassDAO(ClassDAO classdao);
	   //�����Կγ� 
	   public CouresDAO getCouresDAO();
	   public void setCouresDAO(CouresDAO couresDAO);
	  //������ѧ���Ĳ���
	    public StudyDAO getStudyDAO();
	    public void setStudyDAO(StudyDAO studyDAO);
	  //�����ɼ��Ĳ���
	    public ShDAO getShDAO();
	    public void setShDAO(ShDAO shDAO);
	    
	    /* �༶�鿴�б�*/
	    
	        public List<Class> queryAllClass();
        
        
        /*�༶�޸���Ϣ*/
        
            //��ID��ѯ�û�
             public Class queryUserByID(int id);
            //�����û�
             public boolean updateClass(Class user);
       //��Ӱ༶��Ϣ����4/19
        public boolean addClass(Class user);
        //ɾ���û�
        public boolean deleteClass(Class user);
		//public void deleteClass(Object user);
	    
        
        
    /**�γ̹�����Ӧ��*/  
        
        
        /*�г��γ���Ϣ*/
        /* �༶�鿴�б�*/
	    
        public List<Coures> queryAllCoures();
        /**/
        public  boolean addCoures(Coures user);
        /*�޸Ŀγ���Ϣ*/	  
                //��ID��ѯ�û�
                public Coures queryCouresByID(String id);
                //�����û�
                public boolean updateCoures(Coures user);
        /*ɾ���γ�*/
        //ɾ���γ�
        public boolean deleteCoures(Coures user);
        
        
 /**4/24����ѧ����Ϣ�Ĵ������**/
        /*���г�ѧ����Ϣ*/
        public List<Studyer> queryAllStudyer();
        //5/1/2017
       //���ѧ��
        public  boolean addStudyer(Studyer user);
        //�޸�ɾ����Ϣ
              //��ID��ѯ�û�
                  public Studyer queryStudyerByID(String number);
                //����ѧ��
                  public boolean updateStudyer(Studyer user);
        //ɾ��ѧ��          
        public boolean deletestudyer(Studyer user);
        
        
  /***���ڳɼ��Ĳ���*///5��14
        public boolean addScore(Sh user);
      
      //���³ɼ�
        public boolean updateScore(Sh user);
        //�г��ɼ�
        public List<Sh> queryAllScore();
        //��ID��ѯ�û�
        public Sh queryShByScore(String number);
       //���ݿγ̱��
        //public Sh queryShById2(String couresName);
	
      //��ȡѧ���γ���Ϣ--studentId
    	
		public List<Sh> getByStudentId(String number);
		
		
		 /*��ShDAO������ñ�Coures*/
		  public Coures queryCouresID(String id);
		  public List<Coures> queryAllCoures2();
	//���ݿγ̱�Ż�ȡ�ɼ���Ϣ	
	
		public List<Sh> getById2(String id);
		//public List<Coures> queryAllCoures2();
		
    
        
}
