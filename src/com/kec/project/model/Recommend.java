package com.kec.project.model;

import java.io.Serializable;
import java.util.List;

public class Recommend implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String generalRecommend;
	int recommendId;
	List<Recommend> rec;
	public String getGeneralRecommend() {
		return generalRecommend;
	}
	public void setGeneralRecommend(String generalRecommend) {
		this.generalRecommend = generalRecommend;
	}
	public int getRecommendId() {
		return recommendId;
	}
	public void setRecommendId(int recommendId) {
		this.recommendId = recommendId;
	}
	public List<Recommend> getRec() {
		return rec;
	}
	public void setRec(List<Recommend> rec) {
		this.rec = rec;
	}
	

}
