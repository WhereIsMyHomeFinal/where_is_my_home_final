package com.ssafy.homeapp.model.dto;

public class Corona {

	String sidoName, gugunName, name, address, telno;

	public Corona(String sidoName, String gugunName, String name, String address, String telno) {
		super();
		this.sidoName = sidoName;
		this.gugunName = gugunName;
		this.name = name;
		this.address = address;
		this.telno = telno;
	}

	public String getSidoName() {
		return sidoName;
	}

	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}

	public String getGugunName() {
		return gugunName;
	}

	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}
}
