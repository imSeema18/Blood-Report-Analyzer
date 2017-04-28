package com.kec.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Foods implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int foodId;
	String nameOfFood,normalRecommends;
	List <Foods> idTplFoodAllow,idAgrFoodAllow,idRbcFoodAllow,idPltFoodAllow,idUricFoodAllow,avoid;
	 List<Foods> idTplFoodAvoid,idAgrFoodAvoid,idRbcFoodAvoid,idPltFoodAvoid,idUricFoodAvoid,allow;
	List<Foods> finalFoods ,avoidFoodTpl,avoidFoodAgr,avoidFoodRBC,avoidFoodWBC,avoidFoodPlt,avoidFoodUric;
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getNameOfFood() {
		return nameOfFood;
	}
	public void setNameOfFood(String nameOfFood) {
		this.nameOfFood = nameOfFood;
	}
	public List<Foods> getFinalFoods() {
		return finalFoods;
	}
	public void setFinalFoods(List<Foods> finalFoods) {
		this.finalFoods = finalFoods;
	}
	public List<Foods> getAvoidFoodTpl() {
		return avoidFoodTpl;
	}
	public void setAvoidFoodTpl(List<Foods> avoidFoodTpl) {
		this.avoidFoodTpl = avoidFoodTpl;
	}
	public List<Foods> getAvoidFoodAgr() {
		return avoidFoodAgr;
	}
	public void setAvoidFoodAgr(List<Foods> avoidFoodAgr) {
		this.avoidFoodAgr = avoidFoodAgr;
	}
	public List<Foods> getAvoidFoodRBC() {
		return avoidFoodRBC;
	}
	public void setAvoidFoodRBC(List<Foods> avoidFoodRBC) {
		this.avoidFoodRBC = avoidFoodRBC;
	}
	public List<Foods> getAvoidFoodWBC() {
		return avoidFoodWBC;
	}
	public void setAvoidFoodWBC(List<Foods> avoidFoodWBC) {
		this.avoidFoodWBC = avoidFoodWBC;
	}
	public List<Foods> getAvoidFoodPlt() {
		return avoidFoodPlt;
	}
	public void setAvoidFoodPlt(List<Foods> avoidFoodPlt) {
		this.avoidFoodPlt = avoidFoodPlt;
	}
	public List<Foods> getAvoidFoodUric() {
		return avoidFoodUric;
	}
	public void setAvoidFoodUric(List<Foods> avoidFoodUric) {
		this.avoidFoodUric = avoidFoodUric;
	}
	public List<Foods> getIdTplFoodAllow() {
		return idTplFoodAllow;
	}
	public void setIdTplFoodAllow(List<Foods> idTplFoodAllow) {
		this.idTplFoodAllow = idTplFoodAllow;
	}
	public List<Foods> getIdAgrFoodAllow() {
		return idAgrFoodAllow;
	}
	public void setIdAgrFoodAllow(List<Foods> idAgrFoodAllow) {
		this.idAgrFoodAllow = idAgrFoodAllow;
	}
	public List<Foods> getIdRbcFoodAllow() {
		return idRbcFoodAllow;
	}
	public void setIdRbcFoodAllow(List<Foods> idRbcFoodAllow) {
		this.idRbcFoodAllow = idRbcFoodAllow;
	}
	public List<Foods> getIdPltFoodAllow() {
		return idPltFoodAllow;
	}
	public void setIdPltFoodAllow(List<Foods> idPltFoodAllow) {
		this.idPltFoodAllow = idPltFoodAllow;
	}
	public List<Foods> getIdUricFoodAllow() {
		return idUricFoodAllow;
	}
	public void setIdUricFoodAllow(List<Foods> idUricFoodAllow) {
		this.idUricFoodAllow = idUricFoodAllow;
	}
	public List<Foods> getIdTplFoodAvoid() {
		return idTplFoodAvoid;
	}
	public void setIdTplFoodAvoid(List<Foods> idTplFoodAvoid) {
		this.idTplFoodAvoid = idTplFoodAvoid;
	}
	public List<Foods> getIdAgrFoodAvoid() {
		return idAgrFoodAvoid;
	}
	public void setIdAgrFoodAvoid(List<Foods> idAgrFoodAvoid) {
		this.idAgrFoodAvoid = idAgrFoodAvoid;
	}
	public List<Foods> getIdRbcFoodAvoid() {
		return idRbcFoodAvoid;
	}
	public void setIdRbcFoodAvoid(List<Foods> idRbcFoodAvoid) {
		this.idRbcFoodAvoid = idRbcFoodAvoid;
	}
	public List<Foods> getIdPltFoodAvoid() {
		return idPltFoodAvoid;
	}
	public void setIdPltFoodAvoid(List<Foods> idPltFoodAvoid) {
		this.idPltFoodAvoid = idPltFoodAvoid;
	}
	public List<Foods> getIdUricFoodAvoid() {
		return idUricFoodAvoid;
	}
	public void setIdUricFoodAvoid(List<Foods> idUricFoodAvoid) {
		this.idUricFoodAvoid = idUricFoodAvoid;
	}
	String waterAmount;
	public List<Foods> getAvoid() {
		if(avoid==null)
		{
			avoid = new ArrayList<Foods>();
		}
		return avoid;
	}
	public void setAvoid(List<Foods> avoid) {
		this.avoid = avoid;
	}
	public List<Foods> getAllow() {
		if(allow==null)
		{
			allow = new ArrayList<Foods>();
		}
		return allow;
	}
	public void setAllow(List<Foods> allow) {
		this.allow = allow;
	}
	public String getWaterAmount() {
		return waterAmount;
	}
	public void setWaterAmount(String waterAmount) {
		this.waterAmount = waterAmount;
	}
	public String getNormalRecommends() {
		return normalRecommends;
	}
	public void setNormalRecommends(String normalRecommends) {
		this.normalRecommends = normalRecommends;
	}

}
