package com.service2;
import java.util.List;

import com.bean.CarBackUp;
import com.bean.Cartime;




import com.dao.CarDAO2;

import com.dao.CarDAO;



public interface ActionManager {
	  
	
	    public CarDAO getCarDAO();
	    public void setCarDAO(CarDAO carDAO);
	    /* 汽车查看列表*/
	    
        public List<Cartime> queryAllCartime();
	    
        public boolean addCar(Cartime user);
        
	    //根据车牌号查到汽车的信息
        public Cartime queryUserByID(String numcar);
        public boolean deleteCar(Cartime user);
        
      /*汽车备份数据库*/
        public CarDAO2 getCarDAO2();
	    public void setCarDAO2(CarDAO2 carDAO);
	    //备份数据操作数据
	    public boolean addBackCar(CarBackUp user);
	    //查看备份的数据库5/8
	    public List<CarBackUp> queryAllCarBackUp();
        
  
        

}
