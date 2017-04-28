package com.kec.project.ejb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.kec.project.common.mainDBConnection;
import com.kec.project.model.CanEat;
import com.kec.project.model.CanNotEat;
import com.kec.project.model.Foods;
import com.kec.project.model.Recommend;

@Stateless
@Local
public class RecommendEJB {
	mainDBConnection connect = new mainDBConnection();
	Connection conn = connect.getConnection();
	Statement stmt = null;

	public RecommendEJB() {
		super();
		System.out.println("ejb created");
	}

	public String getMaxRange(int typeId) {
		try {
			String maxRange = null;
			stmt = conn.createStatement();
			String sql = "select max_range from tbl_standard where id_type= " + typeId + "";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				maxRange = rs.getString("max_range");
			}
			return maxRange;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getMinRange(int typeId) {
		try {
			String minRange = null;
			stmt = conn.createStatement();
			String sql = "select min_range from tbl_standard where id_type= " + typeId + "";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				minRange = rs.getString("min_range");
			}
			return minRange;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getMinRangeGen(int typeId, String gender) {
		try {
			String minRange = null;
			stmt = conn.createStatement();
			if (gender.equals('M')) {
				String sql = "select min_range from tbl_standard_male where id_type= " + typeId + " ";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					minRange = rs.getString("min_range");
				}
			} else {
				String sql = "select min_range from tbl_standard_female where id_type= " + typeId + " ";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					minRange = rs.getString("min_range");
				}

			}

			return minRange;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getMaxRangeGen(int typeId, String gender) {
		try {
			String maxRange = null;
			stmt = conn.createStatement();
			if (gender.equals('M')) {
				String sql = "select max_range from tbl_standard_male where id_type= " + typeId + " ";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					maxRange = rs.getString("max_range");
				}
			} else {
				String sql = "select max_range from tbl_standard_female where id_type= " + typeId + "";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					maxRange = rs.getString("max_range");
				}

			}
			return maxRange;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getDiseaseLowGen(int typeId, String gender) {
		try {
			String disease_low = null;
			stmt = conn.createStatement();
			if (gender.equals('M')) {
				String sql = "select disease_low from tbl_standard_male where id_type= " + typeId + " ";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					disease_low = rs.getString("disease_low");
				}
			} else {
				String sql = "select disease_low from tbl_standard_female where id_type= " + typeId + "";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					disease_low = rs.getString("disease_low");
				}

			}
			return disease_low;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getDiseaseHighGen(int typeId, String gender) {
		try {
			String disease_high = null;
			stmt = conn.createStatement();
			if (gender.equals('M')) {
				String sql = "select disease_high from tbl_standard_male where id_type= " + typeId + "";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					disease_high = rs.getString("disease_high");
				}
			} else {
				String sql = "select disease_high from tbl_standard_female where id_type= " + typeId + "";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					disease_high = rs.getString("disease_high");
				}

			}
			return disease_high;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<CanEat> appropiateFoodLow(int typeId) {
		try {
			int fId = 0;
			List<CanEat> canEat = new ArrayList<CanEat>();
			stmt = conn.createStatement();
			String sql = "select id_food_eat from tbl_food_when_low where id_type=" + typeId + "";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				fId = rs.getInt("id_food_eat");
				if (fId != 0) {
					CanEat can = new CanEat();
					can.setFoodId(fId);
					canEat.add(can);
					can = null;
				}

			}
			return canEat;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<CanNotEat> NotAppropiateFoodLow(int typeId) {
		try {
			int fId = 0;
			List<CanNotEat> canNotEat = new ArrayList<CanNotEat>();
			stmt = conn.createStatement();
			String sql = "select id_food_avoid from tbl_food_when_low where id_type=" + typeId + "";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				fId = rs.getInt("id_food_avoid");
				if (fId != 0) {
					CanNotEat can = new CanNotEat();
					can.setFoodId(fId);
					canNotEat.add(can);
					can = null;
				}

			}
			return canNotEat;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<CanEat> appropiateFoodHigh(int typeId) {
		try {
			int fId = 0;
			List<CanEat> canEat = new ArrayList<CanEat>();
			stmt = conn.createStatement();
			String sql = "select id_food_eat from tbl_food_when_high where id_type=" + typeId + "";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				fId = rs.getInt("id_food_eat");
				if (fId != 0) {
					CanEat can = new CanEat();
					can.setFoodId(fId);
					canEat.add(can);
					can = null;
				}

			}
			return canEat;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<CanNotEat> NotAppropiateFoodHigh(int typeId) {
		try {
			int fId = 0;
			List<CanNotEat> canNotEat = new ArrayList<CanNotEat>();
			stmt = conn.createStatement();
			String sql = "select id_food_avoid from tbl_food_when_high where id_type=" + typeId + "";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				fId = rs.getInt("id_food_avoid");
				if (fId != 0) {
					CanNotEat can = new CanNotEat();
					can.setFoodId(fId);
					canNotEat.add(can);
					can = null;
				}

			}
			return canNotEat;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Foods> nameOfFood(List<Integer> fd) {
		try {
			List<Foods> finalFoodNow = new ArrayList<Foods>();
			for (Integer ids : fd) {
				stmt = conn.createStatement();
				int fid = ids.intValue();
				String sql = "select name_of_food from tbl_food where id_food =" + fid + "";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					Foods food = new Foods();
					food.setNameOfFood(rs.getString("name_of_food"));
					finalFoodNow.add(food);
					food = null;
				}
			}
			return finalFoodNow;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;

	}

	public List<Foods> finalFood(List<Foods> canEat) {
		try {
			List<Foods> finalFoodNow = new ArrayList<Foods>();
			for (Foods ce : canEat) {
				stmt = conn.createStatement();
				int fid = ce.getFoodId();
				String sql = "select name_of_food from tbl_food where id_food =" + fid + "";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					Foods food = new Foods();
					food.setNameOfFood(rs.getString("name_of_food"));
					finalFoodNow.add(food);
					food = null;
				}
			}
			return finalFoodNow;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;

	}

	public List<Foods> avoidFood(List<Foods> fd) {
		try {
			List<Foods> finalFoodNow = new ArrayList<Foods>();
			for (Foods ce : fd) {
				stmt = conn.createStatement();
				int fid = ce.getFoodId();
				String sql = "select name_of_food from tbl_food where id_food =" + fid + "";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					Foods food = new Foods();
					food.setNameOfFood(rs.getString("name_of_food"));
					finalFoodNow.add(food);
					food = null;
				}
			}
			return finalFoodNow;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;

	}

	public String diseaseLow(int typeId) {
		try {
			stmt = conn.createStatement();
			String sql = "select disease_low from tbl_standard where id_type=" + typeId + "";
			ResultSet rs = stmt.executeQuery(sql);
			String disease_low = null;
			while (rs.next()) {
				disease_low = rs.getString("disease_low");
			}
			return disease_low;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String diseaseHigh(int typeId) {
		try {
			stmt = conn.createStatement();
			String sql = "select disease_high from tbl_standard where id_type=" + typeId + "";
			ResultSet rs = stmt.executeQuery(sql);
			String disease_high = null;
			while (rs.next()) {
				disease_high = rs.getString("disease_high");
			}
			return disease_high;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Foods> FoodHigh(int typeId, boolean sts) {
		try {
			int types;
			if (sts) {
				types = 1;
			} else
				types = 0;

			stmt = conn.createStatement();
			if (typeId == 1) {
				List<Foods> finalFoods = new ArrayList<Foods>();
				String sql1 = "select id_food from tbl_food_recommend where tplHigh=" + types + "";
				ResultSet rs = stmt.executeQuery(sql1);
				int fIdT = 0;
				while (rs.next()) {

					fIdT = rs.getInt("id_food");
					Foods fd = new Foods();

					fd.setFoodId(fIdT);
					finalFoods.add(fd);
					fd = null;
				}

				return finalFoods;
			}

			else if (typeId == 2) {
				int fId = 0;
				List<Foods> finalFoods = new ArrayList<Foods>();

				stmt = conn.createStatement();
				String sql1 = "select id_food from tbl_food_recommend where agrHigh=" + types + "";
				ResultSet rs = stmt.executeQuery(sql1);

				while (rs.next()) {
					Foods fd = new Foods();
					fId = rs.getInt("id_food");

					fd.setFoodId(fId);
					finalFoods.add(fd);
					fd = null;

				}
				return finalFoods;
			} else if (typeId == 3) {
				int fId = 0;
				List<Foods> finalFoods = new ArrayList<Foods>();

				stmt = conn.createStatement();
				String sql1 = "select id_food from tbl_food_recommend where rbcHigh=" + types + "";
				ResultSet rs = stmt.executeQuery(sql1);

				while (rs.next()) {
					Foods fd = new Foods();

					fId = rs.getInt("id_food");

					fd.setFoodId(fId);
					finalFoods.add(fd);
					fd = null;

				}
				return finalFoods;
			} else if (typeId == 5) {
				int fId = 0;
				List<Foods> finalFoods = new ArrayList<Foods>();

				stmt = conn.createStatement();
				String sql1 = "select id_food from tbl_food_recommend where pltHigh=" + types + "";
				ResultSet rs = stmt.executeQuery(sql1);

				while (rs.next()) {
					Foods fd = new Foods();

					fId = rs.getInt("id_food");

					fd.setFoodId(fId);
					finalFoods.add(fd);
					fd = null;

				}

				return finalFoods;
			} else if (typeId == 6) {
				int fId = 0;
				List<Foods> finalFoods = new ArrayList<Foods>();

				stmt = conn.createStatement();
				String sql1 = "select id_food from tbl_food_recommend where uricHigh=" + types + "";
				ResultSet rs = stmt.executeQuery(sql1);

				while (rs.next()) {
					Foods fd = new Foods();
					fId = rs.getInt("id_food");

					fd.setFoodId(fId);
					finalFoods.add(fd);
					fd = null;

				}

				return finalFoods;
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Foods> FoodLow(int typeId, boolean sts) {
		try {
			int types;
			if (sts) {
				types = 1;
			} else
				types = 0;

			stmt = conn.createStatement();
			if (typeId == 1) {
				List<Foods> finalFoods = new ArrayList<Foods>();
				String sql1 = "select id_food from tbl_food_recommend where tplLow=" + types + "";
				ResultSet rs = stmt.executeQuery(sql1);
				int fIdT = 0;
				while (rs.next()) {
					Foods fd = new Foods();

					fIdT = rs.getInt("id_food");
					fd.setFoodId(fIdT);
					finalFoods.add(fd);
					fd = null;

				}
				return finalFoods;
			} else if (typeId == 2) {
				int fId = 0;
				List<Foods> finalFoods = new ArrayList<Foods>();

				stmt = conn.createStatement();
				String sql1 = "select id_food from tbl_food_recommend where agrLow=" + types + "";
				ResultSet rs = stmt.executeQuery(sql1);

				while (rs.next()) {
					Foods fd = new Foods();
					fId = rs.getInt("id_food");
					if (fId != 0) {
						fd.setFoodId(fId);
						finalFoods.add(fd);
						fd = null;

					}
				}
				return finalFoods;
			} else if (typeId == 3) {
				int fId = 0;
				List<Foods> finalFoods = new ArrayList<Foods>();

				stmt = conn.createStatement();
				String sql1 = "select id_food from tbl_food_recommend where rbcLow=" + types + "";
				ResultSet rs = stmt.executeQuery(sql1);
				while (rs.next()) {
					Foods fd = new Foods();

					fId = rs.getInt("id_food");
					if (fId != 0) {
						fd.setFoodId(fId);
						finalFoods.add(fd);
						fd = null;

					}
				}
				return finalFoods;
			} else if (typeId == 5) {
				int fId = 0;
				List<Foods> finalFoods = new ArrayList<Foods>();

				stmt = conn.createStatement();
				String sql1 = "select id_food from tbl_food_recommend where pltLow=" + types + "";
				ResultSet rs = stmt.executeQuery(sql1);

				while (rs.next()) {
					Foods fd = new Foods();

					fId = rs.getInt("id_food");
					if (fId != 0) {
						fd.setFoodId(fId);
						finalFoods.add(fd);
						fd = null;

					}
				}
				return finalFoods;
			} else if (typeId == 6) {
				int fId = 0;
				List<Foods> finalFoods = new ArrayList<Foods>();

				stmt = conn.createStatement();
				String sql1 = "select id_food from tbl_food_recommend where uricLow=" + types + "";
				ResultSet rs = stmt.executeQuery(sql1);

				while (rs.next()) {
					Foods fd = new Foods();

					fId = rs.getInt("id_food");
					if (fId != 0) {
						fd.setFoodId(fId);
						finalFoods.add(fd);
						fd = null;

					}
				}
				return finalFoods;
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<Integer> listOfFid(List<Foods> canEat) {
		try {
			int ids;
			List<Integer> food = new ArrayList<>();
			for (Foods fid : canEat) {
				ids = fid.getFoodId();
				food.add(ids);

			}
			return food;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Recommend> generalRecommendations() {
		try {
			List<Recommend> recommend = new ArrayList<Recommend>();
			stmt = conn.createStatement();
			String sql = "select recommendation from tbl_general_recommendation";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Recommend rc = new Recommend();
				String info = rs.getString("recommendation");
				rc.setGeneralRecommend(info);
				recommend.add(rc);
				rc = null;
			}
			return recommend;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
