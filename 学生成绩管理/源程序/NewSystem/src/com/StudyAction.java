package com;

import java.util.List;

import org.apache.struts2.ServletActionContext;


import com.bean.Class;
import com.bean.Studyer;
import com.opensymphony.xwork2.ActionSupport;
import com.service2.ActionManager;

public class StudyAction extends ActionSupport{
	//是数据对象的操作
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
		//列出所有班级信息
		public String listStudyer() throws  Exception 
		{
			 List<Studyer> allStudyerList=stu.queryAllStudyer();
			 ServletActionContext.getRequest().setAttribute("allStudyerList", allStudyerList);
			   //杩斿洖璇锋眰allUserList缁橪istAllUser.jsp
		     return "SUCCESS";
		}
	/*添加学生信息*/
		public String AddStudyer() throws Exception
		{
			Studyer user=new Studyer();
		//注意取值所有对象齐全，不为空
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
		//删除学生
		public String deletestudyer() throws Exception
		{
		System.out.println("开始删除");
	    Studyer user=stu.queryStudyerByID(number);
	    user.setNumber(number);
        ServletActionContext.getRequest().setAttribute("user",user);
        System.out.println(user+"班级");
	   if(stu.deletestudyer(user))
	   {
		    return "SUCCESS";
	   }
	   else
	   {
		   return "ERROR";	   }
	//return className;
		
		}
		//***转移到修改界面/
		public String stuupdate() throws Exception
		{
			 Studyer user=stu.queryStudyerByID(number);
	         ServletActionContext.getRequest().setAttribute("user",user);
	         return "SUCCESS";
			
		}
		//进行修改
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
