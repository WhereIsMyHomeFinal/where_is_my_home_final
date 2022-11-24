package com.ssafy.vue.model;

public class RegisterLikeDealParameterDto {
	
	private int userIdx;
	private int dealIdx;
	
	public RegisterLikeDealParameterDto(int userIdx, int dealIdx) {
		super();
		this.userIdx = userIdx;
		this.dealIdx = dealIdx;
	}
	
	public int getUserIdx() {
		return userIdx;
	}
	
	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}

	public int getDealIdx() {
		return dealIdx;
	}
	
	public void setDealIdx(int dealIdx) {
		this.dealIdx = dealIdx;
	}

}
