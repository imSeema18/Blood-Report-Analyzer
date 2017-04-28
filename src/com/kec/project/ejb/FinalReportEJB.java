package com.kec.project.ejb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.kec.project.common.mainDBConnection;

import com.kec.project.model.Foods;

@Stateless
@Local
public class FinalReportEJB {
		mainDBConnection connect = new mainDBConnection();
		Connection conn =  connect.getConnection();
		Statement stmt = null;
	 public FinalReportEJB()
	 	{
		 	super();
		 	System.out.println("ejb created");
		 }
	 public void insertFoodReport(int uId , int typeId , String disease, List<Foods> fds ,List<Foods> fd)
	 {
		 try{
			 conn.setAutoCommit(false);
			 stmt = conn.createStatement();
			 int duration=0;
			 String sql ="select max(duration) from tbl_result where id_type="+typeId+" and id_user = "+uId+"";
			 ResultSet rs = stmt.executeQuery(sql);
			 while(rs.next())
			 {
				 duration = rs.getInt("max(duration)");
			 }
			 if(duration == 0)
			 {
				 duration = 1;
			 }
			 rs.close();
			 String sql1="insert into tbl_report (id_user,id_type,disease,duration) values("+uId+","+typeId+" ,'"+disease+"','"+duration+"')";
			 stmt.executeUpdate(sql1);
			 for(Foods ce : fds){
				 int foodId = ce.getFoodId();
			 String sql2 = "insert  into tbl_report (id_user,id_type,id_food_allow,duration) values ("+uId+","+typeId+","+foodId+",'"+duration+"')";
			 stmt.executeUpdate(sql2);
			 }
			 for(Foods cne : fd){
				 int foodId = cne.getFoodId();
			 String sql3 = "insert  into tbl_report (id_user,id_type,id_food_avoid,duration) values ("+uId+","+typeId+","+foodId+",'"+duration+"')";
			 stmt.executeUpdate(sql3);
			 }
			 
			 conn.commit();}
			 catch(SQLException e1)
			 {
				 try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
				 }
		 catch(Exception e)
		 {
			e.printStackTrace(); 
		 }
	 }
}
