package com.kec.project.model;

import java.io.Serializable;

public class Report implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int typeId ,userId,resultId;
	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getResultId() {
		return resultId;
	}

	public void setResultId(int resultId) {
		this.resultId = resultId;
	}

	public String getBloodRange() {
		return bloodRange;
	}

	public void setBloodRange(String bloodRange) {
		this.bloodRange = bloodRange;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
int duration;
	String bloodRange;
	String tpl,agr,rbc,wbc,plt,uric ,currentWt;

	public String getRbc() {
		return rbc;
	}

	public void setRbc(String rbc) {
		this.rbc = rbc;
	}

	public String getWbc() {
		return wbc;
	}

	public void setWbc(String wbc) {
		this.wbc = wbc;
	}

	public String getPlt() {
		return plt;
	}

	public void setPlt(String plt) {
		this.plt = plt;
	}

	public String getAgr() {
		return agr;
	}

	public void setAgr(String agr) {
		this.agr = agr;
	}

	public String getTpl() {
		return tpl;
	}

	public void setTpl(String tpl) {
		this.tpl = tpl;
	}

	public String getUric() {
		return uric;
	}

	public void setUric(String uric) {
		this.uric = uric;
	}

	public String getCurrentWt() {
		return currentWt;
	}

	public void setCurrentWt(String currentWt) {
		this.currentWt = currentWt;
	}
	

}
