package com.kec.project.ejb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.kec.project.common.mainDBConnection;
import com.kec.project.model.UserInfo;

@Local
@Stateless
public class NewUserInfoEjb {
	mainDBConnection connect = new mainDBConnection();
	Statement stmt = null;
	Connection conn = connect.getConnection();

	public NewUserInfoEjb() {
		super();

		System.out.println("ejb created");

	}

	public UserInfo checkLogin(UserInfo user) {
		UserInfo newUser = new UserInfo();
		try {
			stmt = conn.createStatement();
			String sql = "select *from tbl_user where username ='" + user.getUsername() + "' and password ='" + user.getPassword()
					+ "'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				newUser.setFirstName(rs.getString("first_name"));
				newUser.setLastName(rs.getString("last_name"));
				newUser.setUsername(rs.getString("username"));
				newUser.setUserId(rs.getInt("id_user"));
				newUser.setGender(rs.getString("gender"));
				newUser.setWeight(rs.getString("weight"));
				newUser.setAge(rs.getString("age"));
			}
			return newUser;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<String> checkNewAccount() {
		List<String> info = new ArrayList<String>();
		try {
			stmt = conn.createStatement();
			String sql = "select  username from tbl_user";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String un = rs.getString("username");
				info.add(un);
				un=null;
				}
			return info;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public void insertNewData(UserInfo user) {

		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			String sql = "insert into tbl_user(first_name,last_name,username,age,gender,password,weight) values('"
					+ user.getFirstName() + "' ,'" + user.getLastName() + "' ,'" + user.getUsername() + "','"
					+ user.getAge() + "' ,'" + user.getGender() + "','" + user.getPassword() + "','" + user.getWeight() + "')";
			stmt.executeUpdate(sql);
			conn.commit();
			System.out.println("Data inserted");
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public Boolean updateDatas(UserInfo user) {
		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			int id = user.getUserId();
			String sql = "update tbl_user set first_name='" + user.getFirstName() + "', last_name ='"
					+ user.getLastName() + "' ,age ='" + user.getAge() + "' , weight='" + user.getWeight()
					+ "' where id_user =" + id + "";
			stmt.executeUpdate(sql);
			if (!user.getPassword().isEmpty()) {
				String sql1 = "update tbl_user set password='" + user.getPassword() + "' where  id_user =" + id + "";
				stmt.executeUpdate(sql1);
			}
			conn.commit();
			System.out.println("Updated");
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void updateWeight(int uId, String weight) {
		try {
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
			String sql = "Update tbl_user set weight ='" + weight + "' where id_user =" + uId + "";
			stmt.executeUpdate(sql);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
