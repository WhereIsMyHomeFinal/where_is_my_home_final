package com.ssafy.vue.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.vue.model.HouseDealDto;
import com.ssafy.vue.model.SidoGugunCodeDto;

public interface HouseDealService {

	HouseDealDto getHouseDeal(HashMap<String, Integer> map);

	List<HouseDealDto> getHouseDeals(Map<String, Object> conditions);
	
	public List<SidoGugunCodeDto> getSido();

	public List<SidoGugunCodeDto> getGugunInSido(String sido);
	
	public List<HouseDealDto> getDongInGugun(String gugun);
}