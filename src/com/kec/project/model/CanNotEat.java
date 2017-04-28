package com.kec.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CanNotEat implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int foodId ;
	String foodName;
	List<CanNotEat> canNotEatTpl , canNotEatAgr ,canNotEat , avoidFood , canNotEatPlt,canNotEatRbc,canNotEatWbc,canNotEatUric;
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public List<CanNotEat> getCanNotEatTpl() {
		/*if(canNotEatTpl==null)
		{
			canNotEatTpl = new ArrayList<CanNotEat>();
		}*/
		return canNotEatTpl;
	}
	public void setCanNotEatTpl(List<CanNotEat> canNotEatTpl) {
		this.canNotEatTpl = canNotEatTpl;
	}
	public List<CanNotEat> getCanNotEatAgr() {
		/*if(canNotEatAgr == null)
		{
			canNotEatAgr = new ArrayList<CanNotEat>();
		}*/
		return canNotEatAgr;
	}
	public void setCanNotEatAgr(List<CanNotEat> canNotEatAgr) {
		this.canNotEatAgr = canNotEatAgr;
	}
	public List<CanNotEat> getCanNotEat() {
		if(canNotEat == null)
		{
			canNotEat = new ArrayList<CanNotEat>();
		}
		return canNotEat;
	}
	public void setCanNotEat(List<CanNotEat> canNotEat) {
		this.canNotEat = canNotEat;
	}
	public List<CanNotEat> getCanNotEatPlt() {
		return canNotEatPlt;
	}
	public void setCanNotEatPlt(List<CanNotEat> canNotEatPlt) {
		this.canNotEatPlt = canNotEatPlt;
	}
	public List<CanNotEat> getAvoidFood() {
		return avoidFood;
	}
	public void setAvoidFood(List<CanNotEat> avoidFood) {
		this.avoidFood = avoidFood;
	}
	public List<CanNotEat> getCanNotEatRbc() {
		return canNotEatRbc;
	}
	public void setCanNotEatRbc(List<CanNotEat> canNotEatRbc) {
		this.canNotEatRbc = canNotEatRbc;
	}
	public List<CanNotEat> getCanNotEatWbc() {
		return canNotEatWbc;
	}
	public void setCanNotEatWbc(List<CanNotEat> canNotEatWbc) {
		this.canNotEatWbc = canNotEatWbc;
	}
	public List<CanNotEat> getCanNotEatUric() {
		return canNotEatUric;
	}
	public void setCanNotEatUric(List<CanNotEat> canNotEatUric) {
		this.canNotEatUric = canNotEatUric;
	}
}


