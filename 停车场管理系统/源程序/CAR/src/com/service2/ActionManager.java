package com.service2;
import java.util.List;

import com.bean.CarBackUp;
import com.bean.Cartime;




import com.dao.CarDAO2;

import com.dao.CarDAO;



public interface ActionManager {
	  
	
	    public CarDAO getCarDAO();
	    public void setCarDAO(CarDAO carDAO);
	    /* �����鿴�б�*/
	    
        public List<Cartime> queryAllCartime();
	    
        public boolean addCar(Cartime user);
        
	    //���ݳ��ƺŲ鵽��������Ϣ
        public Cartime queryUserByID(String numcar);
        public boolean deleteCar(Cartime user);
        
      /*�����������ݿ�*/
        public CarDAO2 getCarDAO2();
	    public void setCarDAO2(CarDAO2 carDAO);
	    //�������ݲ�������
	    public boolean addBackCar(CarBackUp user);
	    //�鿴���ݵ����ݿ�5/8
	    public List<CarBackUp> queryAllCarBackUp();
        
  
        

}
