package com.ssafy.homeapp.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.homeapp.model.dto.HouseDeal;
import com.ssafy.homeapp.model.dto.SidoGugunCodeDto;

@Mapper
public interface HouseDealDAO {

	List<HouseDeal> selectHouseDeals(Map<String, Object> conditions);

	HouseDeal selectHouseDeal(int no);
	
	List<SidoGugunCodeDto> getSido();
	
	List<SidoGugunCodeDto> getGugunInSido(String sido);
	
	List<HouseDeal> getDongInGugun(String gugun);
	
}