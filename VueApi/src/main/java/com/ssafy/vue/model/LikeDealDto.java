package com.ssafy.vue.model;

public class LikeDealDto {
//	private int likedeal_idx;
	private int dealIdx;
	private int userIdx;
	private int aptCode;
	private String aptName;
	private String dealAmount;
	private String area;
	private String dongName;
	private String floor;
	private int buildYear;
	private String imgUrl;
	
//	public int getLikedeal_idx() {
//		return likedeal_idx;
//	}
//	
//	public void setLikedeal_idx(int likedeal_idx) {
//		this.likedeal_idx = likedeal_idx;
//	}
	
	public int getDeal_idx() {
		return dealIdx;
	}
	
	public void setDeal_idx(int deal_idx) {
		this.dealIdx = deal_idx;
	}
	
	public int getUser_idx() {
		return userIdx;
	}
	
	public void setUser_idx(int user_idx) {
		this.userIdx = user_idx;
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

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Override
	public String toString() {
		return "LikeDealDto [deal_idx=" + dealIdx + ", user_idx=" + userIdx + ", aptCode=" + aptCode + ", aptName="
				+ aptName + ", dealAmount=" + dealAmount + ", area=" + area + ", dongName=" + dongName + ", floor="
				+ floor + ", buildYear=" + buildYear + ", imgUrl=" + imgUrl + "]";
	}
	
}
