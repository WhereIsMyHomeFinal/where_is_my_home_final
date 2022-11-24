package com.ssafy.vue.model.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.model.HouseDealDto;
import com.ssafy.vue.model.SidoGugunCodeDto;

@Mapper
public interface HouseDealMapper {

	List<HouseDealDto> selectHouseDeals(Map<String, Object> conditions);

	HouseDealDto selectHouseDeal(HashMap<String, Integer> map);
	
	List<SidoGugunCodeDto> getSido();
	
	List<SidoGugunCodeDto> getGugunInSido(String sido);
	
	List<HouseDealDto> getDongInGugun(String gugun);

}