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
	    
 //userDAO����
	    
	    
		
		public UserDAO getUserDAO()
	    {
	       return this.userDAO;
	    }
	    public void setUserDAO(UserDAO userDAO) 
	    {
		       this.userDAO = userDAO;
		}
//ClassDAO����
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
//CouresDAO����2017/4/19������
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
			
		
//��������		
		//��¼�ж�
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
	                System.out.println("��ӳɹ���Ų��ظ�");
	            }
	            else
	                return false;
	            return true;
		}
		

//��ѯ�б�
		public List<Class> queryAllClass()
		{
			// TODO Auto-generated method stub
			   return classdao.findAll(); 
		}
		//�༶���¹���
		public boolean updateClass(Class user)
		{
			// TODO Auto-generated method stub
			  if (classdao.get(user.getId())!=null)
	                classdao.update(user);
	            else
	                return false;
	            return true;

			
		}
		//����id���鿴�༶��Ϣ
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
	                System.out.println("��Ӱ༶�ɹ���Ų��ظ�");
	            }
	            else
	                return false;
	            return true;
			
		}
		//ɾ���༶
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
		
//�γ̹�����÷�������		
		//�г����пγ̡�
		public List<Coures> queryAllCoures()
		{
			// TODO Auto-generated method stub
			  return couresDAO.findAll();
		}
		//4/21��ӿγ�
        public boolean addCoures(Coures user)
          {
	// TODO Auto-generated method stub
	      if (couresDAO.get(user.getId())==null)
             {
     	
               couresDAO.save(user);
               System.out.println("��Ӱ༶�ɹ���Ų��ظ�");
             }
          else
            return false;
          return true;
          }
        /***�γ̹�����Ϣ*/
        //��ÿγ���Ϣ
		public Coures queryCouresByID(String id)
		{
			// TODO Auto-generated method stub
			System.out.println("��ʼ��ÿγ̵���Ϣ��");
			return couresDAO.get(id);
		}
		//���¿γ���Ϣ
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
//*����ѧ���Ĵ���������**//		
		
		/*�г��������ѧ����Ϣ*/
		public List<Studyer> queryAllStudyer() {
			// TODO Auto-generated method stub
			return studyDAO.findALL();
		
		}
		public boolean addStudyer(Studyer user) {
			// TODO Auto-generated method stub
			
			 if (studyDAO.get(user.getNumber())==null)
	            {
				   System.out.println("���ѧ���ɹ���Ų��ظ�");
				  studyDAO.save(user);
	           
	           }
	          else
	            return false;
	          return true;
		}
		///ɾ����Ϣ
		public boolean deletestudyer(Studyer user) {
			// TODO Auto-generated method stub
			 if (studyDAO.get(user.getNumber())!=null)
				 studyDAO.delete(user);
	            else
	                return false;
	            return true;

		}
		//��ȡ��Ϣ��
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
		
		
/*5��14*/	
		//���ڳɼ��Ĳ�����
		
		public boolean addScore(Sh user)
		{
			//����  �ж��Ƿ�����ظ���
			//if(shDAO.get(user.getId().getStudyer())==null||shDAO.get2(user.getId().getCoures()))
		    //����try catch �жϲ����쳣���и��²����� 
			/**���������ظ��޷�����ʱ�������쳣������false,�������ݸ��²�����*/
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
		
		//����ѧ����Ϣ��ȡ
		/*public Sh queryShByID(int id) {
			// TODO Auto-generated method stub
			//return shDAO.get(id);
		}
		*/
		//���ݿγ̱����Ϣ��ȡ
	    
		
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
			System.out.println("��ʼ��");
			// TODO Auto-generated method stub
			return shDAO.getGradeByStudentId(number);
		}
		public Coures queryCouresID(String id) {
			// TODO Auto-generated method stub
			return shDAO.get2(id);
			}
		//���ݿγ̱�Ż�ȡ�ɼ���Ϣ
		
		public List<Sh> getById2(String id) {
			// TODO Aut	return shDAO.getGradeByStudentId(number);o-generated method stub
			return shDAO.getGradeByStudentId2(id);
		}
		public List<Coures> queryAllCoures2() {
			// TODO Auto-generated method stub
			return shDAO.finAll();
		}
		/**�û�ע��*/
						
		

		
		
		
		
		
		
		

			   
		

		
		
		

		
		
			

		

		

		

		

}
