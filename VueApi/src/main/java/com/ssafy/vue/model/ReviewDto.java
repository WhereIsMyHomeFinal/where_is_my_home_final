package com.ssafy.vue.model;

public class ReviewDto {

	private int reviewIdx, dealIdx, userIdx;
	private int recommendScore, surroundScore, trafficScore, livingScore;
	private String comment, userName, registDate;
	
	public int getReviewIdx() {
		return reviewIdx;
	}
	public void setReviewIdx(int reviewIdx) {
		this.reviewIdx = reviewIdx;
	}
	public int getDealIdx() {
		return dealIdx;
	}
	public void setDealIdx(int dealIdx) {
		this.dealIdx = dealIdx;
	}
	public int getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}
	public int getRecommendScore() {
		return recommendScore;
	}
	public void setRecommendScore(int recommendScore) {
		this.recommendScore = recommendScore;
	}
	public int getSurroundScore() {
		return surroundScore;
	}
	public void setSurroundScore(int surroundScore) {
		this.surroundScore = surroundScore;
	}
	public int getTrafficScore() {
		return trafficScore;
	}
	public void setTrafficScore(int trafficScore) {
		this.trafficScore = trafficScore;
	}
	public int getLivingScore() {
		return livingScore;
	}
	public void setLivingScore(int livingScore) {
		this.livingScore = livingScore;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRegistDate() {
		return registDate;
	}
	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}
}
