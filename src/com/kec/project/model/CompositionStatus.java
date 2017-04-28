package com.kec.project.model;

import java.io.Serializable;

public class CompositionStatus implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String tplStatus,agrStatus,pltStatus,rbcStatus,wbcStatus,uricStatus;
	Boolean tplRec,wbcRec,agrRec,rbcRec,uricRec,pltRec ,finalFoodSts;
	String showPastTpl,showPastAgr ,showPastRbc,showPastPlt,showPastUric;
	String showCurrTpl,showCurrAgr,showCurrRbc,showCurrPlt,showCurrUric;
	Boolean tplNormal,agrNormal,rbcNormal,pltNormal,uricNormal,normalRecommend;
	

	public String getTplStatus() {
		return tplStatus;
	}

	public void setTplStatus(String tplStatus) {
		this.tplStatus = tplStatus;
	}

	public String getAgrStatus() {
		return agrStatus;
	}

	public void setAgrStatus(String agrStatus) {
		this.agrStatus = agrStatus;
	}

	public String getPltStatus() {
		return pltStatus;
	}

	public void setPltStatus(String pltStatus) {
		this.pltStatus = pltStatus;
	}

	public String getRbcStatus() {
		return rbcStatus;
	}

	public void setRbcStatus(String rbcStatus) {
		this.rbcStatus = rbcStatus;
	}

	public String getWbcStatus() {
		return wbcStatus;
	}

	public void setWbcStatus(String wbcStatus) {
		this.wbcStatus = wbcStatus;
	}

	public String getUricStatus() {
		return uricStatus;
	}

	public void setUricStatus(String uricStatus) {
		this.uricStatus = uricStatus;
	}

	public Boolean getTplRec() {
		return tplRec;
	}

	public void setTplRec(Boolean tplRec) {
		this.tplRec = tplRec;
	}

	public Boolean getWbcRec() {
		return wbcRec;
	}

	public void setWbcRec(Boolean wbcRec) {
		this.wbcRec = wbcRec;
	}

	public Boolean getAgrRec() {
		return agrRec;
	}

	public void setAgrRec(Boolean agrRec) {
		this.agrRec = agrRec;
	}

	public Boolean getRbcRec() {
		return rbcRec;
	}

	public void setRbcRec(Boolean rbcRec) {
		this.rbcRec = rbcRec;
	}

	public Boolean getUricRec() {
		return uricRec;
	}

	public void setUricRec(Boolean uricRec) {
		this.uricRec = uricRec;
	}

	public Boolean getPltRec() {
		return pltRec;
	}

	public void setPltRec(Boolean pltRec) {
		this.pltRec = pltRec;
	}

	public String getShowPastTpl() {
		return showPastTpl;
	}

	public void setShowPastTpl(String showPastTpl) {
		this.showPastTpl = showPastTpl;
	}

	public String getShowPastAgr() {
		return showPastAgr;
	}

	public void setShowPastAgr(String showPastAgr) {
		this.showPastAgr = showPastAgr;
	}

	public String getShowPastRbc() {
		return showPastRbc;
	}

	public void setShowPastRbc(String showPastRbc) {
		this.showPastRbc = showPastRbc;
	}

	public String getShowPastPlt() {
		return showPastPlt;
	}

	public void setShowPastPlt(String showPastPlt) {
		this.showPastPlt = showPastPlt;
	}

	public String getShowPastUric() {
		return showPastUric;
	}

	public void setShowPastUric(String showPastUric) {
		this.showPastUric = showPastUric;
	}

	public String getShowCurrTpl() {
		return showCurrTpl;
	}

	public void setShowCurrTpl(String showCurrTpl) {
		this.showCurrTpl = showCurrTpl;
	}

	public String getShowCurrAgr() {
		return showCurrAgr;
	}

	public void setShowCurrAgr(String showCurrAgr) {
		this.showCurrAgr = showCurrAgr;
	}

	public String getShowCurrRbc() {
		return showCurrRbc;
	}

	public void setShowCurrRbc(String showCurrRbc) {
		this.showCurrRbc = showCurrRbc;
	}

	public String getShowCurrPlt() {
		return showCurrPlt;
	}

	public void setShowCurrPlt(String showCurrPlt) {
		this.showCurrPlt = showCurrPlt;
	}

	public String getShowCurrUric() {
		return showCurrUric;
	}

	public void setShowCurrUric(String showCurrUric) {
		this.showCurrUric = showCurrUric;
	}

	public Boolean getFinalFoodSts() {
		return finalFoodSts;
	}

	public void setFinalFoodSts(Boolean finalFoodSts) {
		this.finalFoodSts = finalFoodSts;
	}

	public Boolean getTplNormal() {
		return tplNormal;
	}

	public void setTplNormal(Boolean tplNormal) {
		this.tplNormal = tplNormal;
	}

	public Boolean getAgrNormal() {
		return agrNormal;
	}

	public void setAgrNormal(Boolean agrNormal) {
		this.agrNormal = agrNormal;
	}

	public Boolean getRbcNormal() {
		return rbcNormal;
	}

	public void setRbcNormal(Boolean rbcNormal) {
		this.rbcNormal = rbcNormal;
	}

	public Boolean getPltNormal() {
		return pltNormal;
	}

	public void setPltNormal(Boolean pltNormal) {
		this.pltNormal = pltNormal;
	}

	public Boolean getUricNormal() {
		return uricNormal;
	}

	public void setUricNormal(Boolean uricNormal) {
		this.uricNormal = uricNormal;
	}

	public Boolean getNormalRecommend() {
		return normalRecommend;
	}

	public void setNormalRecommend(Boolean normalRecommend) {
		this.normalRecommend = normalRecommend;
	}
	

}
