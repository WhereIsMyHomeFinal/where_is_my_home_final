package com.ssafy.vue.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.model.HouseDeal;
import com.ssafy.vue.model.SidoGugunCodeDto;

@Mapper
public interface HouseDealDAO {

	List<HouseDeal> selectHouseDeals(Map<String, Object> conditions);

	HouseDeal selectHouseDeal(int no);
	
	List<SidoGugunCodeDto> getSido();
	
	List<SidoGugunCodeDto> getGugunInSido(String sido);
	
	List<HouseDeal> getDongInGugun(String gugun);
	
}