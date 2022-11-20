package com.ssafy.vue.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.model.ReviewDto;

@Mapper
public interface ReviewMapper {

	public List<ReviewDto> getReviews(int dealIdx);
	public int registerReview(ReviewDto review);
	public int deleteReview(int reviewIdx);
	
}
