package com.dao.impl;
import java.util.List;
import com.dao.UserDAO;
import com.bean.Login;


import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {
	
    public Login findUserByNameAndPass(String username, String password) {
        // TODO Auto-generated method stub
        System.out.println("��֤�û�22222222");
        //delete(1);    //�����ݿ��test���У��ɹ�ɾ��һ����¼
        //String[] args = {username , password};
        System.out.println("�ɹ�123abc");
           
        List ul = getHibernateTemplate().find("from com.bean.Login au where au.username = '"+ username+"' and au.password = '"+ password+"'");
 
        if (ul.size() == 1)
        {
            System.out.println("OK 123abc");
            return (Login)ul.get(0);
        }
        return null;
 
    }
   
    public Login get(Integer id) {
        // TODO Auto-generated method stub
        return (Login)getHibernateTemplate().get(Login.class , id);
    }

	public void save(Login user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(user);
		
	}
    
   

	
	
	

	/*public Object get2(String username) {
		// TODO Auto-generated method stub
		 return (User)getHibernateTemplate().get(User.class , username);
	}*/

	

	
}
