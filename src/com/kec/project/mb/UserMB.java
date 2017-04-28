package com.kec.project.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
//import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
//import javax.faces.context.FacesContext;
import javax.faces.context.FacesContext;

import com.kec.project.ejb.ChartsEJB;
import com.kec.project.ejb.FinalReportEJB;
import com.kec.project.ejb.FoodEJB;
import com.kec.project.ejb.NewUserInfoEjb;
import com.kec.project.ejb.RecommendEJB;
import com.kec.project.ejb.ReportEjb;

import com.kec.project.model.CompositionStatus;
import com.kec.project.model.FoodSts;
import com.kec.project.model.Foods;
import com.kec.project.model.Recommend;
import com.kec.project.model.Record;
import com.kec.project.model.Report;
import com.kec.project.model.UserInfo;

@SessionScoped
@ManagedBean(name = "userMB")
public class UserMB implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	FoodEJB maintainFood;
	@EJB
	NewUserInfoEjb infoejb;
	@EJB
	ReportEjb report;
	@EJB
	ChartsEJB charts;
	@EJB
	RecommendEJB recommend;
	@EJB
	FinalReportEJB finalReport;
	UserInfo newUser = new UserInfo();
	UIComponent cmndLogin;
	UserInfo userDetails = new UserInfo();
	public UserInfo user;
	Recommend recInfo = new Recommend();

	CompositionStatus composition = new CompositionStatus();

	public static final String INJECTION_NAME = "#{userMB}";

	public UserInfo getNewUser() {
		if (newUser == null)
			newUser = new UserInfo();
		return newUser;
	}

	Report newResult = new Report();
	Foods newFood = new Foods();

	public Report getNewResult() {

		if (newResult == null)
			newResult = new Report();
		return newResult;
	}

	public void setNewResult(Report newResult) {
		this.newResult = newResult;
	}

	public void setNewUser(UserInfo newUser) {
		this.newUser = newUser;
	}

	public int checkAccount() {
		/*String hashPw = null;
		try {
			hashPw = FormMB.byteArrayToHexString(FormMB.computeHash(newUser.getPassword()));
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		user = infoejb.checkLogin(newUser);
		if (user.getUserId() == 0) {
			return 0;
		} else {
			System.out.println("login successful");
			return user.getUserId();
		}
	}
public String insertReportAgain()
{
		return "InsertReportAgain";
}
	public String finalCheck() {
		
		if(newUser.getUsername().equals("admin") && newUser.getPassword().equals("admin"))
		{
			return"adminPage";
		}
		else
		{
			
		
		int i = checkAccount();
		if (i == 0) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Incorrect Username or Password", "Please enter correct username and Password"));
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getFlash().setKeepMessages(true);
			return "welcome";
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome " ,newUser.getUsername()));
			context.getExternalContext().getFlash().setKeepMessages(true);

			/*FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome " ,newUser.getUsername()));*/
			int t = 1, a = 2, r = 3, w = 4, p = 5, h = 6;
			int agrSize = charts.getCompInfoPast(i, t).size();
			int tplSize = charts.getCompInfoPast(i, a).size();
			int rbcSize = charts.getCompInfoPast(i, r).size();
			int wbcSize = charts.getCompInfoPast(i, w).size();
			int pltSize = charts.getCompInfoPast(i, p).size();
			int uricSize = charts.getCompInfoPast(i, h).size();
			if (agrSize > 2 || tplSize > 2 || rbcSize > 2 || wbcSize > 2 || pltSize > 2 || uricSize > 2) {
				return "prevGraph";
			} else {
				return "InsertReportAgain";
			}
		}}
	}
	public String finalCheckPage() {
		int i = checkAccount();
		if (i == 0) {
			/*FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Incorrect Username or Passowrd", "Please enter correct username and Password"));
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getFlash().setKeepMessages(true);
			return "welcome";*/
			return null;
		} else {
			/*FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome " ,newUser.getUsername()));
			context.getExternalContext().getFlash().setKeepMessages(true);*/

			/*FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome " ,newUser.getUsername()));*/
			int t = 1, a = 2, r = 3, w = 4, p = 5, h = 6;
			int agrSize = charts.getCompInfoPast(i, t).size();
			int tplSize = charts.getCompInfoPast(i, a).size();
			int rbcSize = charts.getCompInfoPast(i, r).size();
			int wbcSize = charts.getCompInfoPast(i, w).size();
			int pltSize = charts.getCompInfoPast(i, p).size();
			int uricSize = charts.getCompInfoPast(i, h).size();
			if (agrSize > 2 || tplSize > 2 || rbcSize > 2 || wbcSize > 2 || pltSize > 2 || uricSize > 2) {
				return "prevGraph";
			} else {
				return null;
				//return "InsertReportAgain";
			}
		}
	}
	public String pervGraph()
	{
		int i =checkAccount();
		int t = 1, a = 2, r = 3, w = 4, p = 5, h = 6;
		int agrSize = charts.getCompInfoPast(i, t).size();
		int tplSize = charts.getCompInfoPast(i, a).size();
		int rbcSize = charts.getCompInfoPast(i, r).size();
		int wbcSize = charts.getCompInfoPast(i, w).size();
		int pltSize = charts.getCompInfoPast(i, p).size();
		int uricSize = charts.getCompInfoPast(i, h).size();
		if (agrSize > 2 || tplSize > 2 || rbcSize > 2 || wbcSize > 2 || pltSize > 2 || uricSize > 2) {
			return "prevGraph";
		} else {
			return "InsertReportAgain";
		}
	}

	public String newAccountPage() {
		return "newAccount";
	}
	public String takeReportPage() {
		newResult=null;
		return "InsertReportAgain";
	}


	public String recommendPage() {
		if (composition.getNormalRecommend()) {
			return "FinalPage";
		} else 
			return "Recommend";
		
	}
	public String prevPage()
	{
		if(composition.getNormalRecommend())
		{
			return "Reports";
		}
		else
			return "Recommend";
	}

	public void reset() {
		newUser = null;
	}
	public void newUserReset()
	{
		user=null;
	}

	public void resetNewResult() {
		newResult = null;
	}

	public String reportEntry() {
		return "InsertReport";
	}

	public String takeReports(UserInfo newUser) {
		int uid = user.getUserId();
		if (newResult.getTpl().isEmpty()) {
			System.out.println("no data 1");
		} else {
			int tplId = 1;
			System.out.println("tpl entry is" + newResult.getTpl());
			report.insertReport(newResult.getTpl(), uid, tplId);
			System.out.println("TPL record inserted");
		}
		if (newResult.getAgr().isEmpty()) {
			System.out.println("no data 2");

		} else {
			int agrId = 2;
			report.insertReport(newResult.getAgr(), uid, agrId);
			System.out.println("agr record inserted");
		}
		if (newResult.getRbc().isEmpty()) {
			System.out.println("no data 3 ");

		} else {
			int rbcId = 3;
			report.insertReport(newResult.getRbc(), uid, rbcId);
			System.out.println("rbc record inserted");
		}
		if (newResult.getPlt().isEmpty()) {
			System.out.println("no data5");
		} else {
			int pltId = 5;
			report.insertReport(newResult.getPlt(), uid, pltId);
			System.out.println("plt record inserted");
		}
		if (newResult.getUric().isEmpty()) {
			System.out.println("no data 6 ");
		} else {
			int urcId = 6;
			report.insertReport(newResult.getUric(), uid, urcId);
			System.out.println("Uric record inserted");
		}
		reports(newResult);

		checkForRecommendation();
		int i = user.getUserId();
		int t = 1, a = 2, r = 3, w = 4, p = 5, h = 6;
		int agrSize = charts.getCompInfoPast(i, t).size();
		int tplSize = charts.getCompInfoPast(i, a).size();
		int rbcSize = charts.getCompInfoPast(i, r).size();
		int wbcSize = charts.getCompInfoPast(i, w).size();
		int pltSize = charts.getCompInfoPast(i, p).size();
		int uricSize = charts.getCompInfoPast(i, h).size();
		if (agrSize > 2 || tplSize > 2 || rbcSize > 2 || wbcSize > 2 || pltSize > 2 || uricSize > 2) {
			return "currentGraph";
		} else {
			return "Reports";
		}

	}

	public String reportPage() {
		/*if(composition.getNormalRecommend())
		{
			return "FinalPage";
		}*/
		return "Reports";
	}

	Record oldReport = new Record();
	CompositionStatus compSts = new CompositionStatus();

	public Boolean reports(Report newResult) {
		oldReport = charts.getAllRec();
		if (!newResult.getTpl().isEmpty() && !(oldReport.getCmpTpl()==null)) {
			String pastTpl = "Your previous Total Protein level was " + oldReport.getCmpTpl() + " gm/dL";
			compSts.setShowPastTpl(pastTpl);
			Float newTpl = Float.valueOf(newResult.getTpl());
			Float oldTpl = Float.valueOf(oldReport.getCmpTpl());
			Float result = newTpl - oldTpl;
			if (result < 0) {
				String showTplSts = "Currently, Your Total Protein level  is decreasing";
				compSts.setShowCurrTpl(showTplSts);
			} else {
				String showTplSts = " Currently, Your Total Protein level is increasing";
				compSts.setShowCurrTpl(showTplSts);
			}
		}
		if (!newResult.getAgr().isEmpty() && !(oldReport.getCmpAgr()==null)) {
			String pastAgr = "Your previous Albumin/Globumin ratio was " + oldReport.getCmpAgr() + "";
			compSts.setShowPastAgr(pastAgr);
			Float newAgr = Float.valueOf(newResult.getAgr());
			Float oldAgr = Float.valueOf(oldReport.getCmpAgr());
			Float result = newAgr - oldAgr;
			if (result < 0) {
				String showAgrSts = "Currently, Your Albumin/Globumin ratio is decreasing";
				compSts.setShowCurrAgr(showAgrSts);
			} else {
				String showAgrSts = " Currently, Your Albumin/Globumin ratio is increasing";
				compSts.setShowCurrAgr(showAgrSts);
			}
		}
		if (!newResult.getRbc().isEmpty() && !(oldReport.getCmpRbc()==null)) {
			String pastRbc = "Your previous Red Blood cells  count was " + oldReport.getCmpRbc()
					+ " million cells/microliter";
			compSts.setShowPastRbc(pastRbc);
			Float newRbc = Float.valueOf(newResult.getRbc());
			Float oldRbc = Float.valueOf(oldReport.getCmpRbc());
			Float result = newRbc - oldRbc;
			if (result < 0) {
				String showRbcSts = "Currently, Your Red Blood cells count is decreasing";
				compSts.setShowCurrRbc(showRbcSts);
			} else {
				String showRbcSts = " Currently, Your Red Blood cells count is increasing";
				compSts.setShowCurrRbc(showRbcSts);
			}
		}
		if (!newResult.getPlt().isEmpty() && !(oldReport.getCmpPlt()==null)) {
			String pastPlt = "Your previous Platelets count was " + oldReport.getCmpPlt() + " /mcl";
			compSts.setShowPastPlt(pastPlt);
			Float newPlt = Float.valueOf(newResult.getPlt());
			Float oldPlt = Float.valueOf(oldReport.getCmpPlt());
			Float result = newPlt - oldPlt;
			if (result < 0) {
				String showPltSts = "Currently, Your Platelets count is decreasing";
				compSts.setShowCurrPlt(showPltSts);
			} else {
				String showPltSts = " Currently, Your Platelets count is increasing";
				compSts.setShowCurrPlt(showPltSts);
			}
		}
		if (!newResult.getUric().isEmpty() && !(oldReport.getCmpUric()==null) ){
			String pastUric = "Your previous Uric Acid level was " + oldReport.getCmpUric() + " mg/dL";
			compSts.setShowPastUric(pastUric);
			Float newUric = Float.valueOf(newResult.getUric());
			Float oldUric = Float.valueOf(oldReport.getCmpUric());
			Float result = newUric - oldUric;
			if (result < 0) {
				String showUricSts = "Currently, Your Uric Acid level is decreasing";
				compSts.setShowCurrUric(showUricSts);
			} else {
				String showUricSts = "Currently, Your Uric Acid level is increasing";
				compSts.setShowCurrUric(showUricSts);
			}
		}
		Boolean chck = true;
		return chck;

	}

	Foods avoidIt = new Foods();
	Foods water = new Foods();
	public String currentChart()

	{
		return  "currentGraph";
	}
	/*public String c()

	{
		return  "currentGraph";
	}*/
	String tplDisease, agrDisease, rbcDisease, wbcDisease, pltDisease, rbcHigh, uricDisease;

	public void checkForRecommendation() {
		List<Foods> canNotEatAgr = new ArrayList<Foods>();
		List<Foods> canEatAgr = new ArrayList<Foods>();
		List<Foods> canEatTpl = new ArrayList<Foods>();
		List<Foods> canNotEatTpl = new ArrayList<Foods>();
		List<Foods> canNotEat = new ArrayList<Foods>();
		List<Foods> canEat = new ArrayList<Foods>();
		List<Foods> canNotEat1 = new ArrayList<Foods>();
		List<Foods> canEat1 = new ArrayList<Foods>();
		List<Foods> avoidFood = new ArrayList<Foods>();
		List<Foods> canEatPlt = new ArrayList<Foods>();
		List<Foods> canNotEatPlt = new ArrayList<Foods>();
		List<Foods> avoidFoods = new ArrayList<Foods>();
		List<Foods> canNotEatRbc = new ArrayList<Foods>();
		List<Foods> canEatRbc = new ArrayList<Foods>();
		List<Foods> canNotEatUric = new ArrayList<Foods>();
		List<Foods> canEatUric = new ArrayList<Foods>();
		Foods allows = new Foods();
		Foods avoid = new Foods();
		String maxRange, minRange, current;
		int id;
		Boolean sts = false;
		if (newResult.getTpl().isEmpty()) {
			System.out.println("no tpl data");
			composition.setTplRec(false);
		} else {
			id = 1;
			maxRange = recommend.getMaxRange(id);
			minRange = recommend.getMinRange(id);
			current = newResult.getTpl();
			float max = Float.valueOf(maxRange);
			float min = Float.valueOf(minRange);
			float currentTpl = Float.valueOf(current);
			if (currentTpl >= min && currentTpl <= max) {
				String tplStatus = "Your total protein level is normal";
				composition.setTplNormal(true);
				composition.setTplStatus(tplStatus);
				composition.setTplRec(false);

			} else if (currentTpl < min)

			{
				composition.setTplNormal(false);
				composition.setTplRec(true);
				sts = true;
				canEatTpl = recommend.FoodLow(id, sts);
				sts = false;

				canNotEatTpl = recommend.FoodLow(id, sts);
				String tplStatus = "Total protein level is low";
				composition.setTplStatus(tplStatus);
				tplDisease = recommend.diseaseLow(id);
				String tplDis = "You are at risk of " + tplDisease + "";
				setTplDisease(tplDis);
				avoidFoods = recommend.avoidFood(canNotEatTpl);
				avoidIt.setAvoidFoodTpl(avoidFoods);
				System.out.println("Your Tpl is Low ");
				System.out.println("You have symptoms of " + tplDisease);

				System.out.println("You should avoid eating following foods");

				for (Foods fd : avoidFoods) {
					System.out.println(fd.getNameOfFood());
				}
				finalReport.insertFoodReport(user.getUserId(), id, tplDisease, canEatTpl, canNotEatTpl);
			} else {
				composition.setTplNormal(false);
				composition.setTplRec(true);
				sts = true;
				canEatTpl = recommend.FoodHigh(id, sts);
				allows.setIdTplFoodAllow(canEatTpl);
				sts = false;
				canNotEatTpl = recommend.FoodHigh(id, sts);
				String tplStatus = "Total Protein Level is High";
				composition.setTplStatus(tplStatus);
				tplDisease = recommend.diseaseLow(id);
				String tplDis = "You are at risk of " + tplDisease + "";
				setTplDisease(tplDis);
				avoidFoods = recommend.avoidFood(canNotEatTpl);
				avoidIt.setAvoidFoodTpl(avoidFoods);
				System.out.println("Your Tpl is High ");
				System.out.println("You have symptoms of " + tplDisease);
				System.out.println("You should avoid eating following foods");
				for (Foods fd : avoidFoods) {
					System.out.println(fd.getNameOfFood());
				}
				finalReport.insertFoodReport(user.getUserId(), id, tplDisease, canEatTpl, canNotEatTpl);

			}
		}
		if (newResult.getAgr().isEmpty()) {
			System.out.println("no agr data");

		} else {
			id = 2;
			maxRange = recommend.getMaxRange(id);
			minRange = recommend.getMinRange(id);
			current = newResult.getAgr();
			float max = Float.valueOf(maxRange);
			float min = Float.valueOf(minRange);
			float currentAgr = Float.valueOf(current);
			if (currentAgr >= min && currentAgr <= max) {
				String agrStatus = "Your Albumin/Globumin ratio is normal";
				composition.setAgrStatus(agrStatus);
				composition.setAgrNormal(true);
				composition.setAgrRec(false);

			} else if (currentAgr < min) {
				composition.setAgrNormal(false);
				composition.setAgrRec(true);
				sts = true;
				canEatAgr = recommend.FoodLow(id, sts);
				sts = false;

				canNotEatAgr = recommend.FoodLow(id, sts);
				String agrStatus = "Albumin/Globumin ratio is low";
				composition.setAgrStatus(agrStatus);
				agrDisease = recommend.diseaseLow(id);
				String agrDis = "You are at risk of " + agrDisease + "";
				setAgrDisease(agrDis);
				avoidFoods = recommend.avoidFood(canNotEatAgr);
				avoidIt.setAvoidFoodAgr(avoidFoods);
				System.out.println("Your Agr is Low ");
				System.out.println("You have symptoms of " + agrDisease);

				System.out.println("You should avoid eating following foods");

				for (Foods fd : avoidFoods) {
					System.out.println(fd.getNameOfFood());
				}
				finalReport.insertFoodReport(user.getUserId(), id, agrDisease, canEatAgr, canNotEatAgr);

			} else {
				composition.setAgrNormal(false);
				String agrStatus = "Albumin/Globumin ratio is high";
				composition.setAgrStatus(agrStatus);
				composition.setAgrRec(true);
				agrDisease = recommend.diseaseHigh(id);
				String agrDis = "You are at risk of " + agrDisease + "";
				setAgrDisease(agrDis);
				sts = true;
				canEatAgr = recommend.FoodHigh(id, sts);
				sts = false;
				canNotEatAgr = recommend.FoodHigh(id, sts);
				System.out.println("Your Agr is high \n You should avoid eating following foods");

				System.out.println("You have symptoms of " + agrDisease);
				avoidFoods = recommend.avoidFood(canNotEatAgr);
				avoidIt.setAvoidFoodAgr(avoidFoods);
				for (Foods fd : avoidFoods) {
					System.out.println(fd.getNameOfFood());
				}
				finalReport.insertFoodReport(user.getUserId(), id, agrDisease, canEatAgr, canNotEatAgr);

			}
		}
		if (newResult.getPlt().isEmpty()) {
			System.out.println("no plt data");
			composition.setPltRec(false);
		} else {
			id = 5;
			maxRange = recommend.getMaxRange(id);
			minRange = recommend.getMinRange(id);
			current = newResult.getPlt();
			float max = Float.valueOf(maxRange);
			float min = Float.valueOf(minRange);
			float currentPlt = Float.valueOf(current);
			if (currentPlt >= min && currentPlt <= max) {
				String pltSts = "Your Platelets count is in normal range";
				composition.setPltNormal(true);
				composition.setPltStatus(pltSts);
				composition.setPltRec(false);

			} else if (currentPlt < min) {
				composition.setPltRec(true);
				composition.setPltNormal(false);
				pltDisease = recommend.diseaseLow(id);
				String pltDis = "You are at risk of " + pltDisease + "";
				setPltDisease(pltDis);
				String pltStatus = "Platelets count is low";
				composition.setPltStatus(pltStatus);
				sts = true;
				canEatPlt = recommend.FoodLow(id, sts);
				sts = false;
				canNotEatPlt = recommend.FoodLow(id, sts);
				System.out.println("Your Plt is low \n You should avoid eating following foods");
				avoidFoods = recommend.avoidFood(canNotEatPlt);
				avoidIt.setAvoidFoodPlt(avoidFoods);
				for (Foods fd : avoidFoods) {
					System.out.println(fd.getNameOfFood());
				}
				finalReport.insertFoodReport(user.getUserId(), id, pltDisease, canEatPlt, canNotEatPlt);

			} else {
				composition.setPltRec(true);
				composition.setPltNormal(false);
				String pltStatus = "Platelets count is high";
				composition.setPltStatus(pltStatus);
				pltDisease = recommend.diseaseHigh(id);
				String pltDis = "You are at risk of " + pltDisease + "";
				setPltDisease(pltDis);
				sts = true;
				canEatPlt = recommend.FoodHigh(id, sts);
				sts = false;
				canNotEatPlt = recommend.FoodHigh(id, sts);
				System.out.println("Your Plt is high \n You should avoid eating following foods");
				avoidFoods = recommend.avoidFood(canNotEatPlt);
				avoidIt.setAvoidFoodPlt(avoidFoods);

				for (Foods fd : avoidFoods) {
					System.out.println(fd.getNameOfFood());
				}
				finalReport.insertFoodReport(user.getUserId(), id, pltDisease, canEatPlt, canNotEatPlt);

			}
		}

		if (newResult.getRbc().isEmpty()) {
			System.out.println("no rbc data");
			composition.setRbcRec(false);

		} else {
			composition.setRbcRec(true);
			id = 3;
			maxRange = recommend.getMaxRangeGen(id, user.getGender());
			minRange = recommend.getMinRangeGen(id, user.getGender());
			current = newResult.getRbc();
			float rMax = Float.valueOf(maxRange);
			float rMin = Float.valueOf(minRange);
			float currentRbc = Float.valueOf(current);
			if (currentRbc >= rMin && currentRbc <= rMax) {
				String rbcStatus = "Your red blood cells count is normal";
				composition.setRbcNormal(true);
				composition.setRbcStatus(rbcStatus);
				composition.setRbcRec(false);

			} else if (currentRbc < rMin) {
				composition.setRbcRec(true);
				composition.setRbcNormal(false);
				rbcDisease = recommend.getDiseaseLowGen(id, user.getGender());
				String rbcDis = "You are at risk of " + rbcDisease + "";
				setRbcDisease(rbcDis);
				String rbcStatus = "Red Blood Cell count is low";
				composition.setRbcStatus(rbcStatus);
				sts = true;
				canEatRbc = recommend.FoodLow(id, sts);
				allows.setIdRbcFoodAllow(canEatRbc);
				sts = false;
				canNotEatRbc = recommend.FoodLow(id, sts);
				avoid.setIdRbcFoodAvoid(canNotEatRbc);
				System.out.println("Your RBC is low \n You should avoid eating following foods");
				avoidFoods = recommend.avoidFood(canNotEatRbc);
				avoidIt.setAvoidFoodRBC(avoidFoods);
				for (Foods fd : avoidFoods) {
					System.out.println(fd.getNameOfFood());
				}
				finalReport.insertFoodReport(user.getUserId(), id, rbcDisease, canEatRbc, canNotEatRbc);

			} else {
				composition.setRbcRec(true);
				composition.setRbcNormal(false);
				String rbcStatus = "Red Blood Cell is high";
				composition.setRbcStatus(rbcStatus);
				rbcDisease = recommend.getDiseaseHighGen(id, user.getGender());
				String rbcDis = "You are at risk of " + rbcDisease + "";
				setRbcDisease(rbcDis);
				rbcHigh = "If possible try to donate blood";
				setRbcHigh(rbcHigh);
				sts = true;
				canEatRbc = recommend.FoodHigh(id, sts);
				sts = false;
				canNotEatRbc = recommend.FoodHigh(id, sts);

				System.out.println("Your RBC is high \n You should avoid eating following foods");
				avoidFoods = recommend.avoidFood(canNotEatRbc);
				avoidIt.setAvoidFoodRBC(avoidFoods);
				for (Foods fd : avoidFoods) {
					System.out.println(fd.getNameOfFood());
				}
				finalReport.insertFoodReport(user.getUserId(), id, rbcDisease, canEatRbc, canNotEatRbc);

			}
		}
		if (newResult.getUric().isEmpty()) {
			System.out.println("no Uric data");
			composition.setUricRec(false);
		} else {
			id = 6;
			maxRange = recommend.getMaxRangeGen(id, user.getGender());
			minRange = recommend.getMinRangeGen(id, user.getGender());
			current = newResult.getUric();
			float rMax = Float.valueOf(maxRange);
			float rMin = Float.valueOf(minRange);
			float currents = Float.valueOf(current);
			if (currents >= rMin && currents <= rMax) {
				composition.setUricRec(false);
				composition.setUricNormal(true);
				String uricStatus = "Your uric acid level is normal";
				composition.setUricStatus(uricStatus);
			} else if (currents < rMin) {
				composition.setUricRec(true);
				composition.setUricNormal(false);
				uricDisease = recommend.getDiseaseLowGen(id, user.getGender());
				String uricDis = "You are at risk of " + uricDisease + "";
				setUricDisease(uricDis);
				String uricStatus = "Uric acid level  is low";
				composition.setUricStatus(uricStatus);
				sts = true;
				canEatUric = recommend.FoodLow(id, sts);
				sts = false;
				canNotEatUric = recommend.FoodLow(id, sts);
				System.out.println("Your Uric is low \n You should avoid eating following foods");
				avoidFoods = recommend.avoidFood(canNotEatUric);
				avoidIt.setAvoidFoodUric(avoidFoods);
				for (Foods fd : avoidFoods) {
					System.out.println(fd.getNameOfFood());
				}
				finalReport.insertFoodReport(user.getUserId(), id, uricDisease, canEatUric, canNotEatUric);

			} else {
				composition.setUricRec(true);
				composition.setUricNormal(false);
				String uricStatus = "Uric is high";
				composition.setUricStatus(uricStatus);
				uricDisease = recommend.getDiseaseHighGen(id, user.getGender());
				String uricDis = "You are at risk of " + uricDisease + "";
				setUricDisease(uricDis);
				sts = true;
				canEatUric = recommend.FoodHigh(id, sts);
				allows.setIdUricFoodAllow(canEatRbc);
				sts = false;
				canNotEatUric = recommend.FoodHigh(id, sts);
				avoid.setIdUricFoodAvoid(canNotEatUric);
				System.out.println("Your Uric is high \n You should avoid eating following foods");
				avoidFoods = recommend.avoidFood(canNotEatUric);
				avoidIt.setAvoidFoodUric(avoidFoods);
				for (Foods fd : avoidFoods) {
					System.out.println(fd.getNameOfFood());
				}
				finalReport.insertFoodReport(user.getUserId(), id, uricDisease, canEatUric, canNotEatUric);

			}

		}
		if (canEatAgr != null) {
			List<Foods> canNotEatTemp = new ArrayList<Foods>();
			List<Foods> canEatTemp = new ArrayList<Foods>();
			canEatTemp = allows.getAllow();
			for (Foods ce : canEatAgr) {
				if (!(canEatTemp.contains(ce.getFoodId()))) {
					canEatTemp.add(ce);
				}
			}
			// canEat1 =
			// canEatTemp.stream().distinct().collect(Collectors.toList());
			allows.setAllow(canEatTemp);
			canNotEatTemp = avoid.getAvoid();
			canNotEatTemp.addAll(canNotEatAgr);
			avoid.setAvoid(canNotEatTemp);
		} else {
			System.out.println("no agr recommend");
		}
		if (!canEatTpl.isEmpty()) {
			List<Foods> canNotEatTemp = new ArrayList<Foods>();
			List<Foods> canEatTemp = new ArrayList<Foods>();
			canEatTemp = allows.getAllow();
			for (Foods ce : canEatTpl) {
				if (!(canEatTemp.contains(ce.getFoodId()))) {
					canEatTemp.add(ce);
				}
			}
			allows.setAllow(canEatTemp);
			canNotEatTemp = avoid.getAvoid();
			canNotEatTemp.addAll(canNotEatTpl);
			canNotEat1 = canNotEatTemp;
			avoid.setAvoid(canNotEat1);
		} else {
			System.out.println("no tpl recommend");
		}
		if (!canEatPlt.isEmpty()) {
			List<Foods> canNotEatTemp = new ArrayList<Foods>();
			List<Foods> canEatTemp = new ArrayList<Foods>();
			canEatTemp = allows.getAllow();
			for (Foods ce : canEatPlt) {
				if (!(canEatTemp.contains(ce.getFoodId()))) {
					canEatTemp.add(ce);
				}
			}
			canEat1 = canEatTemp;
			allows.setAllow(canEat1);
			canNotEatTemp = avoid.getAvoid();
			canNotEatTemp.addAll(canNotEatPlt);
			canNotEat1 = canNotEatTemp;
			avoid.setAvoid(canNotEat1);
		} else {
			System.out.println("no plt recommend");
		}
		if (!canEatRbc.isEmpty()) {
			List<Foods> canNotEatTemp = new ArrayList<Foods>();
			List<Foods> canEatTemp = new ArrayList<Foods>();
			canEatTemp = allows.getAllow();
			for (Foods ce : canEatRbc) {
				if (!(canEatTemp.contains(ce.getFoodId()))) {
					canEatTemp.add(ce);
				}
			}
			canEat1 = canEatTemp;
			allows.setAllow(canEat1);
			canNotEatTemp = avoid.getAvoid();
			canNotEatTemp.addAll(avoid.getIdRbcFoodAvoid());
			canNotEat1 = canNotEatTemp;
			avoid.setAvoid(canNotEat1);
		} else {
			System.out.println("no rbc recommend");
		}
		if (!canEatUric.isEmpty()) {
			List<Foods> canNotEatTemp = new ArrayList<Foods>();
			List<Foods> canEatTemp = new ArrayList<Foods>();
			canEatTemp = allows.getAllow();
			for (Foods ce : canEatUric) {
				if (!(canEatTemp.contains(ce.getFoodId()))) {
					canEatTemp.add(ce);
				}
			}
			canEat1 = canEatTemp;
			allows.setAllow(canEat1);
			canNotEatTemp = avoid.getAvoid();
			canNotEatTemp.addAll(canNotEatUric);
			canNotEat1 = canNotEatTemp;
			avoid.setAvoid(canNotEat1);
		} else {
			System.out.println("no uric recommend");
		}
		canEat = allows.getAllow();
		canNotEat = avoid.getAvoid();
		for (Foods ce : canEat) {
			for (Foods cne : canNotEat) {
				if (ce.getFoodId() != cne.getFoodId()) {
				} else {
					avoidFood.add(ce);
				}
			}

		}
		avoid.setAvoid(avoidFood);
		// allows.setAvoidFood(avoidFood);
		System.out.println("Size of avoidFoods" + avoidFood.size());
		System.out.println("size of can eat" + canEat.size());
		canEat.removeAll(avoid.getAvoid());
		System.out.println("size of can eat" + canEat.size());
		foods(canEat);
		// recommend amount of water

		float wght = Float.valueOf(user.getWeight());
		float amount = wght * 45;
		float amnts = amount / 1000;
		String amnt = "You need to drink atleast " + amnts + " liters of water per day";
		water.setWaterAmount(amnt);

		// normal recommendation
		List<Recommend> record = new ArrayList<Recommend>();
		record = recommend.generalRecommendations();
		recInfo.setRec(record);
		record = recInfo.getRec();
	}

	public String finalPages() {
		return "FinalPage";
	}
	public String insertFoodSts()
	{
		int fId = newFood.getFoodId();
		System.out.println("Change record");
		maintainFood.insertFoodSts(fId,foodSts);
		return "";
		
		}
	public String  addFood()
	{
		//newFood= null;
		foodSts = null;
		return "adminPage";
	}
	public String welcomePage() {

		return "welcome";
	}

	public String updatePage() {
		return "UpdateInfo";
	}

	List<Foods> finalFoods = new ArrayList<Foods>();
	Foods correctFood = new Foods();
	String weight, waterAmount;
	public String checkFood()
	{
		//List<Foods> allFood = new ArrayList<Foods>();
	//	allFood = maintainFood.listOfFood();
		/*if(allFood.contains(newFood.getNameOfFood()))
		{
			System.out.println("Already present");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "This food already exist in our database" ,"Enter new food"));
			context.getExternalContext().getFlash().setKeepMessages(true);
			newFood = null;
			return "adminPage";
		}
		else
		{*/
		Boolean check = maintainFood.addFood(newFood.getNameOfFood());;
			if(check)
			{
			
			int foodId = maintainFood.foodId(newFood.getNameOfFood());
			newFood.setFoodId(foodId);
			System.out.println("Not present in db");
			return "UpdateFoods";
			}
			else
			{
				System.out.println("Already present");
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "This food already exist in our database" ,"Enter new food"));
				context.getExternalContext().getFlash().setKeepMessages(true);
				//newFood = null;
				return "adminPage";
				
			}
		}
	

	public void foods(List<Foods> canEat) {
		List<Integer> food = new ArrayList<>();
		food = recommend.listOfFid(canEat);
		Set<Integer> uni = new HashSet<Integer>(food);
		List<Integer> fids = new ArrayList<Integer>(uni);
		List<Foods> foods = new ArrayList<Foods>();
		foods = recommend.nameOfFood(fids);
		if (!foods.isEmpty()) {
			composition.setFinalFoodSts(true);
			correctFood.setFinalFoods(foods);
		} else {
			composition.setFinalFoodSts(false);
		
			//correctRecommend.setNormalRecommends(abc);
		}
		checkForNormal();
	}

	public String updateInfo() {
		
		boolean updt = infoejb.updateDatas(getUser());
		if (updt) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Successfully", "Updated " + user.getUsername()));
		} else {
			FacesContext context = FacesContext.getCurrentInstance();

			context.addMessage(null, new FacesMessage("Update", "fail " + user.getUsername()));

		}
		return "InsertReport";
	}
	
	public void checkForNormal() {
		if (newResult.getTpl().isEmpty()) {
			composition.setNormalRecommend(true);
		} else {
			if (composition.getTplNormal()) {
				composition.setNormalRecommend(true);
			} else {
				composition.setNormalRecommend(false);
			}
		}
		Boolean tplNormal = composition.getNormalRecommend();
		if (newResult.getAgr().isEmpty()) {
			composition.setNormalRecommend(true);
		} else {
			if (composition.getAgrNormal()) {
				composition.setNormalRecommend(true);
			} else {
				composition.setNormalRecommend(false);
			}
		}
		Boolean agrNormal = composition.getNormalRecommend();
		if (newResult.getRbc().isEmpty()) {
			composition.setNormalRecommend(true);
		} else {
			if (composition.getRbcNormal()) {
				composition.setNormalRecommend(true);
			} else {
				composition.setNormalRecommend(false);
			}
		}
		Boolean rbcNormal = composition.getNormalRecommend();
		if (newResult.getPlt().isEmpty()) {
			composition.setNormalRecommend(true);
		} else {
			if (composition.getPltNormal()) {
				composition.setNormalRecommend(true);
			} else {
				composition.setNormalRecommend(false);
			}
		}
		Boolean pltNormal = composition.getNormalRecommend();
		if (newResult.getUric().isEmpty()) {
			composition.setNormalRecommend(true);
		} else {
			if (composition.getUricNormal()) {
				composition.setNormalRecommend(true);
			} else {
				composition.setNormalRecommend(false);
			}
		}
		Boolean uricNormal = composition.getNormalRecommend();
		if (tplNormal && agrNormal && rbcNormal && pltNormal && uricNormal) {
			composition.setNormalRecommend(true);
		} else
			composition.setNormalRecommend(false);

	}

	Foods correctRecommend = new Foods();

	public UserInfo getUser() {
		if (user == null)
			user = new UserInfo();
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public Foods getCorrectFood() {
		if (correctFood == null)
			correctFood = new Foods();
		return correctFood;
	}

	public void setCorrectFood(Foods correctFood) {
		this.correctFood = correctFood;
	}

	public Foods getAvoidIt() {
		if (avoidIt == null) {
			avoidIt = new Foods();
		}
		return avoidIt;
	}

	public void setAvoidIt(Foods avoidIt) {
		this.avoidIt = avoidIt;
	}

	public CompositionStatus getComposition() {
		if (composition == null) {
			composition = new CompositionStatus();
		}
		return composition;
	}

	public void setCompostion(CompositionStatus composition) {
		this.composition = composition;
	}

	public String getTplDisease() {
		return tplDisease;
	}
	FoodSts foodSts = new FoodSts();

	public void setTplDisease(String tplDisease) {
		this.tplDisease = tplDisease;
	}

	public String getAgrDisease() {
		return agrDisease;
	}

	public void setAgrDisease(String agrDisease) {
		this.agrDisease = agrDisease;
	}

	public String getRbcDisease() {
		return rbcDisease;
	}

	public void setRbcDisease(String rbcDisease) {
		this.rbcDisease = rbcDisease;
	}

	public String getWbcDisease() {
		return wbcDisease;
	}

	public void setWbcDisease(String wbcDisease) {
		this.wbcDisease = wbcDisease;
	}

	public String getPltDisease() {
		return pltDisease;
	}

	public void setPltDisease(String pltDisease) {
		this.pltDisease = pltDisease;
	}

	public UserInfo getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserInfo userDetails) {
		this.userDetails = userDetails;
	}
	// CompositionStatus compSts = new CompositionStatus();

	public String getRbcHigh() {
		return rbcHigh;
	}

	public void setRbcHigh(String rbcHigh) {
		this.rbcHigh = rbcHigh;
	}

	public String getUricDisease() {
		return uricDisease;
	}

	public void setUricDisease(String uricDisease) {
		this.uricDisease = uricDisease;
	}

	public Foods getWater() {
		return water;
	}

	public void setWater(Foods water) {
		this.water = water;
	}

	public CompositionStatus getCompSts() {
		return compSts;
	}

	public void setCompSts(CompositionStatus compSts) {
		this.compSts = compSts;
	}

	public Foods getCorrectRecommend() {
		return correctRecommend;
	}

	public void setCorrectRecommend(Foods correctRecommend) {
		this.correctRecommend = correctRecommend;
	}

	public Recommend getRecInfo() {
		return recInfo;
	}

	public void setRecInfo(Recommend recInfo) {
		this.recInfo = recInfo;
	}

	public Foods getNewFood() {
		return newFood;
	}

	public void setNewFood(Foods newFood) {
		this.newFood = newFood;
	}

	public FoodSts getFoodSts() {
		return foodSts;
	}

	public void setFoodSts(FoodSts foodSts) {
		this.foodSts = foodSts;
	}

}
