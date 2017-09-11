package com;

import java.util.List;

import org.apache.struts2.ServletActionContext;

//import com.bean.Class;
import com.bean.Class;
import com.bean.Coures;
import com.dao.CouresDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.service2.ActionManager;

public class CouresAction extends ActionSupport {
	/*��������ı���*/
	 private ActionManager cao;
	 private String id;
	 private String couresName;
	 private String cnature;
	 private Integer credit;
	 /*��ñ���*/
	public ActionManager getCao() {
		return cao;
	}
	public void setCao(ActionManager cao) {
		this.cao = cao;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCouresName() {
		return couresName;
	}
	public void setCouresName(String couresName) {
		this.couresName = couresName;
	}
	public String getCnature() {
		return cnature;
	}
	public void setCnature(String cnature) {
		this.cnature = cnature;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	//�г�����ke��Ϣ
		public String listCoures() throws  Exception 
		   {
			 List<Coures> allCouresList=cao.queryAllCoures();
			 ServletActionContext.getRequest().setAttribute("allCouresList", allCouresList);
		     return "SUCCESS";
		    }
	//�����Ϣ
		public String AddCoures() throws Exception
		{
			Coures user=new Coures();
			user.setId(id);
			user.setCnature(cnature);
			user.setCouresName(couresName);
			user.setCredit(credit);
			if(cao.addCoures(user))
			 {
	        	System.out.print(couresName+"��ӿγ̳ɹ�");
	            return "SUCCESS";
	        }
			else
				return "ERROR";
		}
	//4/22lvzekun
		//��ʼ�޸Ŀγ���Ϣ���ȵ��޸�ҳ�棬���޸�����
		public String supdate() throws Exception
		{
			try{
				Coures user=cao.queryCouresByID(id);
				ServletActionContext.getRequest().setAttribute("user",user);
		         return "SUCCESS";
			}
	        catch (Exception e)
	        {
	        	e.printStackTrace();
	        	return "Error";
	        }
			//return "SUCCCESS";
		}
		//��ʼ�޸Ŀγ�
		public String supdate2() throws Exception
		{
			Coures user=new Coures();
			user.setId(id);
			user.setCredit(credit);
			user.setCouresName(couresName);
			user.setCnature(cnature);
			System.out.println(cnature+"�γ�����");
		if(cao.updateCoures(user))
		{
			return "SUCCESS";
		}
		else
			return "ERROR";
		}
		
		//ɾ���γ���Ϣ
		public String deletecoures() throws Exception
		{
			System.out.println("��ʼɾ��");
		    Coures user=cao.queryCouresByID(id);//����ID�����Ϣ
		    user.setId(id);
		    
	        ServletActionContext.getRequest().setAttribute("user",user);//
	        System.out.println(user+"�γ�");
		   if(cao.deleteCoures(user))
		   {
			    return "SUCCESS";
		   }
		   else
		   {
			   return "ERROR";	 
	       }
		//return className;
			
		
		}
}
