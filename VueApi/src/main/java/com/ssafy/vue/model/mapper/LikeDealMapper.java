package com.ssafy.vue.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.model.LikeDealDto;

@Mapper
public interface LikeDealMapper {
	
	public List<LikeDealDto> getLikeDealsByUserIdx(int user_idx);
//	public int registerLikeDeal(LikeDealDto likeDealDto);
}
