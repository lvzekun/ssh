package com.dao;


import java.util.List;


import com.bean.Sh;
import com.bean.ShId;
import com.bean.Studyer;
import com.bean.Coures;



public interface ShDAO {
    //5��14��ӳɼ�
	public void save(Sh user);
	
	
    public void update(Sh user);
    //��ȡ���ݣ�����������
    public  List<Sh> findAll();
    //���� ѧ�Ų鿴ѧ��
	public Sh get( String number);
    public List<Sh> getGradeByStudentId(String number);

    //���һ�����ݿγ̱�ţ������Ϣ����
    public Coures get2(String id);
    public List<Coures> finAll();
    //���ݿγ̱�����鿴�γ̳ɼ�����ʾ
    public List<Sh> getGradeByStudentId2(String id);
    

	
    

	


	
		

	


	


	//public Sh get(Integer number);
	
} 
