package com.dao;//2017/4/19�������������пγ̵�crud
import java.util.List;


import com.bean.Coures;
public interface CouresDAO{
	/*�г����а༶
    */
   public  List<Coures> findAll();
   
   //���� ID�鿴ѧ��
   public Coures get(String id);
   //��ӿγ���Ϣ�ķ�������2017/4/19
   public void save(Coures user);
   //�޸Ŀγ���Ϣ��2017��4/21������
   public void update(Coures user);
   //ɾ���༶��Ա
   //删除用户
   	public void delete(Coures user);
}
