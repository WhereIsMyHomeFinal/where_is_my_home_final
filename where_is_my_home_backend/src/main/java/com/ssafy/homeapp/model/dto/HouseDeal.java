package com.ssafy.homeapp.model.dto;

public class HouseDeal {
	private int no;
	private int aptCode;
	private String aptName;
	private String dealAmount;
	private String area;
	private String dongName;
	private String floor;
	private int buildYear;
	private String lat;
	private String lng;
	
	public HouseDeal(int no, int aptCode, String aptName, String dealAmount, String area, String dongName, String floor, int buildYear,
			String lat, String lng) {
		super();
		this.no = no;
		this.aptCode = aptCode;
		this.aptName = aptName;
		this.dealAmount = dealAmount;
		this.area = area;
		this.dongName = dongName;
		this.floor = floor;
		this.buildYear = buildYear;
		this.lat = lat;
		this.lng = lng;
	}
	
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public int getAptCode() {
		return aptCode;
	}
	
	public void setAptCode(int aptCode) {
		this.aptCode = aptCode;
	}
	
	public String getAptName() {
		return aptName;
	}

	public void setAptName(String aptName) {
		this.aptName = aptName;
	}

	public String getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDongName() {
		return dongName;
	}

	public void setDongName(String dongName) {
		this.dongName = dongName;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public int getBuildYear() {
		return buildYear;
	}

	public void setBuildYear(int buildYear) {
		this.buildYear = buildYear;
	}
	
	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	@Override
	public String toString() {
		return "House [no=" + no + ", aptName=" + aptName + ", dealAmount=" + dealAmount + ", area=" + area
				+ ", dongName=" + dongName + ", floor=" + floor + ", buildYear=" + buildYear + ", lat=" + lat + ", lng="
				+ lng + ", aptCode=" + aptCode + "]";
	}
	
}
