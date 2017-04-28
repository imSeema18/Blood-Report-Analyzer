package com.kec.project.ejb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.kec.project.common.mainDBConnection;
import com.kec.project.model.FoodSts;
import com.kec.project.model.Foods;

@Local
@Stateless

public class FoodEJB {
	mainDBConnection connect = new mainDBConnection();
	Connection conn = connect.getConnection();
	Statement stmt = null;

	public FoodEJB() {
		super();

		System.out.println("ejb created");

	}

	List<Foods> allFood = new ArrayList<Foods>();

	public List<Foods> listOfFood() {
		List<Foods> allFood = new ArrayList<Foods>();
		try {
			stmt = conn.createStatement();
			String sql = "select *from tbl_food";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Foods fd = new Foods();
				fd.setNameOfFood(rs.getString("name_of_food"));
				allFood.add(fd);
				fd = null;
			}
			return allFood;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean addFood(String name) {
		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			String sql = "insert into tbl_food (name_of_food) values('" + name + "')";
			stmt.executeUpdate(sql);
			System.out.println("inserted ");
			conn.commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public int foodId(String name) {
		try {
			stmt = conn.createStatement();
			String sql1 = "select *from tbl_food where name_of_food='" + name + "'";
			ResultSet rs = stmt.executeQuery(sql1);
			int foodId = 0;
			while (rs.next()) {
				foodId = rs.getInt("id_food");

			}
			return foodId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void insertFoodSts(int fId, FoodSts foodSts) {
		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			String sql = "insert into tbl_food_recommend (id_food,tplHigh,tplLow,agrHigh,agrLow,rbcHigh,rbcLow,pltHigh,pltLow,uricHigh,uricLow) values ("
					+ fId + ",'" + foodSts.getTplHigh() + "','" + foodSts.getTplLow() + "' , '" + foodSts.getAgrLow() + " ', '"
					+ foodSts.getAgrHigh() + "','" + foodSts.getRbcHigh() + "','" + foodSts.getRbcLow() + "','"
					+ foodSts.getPltHigh() + "','" + foodSts.getPltLow() + "','" + foodSts.getUricHigh() + "','"
					+ foodSts.getUricLow() + "')";
			stmt.executeUpdate(sql);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
