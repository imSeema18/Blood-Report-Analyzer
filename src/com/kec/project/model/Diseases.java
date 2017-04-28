package com.kec.project.model;

import java.io.Serializable;

public class Diseases implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
String tplDisease,agrDisease, rbcDisease, wbcDisease, pltDisease;

public String getTplDisease() {
	return tplDisease;
}

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
}
