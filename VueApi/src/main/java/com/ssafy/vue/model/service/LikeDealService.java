package com.ssafy.vue.model.service;

import java.util.List;

import com.ssafy.vue.model.LikeDealDto;
import com.ssafy.vue.model.RegisterLikeDealParameterDto;

public interface LikeDealService {
	public List<LikeDealDto> getLikeDealsByUserIdx(int userIdx);
	public boolean registerLikeDeal(RegisterLikeDealParameterDto registerLikeDealParameterDto);
}
