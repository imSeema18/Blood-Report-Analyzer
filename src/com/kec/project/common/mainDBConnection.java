package com.kec.project.common;

import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class mainDBConnection {
	static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
static String db_url = "jdbc:mysql://localhost/finaldb";
String user = "root";
String pass = "root";
static Statement stmt = null;
static Connection conn = null;
public Connection getConnection()
{
	try{
		Class.forName("com.mysql.jdbc.Driver");
		  conn =(Connection) DriverManager.getConnection(db_url, user, pass);
		 if(conn!=null)
		 {
			 
			 System.out.println("connected to db..........");
			 return conn;
		 }
	}
	catch(Exception e)
	{e.printStackTrace();}
return conn;
}
	

}
