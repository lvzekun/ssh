package com;

import java.util.List;

import org.apache.struts2.ServletActionContext;


import com.bean.CarBackUp;
import com.bean.Cartime;

import com.opensymphony.xwork2.ActionSupport;
import com.service2.ActionManager;

public class CarAction extends ActionSupport{
	private ActionManager dao,dao2;
	private String numcar;
	private String player;
	private String time1;
	private String time2;
	private String carid;
	private String parkid;
	
	 public ActionManager getDao2() {
		return dao2;
	}

	public void setDao2(ActionManager dao2) {
		this.dao2 = dao2;
	}

	public ActionManager getDao() {
		return dao;
	}

	public void setDao(ActionManager dao) {
		this.dao = dao;
	}

	public String getNumcar() {
		return numcar;
	}

	public void setNumcar(String numcar) {
		this.numcar = numcar;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public String getTime1() {
		return time1;
	}

	public void setTime1(String time1) {
		this.time1 = time1;
	}

	public String getTime2() {
		return time2;
	}

	public void setTime2(String time2) {
		this.time2 = time2;
	}

	public String getCarid() {
		return carid;
	}

	public void setCarid(String carid) {
		this.carid = carid;
	}

	public String getParkid() {
		return parkid;
	}

	public void setParkid(String parkid) {
		this.parkid = parkid;
	}

	public String show() throws  Exception 
	   {
		 List<Cartime> allUserList=dao.queryAllCartime();
		 ServletActionContext.getRequest().setAttribute("allUserList", allUserList);
		   //杩斿洖璇锋眰allUserList缁橪istAllUser.jsp
	     
		return "success";
		 
	   }
	public String incar() throws Exception
	{
		Cartime user=new Cartime();
		user.setNumcar(numcar);
		user.setPlayer(player);
		user.setTime1(time1);
		user.setTime2(time2);
		user.setCarid(carid);
		user.setParkid(parkid);
		System.out.println(numcar);
		if(dao.addCar(user))
		{
			return "success";
		}
		else
			return "Error";
		//return null;
		
	}
	//获取被删除的数据；
	
	//利用被删除的数据
	//删除，或者修改表，备份
	public String  backup() throws Exception
	{
	   
		Cartime user=dao.queryUserByID(numcar);
		/**出现错误，显示dao.queryUserByID(numcar)为空，主要是appp**。xml中跳转问题比较严重昂
		 * 失误跳到表2中所以为空的值传输*/
		ServletActionContext.getRequest().setAttribute("user2",user);
		 System.out.print("车牌号"+numcar);
		CarBackUp user2=new CarBackUp();
	  
		//String BackNumcar=user.getNumcar();//BackNumcar表示备份数据：车牌号
		String BackPlayer=user.getPlayer();//BackPlayer表示备份数据：记录人
		String BackTime1=user.getTime1();//BackTime表示备份数据：进入时间
		String BackTime2=user.getTime2();//BackTime表示备份数据：离开时间
		String BackCarid=user.getCarid();//BackCarid表示备份数据：停车位
		String BackParkid=user.getParkid();//BackParkid表示备份数据：停车场
		//为备份数据赋值
		user2.setNumcar(numcar);
		user2.setCarid(BackCarid);
		user2.setTime1(BackTime1);
		user2.setTime2(BackTime2);
		user2.setParkid(BackParkid);
		user2.setPlayer(BackPlayer);
		if(dao2.addBackCar(user2))//备份数据
		    System.out.print("备份车牌号"+numcar);
		//进行删除汽车记录信息
		 if(dao.deleteCar(user))
		   {
			    return "success";
		   }
		   else
		   {
			   return "ERROR";	  
			   
		   }
		
	}
	//查看备份信息
	public String  showbackup() throws Exception
	{
		
		 List<CarBackUp> allUserList=dao2.queryAllCarBackUp();
		 ServletActionContext.getRequest().setAttribute("allUserList", allUserList);
		   //杩斿洖璇锋眰allUserList缁橪istAllUser.jsp
	     
		return "success";
		
	}
/*	public String  update1() throws Exception
	{
		Cartime user=dao.queryUserByID(numcar);
         ServletActionContext.getRequest().setAttribute("user",user);//传值到jsp界面
         return "SUCCESS";
	}*/
}
