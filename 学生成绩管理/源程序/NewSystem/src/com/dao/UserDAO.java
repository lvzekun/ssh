package com.dao;
import java.util.List;
import com.bean.Login;


public interface UserDAO {
	/**
     * 根据id查找用户
     * @param id 需要查找的用户id
     */ 
    Login get(Integer id);
    
    /*根据 name*/
  
    /**
     * 增加用户
     * @param user 需要增加的用户
     */      
  
  
   Login findUserByNameAndPass(String username , String password);
   /* 根据名称查看信息*/
	//Object get2(String username);

    public void save(Login user); 
   
	
}
