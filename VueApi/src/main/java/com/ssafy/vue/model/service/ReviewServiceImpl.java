package com.ssafy.vue.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vue.model.ReviewDto;
import com.ssafy.vue.model.mapper.ReviewMapper;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	private ReviewMapper reviewMapper;
	
	@Autowired
	public ReviewServiceImpl(ReviewMapper reviewMapper) {
		this.reviewMapper = reviewMapper;
	}

	@Override
	public List<ReviewDto> getReviews(int dealIdx) {
		return reviewMapper.getReviews(dealIdx);
	}

	@Override
	public boolean registerReview(ReviewDto review) {
		return reviewMapper.registerReview(review) > 0;
	}

	@Override
	public boolean deleteReview(int reviewIdx) {
		return reviewMapper.deleteReview(reviewIdx) > 0;
	}

}
