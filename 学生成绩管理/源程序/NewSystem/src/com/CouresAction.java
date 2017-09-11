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
	/*定义所需的变量*/
	 private ActionManager cao;
	 private String id;
	 private String couresName;
	 private String cnature;
	 private Integer credit;
	 /*获得变量*/
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
	//列出所有ke信息
		public String listCoures() throws  Exception 
		   {
			 List<Coures> allCouresList=cao.queryAllCoures();
			 ServletActionContext.getRequest().setAttribute("allCouresList", allCouresList);
		     return "SUCCESS";
		    }
	//添加信息
		public String AddCoures() throws Exception
		{
			Coures user=new Coures();
			user.setId(id);
			user.setCnature(cnature);
			user.setCouresName(couresName);
			user.setCredit(credit);
			if(cao.addCoures(user))
			 {
	        	System.out.print(couresName+"添加课程成功");
	            return "SUCCESS";
	        }
			else
				return "ERROR";
		}
	//4/22lvzekun
		//开始修改课程信息，先到修改页面，在修噶数据
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
		//开始修改课程
		public String supdate2() throws Exception
		{
			Coures user=new Coures();
			user.setId(id);
			user.setCredit(credit);
			user.setCouresName(couresName);
			user.setCnature(cnature);
			System.out.println(cnature+"课程性质");
		if(cao.updateCoures(user))
		{
			return "SUCCESS";
		}
		else
			return "ERROR";
		}
		
		//删除课程信息
		public String deletecoures() throws Exception
		{
			System.out.println("开始删除");
		    Coures user=cao.queryCouresByID(id);//根据ID获得信息
		    user.setId(id);
		    
	        ServletActionContext.getRequest().setAttribute("user",user);//
	        System.out.println(user+"课程");
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
