package com;

import java.util.List;

import org.apache.struts2.ServletActionContext;


import com.bean.Class;
import com.bean.Studyer;
import com.opensymphony.xwork2.ActionSupport;
import com.service2.ActionManager;

public class StudyAction extends ActionSupport{
	//�����ݶ���Ĳ���
	 private ActionManager stu;
	   private String number;
		private String name;
		private String gender;
		private String brithday;
		private String password;
		private String telephone;
		private String addresshome;
		private String classid;
		
	 public ActionManager getStu() {
			return stu;
		}
		public void setStu(ActionManager stu) {
			this.stu = stu;
		}
		public String getNumber() {
			return number;
		}
		public void setNumber(String number) {
			this.number = number;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getBrithday() {
			return brithday;
		}
		public void setBrithday(String brithday) {
			this.brithday = brithday;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getTelephone() {
			return telephone;
		}
		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}
		public String getAddresshome() {
			return addresshome;
		}
		public void setAddresshome(String addresshome) {
			this.addresshome = addresshome;
		}
		public String getClassid() {
			return classid;
		}
		public void setClassid(String classid) {
			this.classid = classid;
		}
		//�г����а༶��Ϣ
		public String listStudyer() throws  Exception 
		{
			 List<Studyer> allStudyerList=stu.queryAllStudyer();
			 ServletActionContext.getRequest().setAttribute("allStudyerList", allStudyerList);
			   //返回请求allUserList给ListAllUser.jsp
		     return "SUCCESS";
		}
	/*���ѧ����Ϣ*/
		public String AddStudyer() throws Exception
		{
			Studyer user=new Studyer();
		//ע��ȡֵ���ж�����ȫ����Ϊ��
			user.setNumber(number);
			user.setAddresshome(addresshome);
			user.setBrithday(brithday);
			user.setGender(gender);
			
			user.setClassid(classid);
			user.setName(name);
			user.setPassword(password);
			user.setTelephone(telephone);
			//user.setNumber(number);
			System.out.print(password);
			if(stu.addStudyer(user))
			{
				System.out.println("*****");
				return "SUCCESS";
			}
			else 
				
		         return "ERROR";
	           
	        
		}
	/***5/3hao	*/
		//ɾ��ѧ��
		public String deletestudyer() throws Exception
		{
		System.out.println("��ʼɾ��");
	    Studyer user=stu.queryStudyerByID(number);
	    user.setNumber(number);
        ServletActionContext.getRequest().setAttribute("user",user);
        System.out.println(user+"�༶");
	   if(stu.deletestudyer(user))
	   {
		    return "SUCCESS";
	   }
	   else
	   {
		   return "ERROR";	   }
	//return className;
		
		}
		//***ת�Ƶ��޸Ľ���/
		public String stuupdate() throws Exception
		{
			 Studyer user=stu.queryStudyerByID(number);
	         ServletActionContext.getRequest().setAttribute("user",user);
	         return "SUCCESS";
			
		}
		//�����޸�
		public String stuupdate2() throws Exception
		{
			Studyer user=new Studyer();
			user.setNumber(number);
			user.setAddresshome(addresshome);
			user.setBrithday(brithday);
			user.setGender(gender);
			user.setClassid(classid);
			user.setName(name);
			user.setPassword(password);
			user.setTelephone(telephone);
			//user.setNumber(number);
			//System.out.print(password);
			if(stu.updateStudyer(user))
			{
				
				
				    
				   
				return "SUCCESS";
			}
		      else
		           {return "ERROR";}
	      
			
		}
}
