package com.ssafy.vue.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.vue.model.HouseDeal;
import com.ssafy.vue.model.SidoGugunCodeDto;

public interface HouseDealService {

	HouseDeal getHouseDeal(int no);

	List<HouseDeal> getHouseDeals(Map<String, Object> conditions);
	
	public List<SidoGugunCodeDto> getSido();

	public List<SidoGugunCodeDto> getGugunInSido(String sido);
	
	public List<HouseDeal> getDongInGugun(String gugun);
	
}