package com.kec.project.ejb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.kec.project.common.mainDBConnection;
import com.kec.project.model.Record;
import com.kec.project.model.Report;

@Local
@Stateless
public class ChartsEJB {
	mainDBConnection connect = new mainDBConnection();
	 Connection conn =  connect.getConnection();
	 Statement stmt = null;
	 public ChartsEJB()
	 	{
		 	super();
		 	System.out.println("ejb created");
		 }
	 public List<Report> getCompInfoPresent(int uid,int tId) {
		 try{
			 stmt = conn.createStatement();
			 List <Report> getComp = new ArrayList<Report>();
			 String sql = "select bloodRange,duration from tbl_result where id_type="+tId+" and id_user ="+uid+"";
			 ResultSet rs = stmt.executeQuery(sql);
			 while(rs.next())
			 {
				 Report getCompRecord = new Report();
				 getCompRecord.setBloodRange(rs.getString("bloodRange"));
				 getCompRecord.setDuration(rs.getInt("duration"));
				 getComp.add(getCompRecord);
				 getCompRecord = null;
			 }
			 return getComp;
			  }
		catch(Exception e)
		 {
			e.printStackTrace();
		 }
		 return null;
	}
	 
	 public List<Report> getCompInfoPast(int uid,int tId) {
		 try{
			 stmt = conn.createStatement();
			 List <Report> getComp = new ArrayList<Report>();
			 int times=0;
			 stmt = conn.createStatement();
			 String sql1 =  "select max(duration) from tbl_result where id_user="+uid+" and id_type="+tId+"";
			 ResultSet rs1 = stmt.executeQuery(sql1);
			 while(rs1.next())
			 {
				  times = rs1.getInt("max(duration)");
			 }
			 if(times!=0)
			 {
			 getPastRecord(uid, tId, times);
			 }
			 String sql = "select bloodRange,duration from tbl_result where id_type="+tId+" and id_user ="+uid+"";
			 ResultSet rs = stmt.executeQuery(sql);
			 while(rs.next())
			 {
				 Report getCompRecord = new Report();
				 getCompRecord.setBloodRange(rs.getString("bloodRange"));
				 getCompRecord.setDuration(rs.getInt("duration"));
				 getComp.add(getCompRecord);
				 getCompRecord = null;
			 }
			 return getComp;
			  }
		catch(Exception e)
		 {
			e.printStackTrace();
		 }
		 return null;
	}
	 Record allRec = new Record();

	 public void getPastRecord(int uID,int type,int duration)
		{		try{
				String rec=null;
				stmt=conn.createStatement();
				String sql= "select bloodRange from tbl_result where id_user ="+uID+" and id_type="+type+" and duration ="+duration+"";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next())
				{
					rec = rs.getString("bloodRange");
				}
				if(type==1)
				{
					allRec.setCmpTpl(rec);
				}
				else if(type==2)
				{
					allRec.setCmpAgr(rec);
				}
				else if(type==3)
				{
					allRec.setCmpRbc(rec);
				}
				else if(type==5)
				{
					allRec.setCmpPlt(rec);
				}
				else if(type==6)
				{
					allRec.setCmpUric(rec);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		public Record getAllRec() {
			if(allRec==null)
				allRec = new Record();
			return allRec;
		}
		public void setAllRec(Record allRec) {
			this.allRec = allRec;
		}
	

}
