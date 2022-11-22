package com.ssafy.vue.model.service;

import java.util.HashMap;
import java.util.List;

import com.ssafy.vue.model.LikeDealDto;
import com.ssafy.vue.model.RegisterLikeDealParameterDto;

public interface LikeDealService {
	public List<LikeDealDto> getLikeDealsByUserIdx(int userIdx);
	public boolean registerLikeDeal(RegisterLikeDealParameterDto registerLikeDealParameterDto);
	public boolean deleteLikeDeal(HashMap<String, Integer> map);
}
