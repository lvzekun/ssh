package com.dao;

import java.util.List;




import com.bean.Studyer;

public interface StudyDAO {
	/*�г����а༶
	    */
	   public  List<Studyer> findALL();
	  //���� ѧ�Ų鿴ѧ��
	   public Studyer get(String id);
	  //��ӿγ���Ϣ�ķ�������2017/4/19
	   public void save(Studyer user);
	   //ɾ��ѧ����Ϣ
	   public void delete(Studyer user);
	   //�����û�
	    public void update(Studyer user);
		
	
}
