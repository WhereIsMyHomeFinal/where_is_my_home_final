package com.ssafy.vue.model.service;

import java.util.List;

import com.ssafy.vue.model.LikeDealDto;

public interface LikeDealService {
	public List<LikeDealDto> getLikeDealsByUserIdx(int user_idx);
}
