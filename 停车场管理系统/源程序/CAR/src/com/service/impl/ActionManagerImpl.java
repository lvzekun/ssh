package com.service.impl;

import java.util.List;

import com.bean.CarBackUp;
import com.bean.Cartime;


import com.dao.CarDAO2;

import com.dao.CarDAO;

import com.service2.ActionManager;



public class ActionManagerImpl implements ActionManager 
{
	private  CarDAO carDAO;
	
	public CarDAO getCarDAO() {
		// TODO Auto-generated method stub
		return this.carDAO;
	}

	public void setCarDAO(CarDAO carDAO) {
		// TODO Auto-generated method stub
		this.carDAO=carDAO;
	}
    private  CarDAO2 carDAO2;
	
	public CarDAO2 getCarDAO2() {
		// TODO Auto-generated method stub
		return this.carDAO2;
	}

	public void setCarDAO2(CarDAO2 carDAO2) {
		// TODO Auto-generated method stub
		this.carDAO2=carDAO2;
	}
	
	
	
//产看汽车。
	public List<Cartime> queryAllCartime() 
	{
		// TODO Auto-generated method stub
		  return carDAO.findAll();
	}

	public boolean addCar(Cartime user) 
	{
		// TODO Auto-generated method stub
		 if (carDAO.get(user.getCarid())==null)
         {
         	
			 carDAO.save(user);
             System.out.println("添加班级成功编号不重复");
         }
         else
             return false;
         return true;
	}
	//
	public Cartime queryUserByID(String numcar) 
	{
		// TODO Auto-generated method stub
		//System.out.println(carDAO.get(numcar));
		return carDAO.get(numcar);//返回查到的值
	}

	
	
/***汽车备份操作*/
	
	public boolean addBackCar(CarBackUp user) 
	{
		
		// TODO Auto-generated method stub
		  carDAO2.save(user);//采用了表2，z
		  return true;
	}

   public boolean deleteCar(Cartime user) 
   {
	// TODO Auto-generated method stub
	  carDAO.delete(user);
	
	  return true;
    }
//
public List<CarBackUp> queryAllCarBackUp() 
{
	// TODO Auto-generated method stub
	  return carDAO2.findAll();
}





	

			

		

		

		

		

}
