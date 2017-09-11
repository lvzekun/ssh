package com;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;



import com.bean.Coures; 
import com.bean.Sh;
import com.bean.ShId;


import com.bean.Studyer;
import com.dao.StudyDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service2.ActionManager;

public class ScoreAction extends ActionSupport{
	 public ActionManager getSco() {
		return Sco;
	}
	public void setSco(ActionManager sco) {
		Sco = sco;
	}
	
	private ActionManager Sco,Sco2,Sco3,cao;
	 public ActionManager getCao() {
		return cao;
	}
	public void setCao(ActionManager cao) {
		this.cao = cao;
	}
	public ActionManager getSco3() {
		return Sco3;
	}
	public void setSco3(ActionManager sco3) {
		Sco3 = sco3;
	}
	private String number;
	private String name;
	private String gender;
	private String brithday;
	private String password;
	private String telephone;
	private String addresshome;
	private String classid;
	    
		public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBrithday() {
		return brithday;
	}
	public void setBrithday(String brithday) {
		this.brithday = brithday;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddresshome() {
		return addresshome;
	}
	public void setAddresshome(String addresshome) {
		this.addresshome = addresshome;
	}
	public String getClassid() {
		return classid;
	}
	public void setClassid(String classid) {
		this.classid = classid;
	}

		//
		 private String id;
		 private String couresName;
		 //private String couresName;
		 private String cnature;
		 private Integer credit;
		
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
	    public ActionManager getSco2() {
			return Sco2;
		}
		public void setSco2(ActionManager sco2) {
			this.Sco2 = sco2;
		}
	
		
				public String showchengji() throws  Exception 
				{
					List<Studyer> allStudyerList=Sco.queryAllStudyer();
					 ServletActionContext.getRequest().setAttribute("allStudyerList", allStudyerList);
					 //获取所有
					 
					 //ServletActionContext.getRequest().setAttribute("allStudyerList", allStudyerList);
					
					 List<Coures> allCouresList=Sco2.queryAllCoures();
					 //获取课程信息
					 ServletActionContext.getRequest().setAttribute("allCouresList", allCouresList);
				    
					 
					   //杩斿洖璇锋眰allUserList缁橪istAllUser.jsp
					 return "SUCCESS";
					 
					 
				}
				//天天加
				public String AddScore () throws Exception
				{
					Studyer stu=new Studyer();
					stu.setNumber(number);
					Coures cou=new Coures();
					cou.setId(id);
					ShId shId=new ShId();
					shId.setCoures(cou);
					shId.setStudyer(stu);
					Sh sh=new Sh();
					sh.setId(shId);
					sh.setCredit(credit);
					if(Sco3.addScore(sh))
						return  "SUCCESS";
					else 
					{
						if(Sco3.updateScore(sh))
							return "SUCCESS2";
						else
							return "SUCCESS";
					}
						
					
					//获取数据保存到学生成绩表和，课程成绩表中
					
					
					
				}
				//列出所有学生
				public String showScore() throws Exception
				{
					 List<Sh> allScoreList=Sco3.queryAllScore();
					 ServletActionContext.getRequest().setAttribute("allScoreList", allScoreList);
					   //杩斿洖璇锋眰allUserList缁橪istAllUser.jsp
					 System.out.println(allScoreList);
				     return "SUCCESS";
					//return "SUCCESS";
					
				}
				
				//查看个人成绩
				public String showpeople () throws Exception
				{
				  
				    //allCouresList.get(0).getId();
					Studyer stu=new Studyer();
					stu.setNumber(number);
					
				    //List<Coures> allCouresList=Sco3.queryAllCoures2();
					 //获取课程信息
					//ServletActionContext.getRequest().setAttribute("allCouresList", allCouresList);
					//System.out.println("查看的课程OOOO"+allCouresList);
					//定义总学分
					int Score=0;
					
					
					System.out.println("查看的学生学号"+number);
					
					 //Sh allScoreList2=Sco3.queryShByScore(number);
					 //ServletActionContext.getRequest().setAttribute("allScoreList2", allScoreList2);
					 List<Sh> allScoreList=Sco3.getByStudentId(number);
					 //for循环判断分数，按照编号得到学分，求总学分，
					   /*得到分数*/
					
					 for(int i=0;i<allScoreList.size();i++)
					 {
						 
						 
						 //1.判断lis对象的长度和大小
						 
						 //获得课程编号；
						  /*获取的是象*/
						Coures couresId=allScoreList.get(i).getId().getCoures(); 
						Integer a=allScoreList.get(i).getCredit();
						String id=couresId.getId();//获取对象中的课程编号
						//String couresNutrue=couresId.getCouresName();
						//System.out.print("学生的课程"+couresNutrue);
	                     //利用编号查看课程表的信息，得到课程学分
						
						Coures user2=Sco3.queryCouresID(id);//根据ID获得信息
						System.out.println(user2);
						 Integer courescredit;
						//进行总学分的计算
						 if(allScoreList.get(i).getCredit()>=60)
						 {
							 courescredit=user2.getCredit();
							    
								System.out.println("课程的学分："+courescredit); 
						  
						 }
						 else
						 {
							    courescredit=0;
								System.out.print("学生成绩不及格，学分为:"+courescredit);
						 }
						 Score=Score+courescredit;
					 }
					 System.out.println("学生所得总学分wei:"+Score);
					
					 ServletActionContext.getRequest().setAttribute("allScoreList", allScoreList);
					 ServletActionContext.getRequest().setAttribute("allScore", Score);
					
					 System.out.println("获取个人成绩:"+allScoreList);
					 return "SUCCESS";
				}
	///5、18查看课程的平均分和最高，最低分			
		public 	String showcoures () throws Exception	
		{
			int MaxScore=0,MinScore=100,InScore=0,Score=0;//最大最小成绩，平均值，总分数
			String CouresId=null;
			int j=0;//表示判断课程的信息存在次数，便于计算
			//首先获得课程编号
			Coures cou =new Coures();
			cou.setId(id);//获取jsp获得的课程编号
			System.out.println("查看的课程编号"+id);
			//根据课程编号获得Sh表中的成绩数值
			 List<Sh> allScoreList2=Sco3.queryAllScore();
			 //进行判断《课程编号》是否为id
			 for(int i=0;i<allScoreList2.size();i++)
			 {
				 Coures couresId=allScoreList2.get(i).getId().getCoures(); //这是获得了对象，但是血药转换为String类型的id（课程编号）
				 
				 String couid=couresId.getId();//获取对象中的课程编号
				 if(couid.equals(id))//判断相同
				    {
				    	j++;//用来表示课程重复次数，计算成绩
				       // System.out.println("得到需要计算课程的课程编号CouresId:"+couid);
				        //得到此时的课程编号  所在行的 成绩分数
				        Score=Score+allScoreList2.get(i).getCredit();
				    	//进行最大成绩，最小成绩，平均成绩的计算。
				        /*平均值*/
				        if(allScoreList2.get(i).getCredit()>=MaxScore)
				        {
				        	MaxScore=allScoreList2.get(i).getCredit();
				        }
				        if(allScoreList2.get(i).getCredit()<=MinScore)
				        {
				        	MinScore=allScoreList2.get(i).getCredit();
				        }
				        CouresId=couid;	
				    } 
			 }
		   //求平均值j
			 System.out.println("课程编号："+CouresId);
			 System.out.println("次数j："+j+"总：分"+Score);
			 InScore=Score/j;	
			 System.out.println("平均值："+InScore);
			 System.out.println("最高分："+MaxScore);
			 System.out.println("最低分："+MinScore);
			 //进行将课程名，最高最低分，平均值赋值给getRequest().setAttribute();
			
			
			 //ServletActionContext.getRequest().setAttribute("tmp", map);
			 ServletActionContext.getRequest().setAttribute("CouresId", CouresId);
			 ServletActionContext.getRequest().setAttribute("MaxScore", MaxScore);
			 ServletActionContext.getRequest().setAttribute("MinScore", MinScore);
			 ServletActionContext.getRequest().setAttribute("InScore", InScore);
			   //输出
			//System.out.println("课程成绩显示："+map);
			//计算最高分最低分显示出来
			
			return "SUCCESS";
		}

}
