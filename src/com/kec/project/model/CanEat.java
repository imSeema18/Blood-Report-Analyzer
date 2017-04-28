package com.kec.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CanEat implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int foodId ;
	String foodName;
	List<CanEat> canEatTpl , canEatAgr ,canEat,avoidFood,canEatPlt,canEatRbc,canEatWbc,canEatUric;
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
	public List<CanEat> getCanEatTpl() {
		/*if(canEatTpl==null)
		{
			canEatTpl =  new ArrayList<CanEat>();
		}*/
		return canEatTpl;
	}
	public void setCanEatTpl(List<CanEat> canEatTpl) {
		
		this.canEatTpl = canEatTpl;
	}
	public List<CanEat> getCanEatAgr() {
		/*if(canEatAgr==null)
		{
			canEatAgr =  new ArrayList<CanEat>();
		}*/
		return canEatAgr;
	}
	public void setCanEatAgr(List<CanEat> canEatAgr) {
		this.canEatAgr = canEatAgr;
	}
	public List<CanEat> getCanEat() {
		if(canEat==null)
		{
			canEat =  new ArrayList<CanEat>();
		}
		return canEat;
	}
	public void setCanEat(List<CanEat> canEat) {
		this.canEat = canEat;
	}
	public List<CanEat> getAvoidFood() {
		if(avoidFood==null)
		{
			avoidFood =  new ArrayList<CanEat>();
		}
		return avoidFood;
	}
	public void setAvoidFood(List<CanEat> avoidFood) {
		this.avoidFood = avoidFood;
	}
	public List<CanEat> getCanEatPlt() {
		return canEatPlt;
	}
	public void setCanEatPlt(List<CanEat> canEatPlt) {
		this.canEatPlt = canEatPlt;
	}
	public List<CanEat> getCanEatRbc() {
		return canEatRbc;
	}
	public void setCanEatRbc(List<CanEat> canEatRbc) {
		this.canEatRbc = canEatRbc;
	}
	public List<CanEat> getCanEatWbc() {
		return canEatWbc;
	}
	public void setCanEatWbc(List<CanEat> canEatWbc) {
		this.canEatWbc = canEatWbc;
	}
	public List<CanEat> getCanEatUric() {
		return canEatUric;
	}
	public void setCanEatUric(List<CanEat> canEatUric) {
		this.canEatUric = canEatUric;
	}

}
