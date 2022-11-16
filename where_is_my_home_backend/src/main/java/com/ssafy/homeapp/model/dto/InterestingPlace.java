package com.ssafy.homeapp.model.dto;

public class InterestingPlace {

	String userid, dongName, sidoName, gugunName, lat, lng;

	public InterestingPlace(String userid, String dongName, String sidoName, String gugunName, String lat, String lng) {
		super();
		this.userid = userid;
		this.dongName = dongName;
		this.sidoName = sidoName;
		this.gugunName = gugunName;
		this.lat = lat;
		this.lng = lng;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getDongName() {
		return dongName;
	}

	public void setDongName(String dongName) {
		this.dongName = dongName;
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
		return "InterestingPlace [userid=" + userid + ", dongName=" + dongName + ", sidoName=" + sidoName
				+ ", gugunName=" + gugunName + ", lat=" + lat + ", lng=" + lng + "]";
	}
}
