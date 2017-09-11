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
		   //返回请求allUserList给ListAllUser.jsp
	     
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
	//��ȡ��ɾ�������ݣ�
	
	//���ñ�ɾ��������
	//ɾ���������޸ı�����
	public String  backup() throws Exception
	{
	   
		Cartime user=dao.queryUserByID(numcar);
		/**���ִ�����ʾdao.queryUserByID(numcar)Ϊ�գ���Ҫ��appp**��xml����ת����Ƚ����ذ�
		 * ʧ��������2������Ϊ�յ�ֵ����*/
		ServletActionContext.getRequest().setAttribute("user2",user);
		 System.out.print("���ƺ�"+numcar);
		CarBackUp user2=new CarBackUp();
	  
		//String BackNumcar=user.getNumcar();//BackNumcar��ʾ�������ݣ����ƺ�
		String BackPlayer=user.getPlayer();//BackPlayer��ʾ�������ݣ���¼��
		String BackTime1=user.getTime1();//BackTime��ʾ�������ݣ�����ʱ��
		String BackTime2=user.getTime2();//BackTime��ʾ�������ݣ��뿪ʱ��
		String BackCarid=user.getCarid();//BackCarid��ʾ�������ݣ�ͣ��λ
		String BackParkid=user.getParkid();//BackParkid��ʾ�������ݣ�ͣ����
		//Ϊ�������ݸ�ֵ
		user2.setNumcar(numcar);
		user2.setCarid(BackCarid);
		user2.setTime1(BackTime1);
		user2.setTime2(BackTime2);
		user2.setParkid(BackParkid);
		user2.setPlayer(BackPlayer);
		if(dao2.addBackCar(user2))//��������
		    System.out.print("���ݳ��ƺ�"+numcar);
		//����ɾ��������¼��Ϣ
		 if(dao.deleteCar(user))
		   {
			    return "success";
		   }
		   else
		   {
			   return "ERROR";	  
			   
		   }
		
	}
	//�鿴������Ϣ
	public String  showbackup() throws Exception
	{
		
		 List<CarBackUp> allUserList=dao2.queryAllCarBackUp();
		 ServletActionContext.getRequest().setAttribute("allUserList", allUserList);
		   //返回请求allUserList给ListAllUser.jsp
	     
		return "success";
		
	}
/*	public String  update1() throws Exception
	{
		Cartime user=dao.queryUserByID(numcar);
         ServletActionContext.getRequest().setAttribute("user",user);//��ֵ��jsp����
         return "SUCCESS";
	}*/
}
