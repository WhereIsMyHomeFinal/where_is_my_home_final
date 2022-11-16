package com.ssafy.homeapp.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.homeapp.model.dto.HouseDeal;

public interface HouseDealService {

	HouseDeal getHouseDeal(int no) throws Exception;

	List<HouseDeal> getHouseDeals(Map<String, Object> conditions) throws Exception;

}