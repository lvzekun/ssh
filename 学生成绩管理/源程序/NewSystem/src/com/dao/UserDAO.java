package com.dao;
import java.util.List;
import com.bean.Login;


public interface UserDAO {
	/**
     * ����id�����û�
     * @param id ��Ҫ���ҵ��û�id
     */ 
    Login get(Integer id);
    
    /*���� name*/
  
    /**
     * �����û�
     * @param user ��Ҫ���ӵ��û�
     */      
  
  
   Login findUserByNameAndPass(String username , String password);
   /* �������Ʋ鿴��Ϣ*/
	//Object get2(String username);

    public void save(Login user); 
   
	
}
