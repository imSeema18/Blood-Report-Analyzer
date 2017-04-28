package com.kec.project.mb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.kec.project.ejb.NewUserInfoEjb;
import com.kec.project.model.UserInfo;

@ViewScoped
@ManagedBean(name ="formMB")
public class FormMB {
	UserInfo user = new UserInfo();
	@EJB
	NewUserInfoEjb info;



	public UserInfo getUser() {
		if (user == null){
		user = new UserInfo();}
		return	user;
		}


	public void setUser(UserInfo user) {
		this.user = user;
	}
	 
	public String createAccount()
	 {
		 
			 if (user.getPassword().equals(user.getPasswordAgain()))
			 {
				 String hash=null;
				// System.out.println("Account Created");
			      try {
					 hash = byteArrayToHexString(FormMB.computeHash(user.getPassword()));
				} catch (Exception e) {
					e.printStackTrace();
				}
			      List<String> infos = new ArrayList<String>();
			      Boolean check =false;
			      infos = info.checkNewAccount();
			      if(infos.contains(user.getUsername()))
			      {
			    	  check =false;
			      }
			      else
			    	  check=true;
			      if(check){
				 info.insertNewData(user);
				 System.out.println("account created");
				 FacesContext.getCurrentInstance().addMessage(null,
			                new FacesMessage("Welcome " + user.getUsername() + " "));
				 return "welcome";}
			      else
			      {
			    	  System.out.println("Sign up failed");
						 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error","Enter another username"));

			      }
			 }
			 else
			 {
				 System.out.println("Incorrect password");
				 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error","Incorrect Password..Try again"));
			 }
			 return null;
		 }
	
	public static byte[] computeHash(String x)   
			  throws Exception  
			  {
			     java.security.MessageDigest d =null;
			     d = java.security.MessageDigest.getInstance("SHA-1");
			     d.reset();
			     d.update(x.getBytes());
			     return  d.digest();
			  }
	  public static String byteArrayToHexString(byte[] b){
		     StringBuffer sb = new StringBuffer(b.length * 2);
		     for (int i = 0; i < b.length; i++){
		       int v = b[i] & 0xff;
		       if (v < 16) {
		         sb.append('0');
		       }
		       sb.append(Integer.toHexString(v));
		     }
		     return sb.toString().toUpperCase();       
		      
		    }
		 
	 }
	


