package com.kec.project.model;

import java.io.Serializable;

public class Record  implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
String  prevTpl,prevAgr,prevRbc,prevPlt,prevUric;
String cmpTpl,cmpAgr,cmpRbc,cmpPlt,cmpUric;

public String getPrevTpl() {
	return prevTpl;
}

public void setPrevTpl(String prevTpl) {
	this.prevTpl = prevTpl;
}

public String getPrevAgr() {
	return prevAgr;
}

public void setPrevAgr(String prevAgr) {
	this.prevAgr = prevAgr;
}

public String getPrevRbc() {
	return prevRbc;
}

public void setPrevRbc(String prevRbc) {
	this.prevRbc = prevRbc;
}

public String getPrevPlt() {
	return prevPlt;
}

public void setPrevPlt(String prevPlt) {
	this.prevPlt = prevPlt;
}

public String getPrevUric() {
	return prevUric;
}

public void setPrevUric(String prevUric) {
	this.prevUric = prevUric;
}

public String getCmpTpl() {
	return cmpTpl;
}

public void setCmpTpl(String cmpTpl) {
	this.cmpTpl = cmpTpl;
}

public String getCmpAgr() {
	return cmpAgr;
}

public void setCmpAgr(String cmpAgr) {
	this.cmpAgr = cmpAgr;
}

public String getCmpRbc() {
	return cmpRbc;
}

public void setCmpRbc(String cmpRbc) {
	this.cmpRbc = cmpRbc;
}

public String getCmpPlt() {
	return cmpPlt;
}

public void setCmpPlt(String cmpPlt) {
	this.cmpPlt = cmpPlt;
}

public String getCmpUric() {
	return cmpUric;
}

public void setCmpUric(String cmpUric) {
	this.cmpUric = cmpUric;
}

}
