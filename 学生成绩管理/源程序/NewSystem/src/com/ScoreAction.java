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
					 //��ȡ����
					 
					 //ServletActionContext.getRequest().setAttribute("allStudyerList", allStudyerList);
					
					 List<Coures> allCouresList=Sco2.queryAllCoures();
					 //��ȡ�γ���Ϣ
					 ServletActionContext.getRequest().setAttribute("allCouresList", allCouresList);
				    
					 
					   //返回请求allUserList给ListAllUser.jsp
					 return "SUCCESS";
					 
					 
				}
				//�����
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
						
					
					//��ȡ���ݱ��浽ѧ���ɼ���ͣ��γ̳ɼ�����
					
					
					
				}
				//�г�����ѧ��
				public String showScore() throws Exception
				{
					 List<Sh> allScoreList=Sco3.queryAllScore();
					 ServletActionContext.getRequest().setAttribute("allScoreList", allScoreList);
					   //返回请求allUserList给ListAllUser.jsp
					 System.out.println(allScoreList);
				     return "SUCCESS";
					//return "SUCCESS";
					
				}
				
				//�鿴���˳ɼ�
				public String showpeople () throws Exception
				{
				  
				    //allCouresList.get(0).getId();
					Studyer stu=new Studyer();
					stu.setNumber(number);
					
				    //List<Coures> allCouresList=Sco3.queryAllCoures2();
					 //��ȡ�γ���Ϣ
					//ServletActionContext.getRequest().setAttribute("allCouresList", allCouresList);
					//System.out.println("�鿴�Ŀγ�OOOO"+allCouresList);
					//������ѧ��
					int Score=0;
					
					
					System.out.println("�鿴��ѧ��ѧ��"+number);
					
					 //Sh allScoreList2=Sco3.queryShByScore(number);
					 //ServletActionContext.getRequest().setAttribute("allScoreList2", allScoreList2);
					 List<Sh> allScoreList=Sco3.getByStudentId(number);
					 //forѭ���жϷ��������ձ�ŵõ�ѧ�֣�����ѧ�֣�
					   /*�õ�����*/
					
					 for(int i=0;i<allScoreList.size();i++)
					 {
						 
						 
						 //1.�ж�lis����ĳ��Ⱥʹ�С
						 
						 //��ÿγ̱�ţ�
						  /*��ȡ������*/
						Coures couresId=allScoreList.get(i).getId().getCoures(); 
						Integer a=allScoreList.get(i).getCredit();
						String id=couresId.getId();//��ȡ�����еĿγ̱��
						//String couresNutrue=couresId.getCouresName();
						//System.out.print("ѧ���Ŀγ�"+couresNutrue);
	                     //���ñ�Ų鿴�γ̱����Ϣ���õ��γ�ѧ��
						
						Coures user2=Sco3.queryCouresID(id);//����ID�����Ϣ
						System.out.println(user2);
						 Integer courescredit;
						//������ѧ�ֵļ���
						 if(allScoreList.get(i).getCredit()>=60)
						 {
							 courescredit=user2.getCredit();
							    
								System.out.println("�γ̵�ѧ�֣�"+courescredit); 
						  
						 }
						 else
						 {
							    courescredit=0;
								System.out.print("ѧ���ɼ�������ѧ��Ϊ:"+courescredit);
						 }
						 Score=Score+courescredit;
					 }
					 System.out.println("ѧ��������ѧ��wei:"+Score);
					
					 ServletActionContext.getRequest().setAttribute("allScoreList", allScoreList);
					 ServletActionContext.getRequest().setAttribute("allScore", Score);
					
					 System.out.println("��ȡ���˳ɼ�:"+allScoreList);
					 return "SUCCESS";
				}
	///5��18�鿴�γ̵�ƽ���ֺ���ߣ���ͷ�			
		public 	String showcoures () throws Exception	
		{
			int MaxScore=0,MinScore=100,InScore=0,Score=0;//�����С�ɼ���ƽ��ֵ���ܷ���
			String CouresId=null;
			int j=0;//��ʾ�жϿγ̵���Ϣ���ڴ��������ڼ���
			//���Ȼ�ÿγ̱��
			Coures cou =new Coures();
			cou.setId(id);//��ȡjsp��õĿγ̱��
			System.out.println("�鿴�Ŀγ̱��"+id);
			//���ݿγ̱�Ż��Sh���еĳɼ���ֵ
			 List<Sh> allScoreList2=Sco3.queryAllScore();
			 //�����жϡ��γ̱�š��Ƿ�Ϊid
			 for(int i=0;i<allScoreList2.size();i++)
			 {
				 Coures couresId=allScoreList2.get(i).getId().getCoures(); //���ǻ���˶��󣬵���Ѫҩת��ΪString���͵�id���γ̱�ţ�
				 
				 String couid=couresId.getId();//��ȡ�����еĿγ̱��
				 if(couid.equals(id))//�ж���ͬ
				    {
				    	j++;//������ʾ�γ��ظ�����������ɼ�
				       // System.out.println("�õ���Ҫ����γ̵Ŀγ̱��CouresId:"+couid);
				        //�õ���ʱ�Ŀγ̱��  �����е� �ɼ�����
				        Score=Score+allScoreList2.get(i).getCredit();
				    	//�������ɼ�����С�ɼ���ƽ���ɼ��ļ��㡣
				        /*ƽ��ֵ*/
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
		   //��ƽ��ֵj
			 System.out.println("�γ̱�ţ�"+CouresId);
			 System.out.println("����j��"+j+"�ܣ���"+Score);
			 InScore=Score/j;	
			 System.out.println("ƽ��ֵ��"+InScore);
			 System.out.println("��߷֣�"+MaxScore);
			 System.out.println("��ͷ֣�"+MinScore);
			 //���н��γ����������ͷ֣�ƽ��ֵ��ֵ��getRequest().setAttribute();
			
			
			 //ServletActionContext.getRequest().setAttribute("tmp", map);
			 ServletActionContext.getRequest().setAttribute("CouresId", CouresId);
			 ServletActionContext.getRequest().setAttribute("MaxScore", MaxScore);
			 ServletActionContext.getRequest().setAttribute("MinScore", MinScore);
			 ServletActionContext.getRequest().setAttribute("InScore", InScore);
			   //���
			//System.out.println("�γ̳ɼ���ʾ��"+map);
			//������߷���ͷ���ʾ����
			
			return "SUCCESS";
		}

}
