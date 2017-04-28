package com.kec.project.ejb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.kec.project.common.mainDBConnection;

import com.kec.project.model.UserInfo;

@Local
@Stateless
public class ReportEjb {
		mainDBConnection connect = new mainDBConnection();
		Statement stmt = null;
		Connection conn =  connect.getConnection();
	//	private int dur;
	 public ReportEjb()
	 {
		 super();
		 System.out.println("ejb created");
		 }
	 public void insertReport(String range ,int userId ,  int typeId) {
		 try{
			 int times = 0;
			 conn.setAutoCommit(false);
			 stmt =conn.createStatement();
			 String sql1 =  "select max(duration) from tbl_result where id_user="+userId+" and id_type="+typeId+"";
			 ResultSet rs1 = stmt.executeQuery(sql1);
			 while(rs1.next())
			 {
				  times = rs1.getInt("max(duration)");
			 }
			 	int updateTime = times+1;	
			 
			 String sql = "insert into tbl_result(bloodRange,duration,id_user,id_type)values('"+range+"','"+updateTime+"','"+userId+"','"+typeId+"')";
			 stmt.executeUpdate(sql);
			 conn.commit();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
	}
	 
	 public UserInfo getUserID(UserInfo newUser)
	 {
		 try{
			 UserInfo getID = new UserInfo();
			 stmt=conn.createStatement();
			 String sql ="select id_user from tbl_user where username= "+newUser.getUsername()+" and password="+newUser.getPassword()+"";
			 ResultSet rs = stmt.executeQuery(sql);
			 while(rs.next())
			 {
				 getID.setUserId(rs.getInt("id_user"));
			 }
			 return getID;
			 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
			 
			 return null;
		 }
		 
	 }
	

}
