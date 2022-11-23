package com.ssafy.vue.model;

public class HouseDealDto {
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
	private boolean isLiked;
	private float avgRecommend, avgTraffic, avgLiving, avgSurround;
	
//	public HouseDeal(int no, int aptCode, String aptName, String dealAmount, String area, String dongName, String floor, int buildYear,
//			String lat, String lng) {
//		super();
//		this.no = no;
//		this.aptCode = aptCode;
//		this.aptName = aptName;
//		this.dealAmount = dealAmount;
//		this.area = area;
//		this.dongName = dongName;
//		this.floor = floor;
//		this.buildYear = buildYear;
//		this.lat = lat;
//		this.lng = lng;
//	}
	
	public boolean isLiked() {
		return isLiked;
	}

	public float getAvgRecommend() {
		return avgRecommend;
	}

	public void setAvgRecommend(float avgRecommend) {
		this.avgRecommend = avgRecommend;
	}

	public float getAvgTraffic() {
		return avgTraffic;
	}

	public void setAvgTraffic(float avgTraffic) {
		this.avgTraffic = avgTraffic;
	}

	public float getAvgLiving() {
		return avgLiving;
	}

	public void setAvgLiving(float avgLiving) {
		this.avgLiving = avgLiving;
	}

	public float getAvgSurround() {
		return avgSurround;
	}

	public void setAvgSurround(float avgSurround) {
		this.avgSurround = avgSurround;
	}

	public void setLiked(boolean isLiked) {
		this.isLiked = isLiked;
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
