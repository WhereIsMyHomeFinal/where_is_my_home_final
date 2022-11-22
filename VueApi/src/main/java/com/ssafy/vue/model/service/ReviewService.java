package com.ssafy.vue.model.service;

import java.util.List;

import com.ssafy.vue.model.ReviewDto;

public interface ReviewService {

	public List<ReviewDto> getReviews(int aptCode);
	public boolean registerReview(ReviewDto review);
	public boolean deleteReview(int reviewIdx);
	
}
