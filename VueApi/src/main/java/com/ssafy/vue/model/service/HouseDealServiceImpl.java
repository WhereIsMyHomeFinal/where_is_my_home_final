package com.ssafy.vue.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vue.model.HouseDealDto;
import com.ssafy.vue.model.SidoGugunCodeDto;
import com.ssafy.vue.model.mapper.HouseDealMapper;

@Service
public class HouseDealServiceImpl implements HouseDealService {

	private HouseDealMapper houseDealDAO;
	
	@Autowired
	public HouseDealServiceImpl(HouseDealMapper houseDealDao) {
		this.houseDealDAO = houseDealDao;
	}
	
	@Override
	public HouseDealDto getHouseDeal(int no) {
		return houseDealDAO.selectHouseDeal(no);
	}

	@Override
	public List<HouseDealDto> getHouseDeals(Map<String, Object> conditions) {
		return houseDealDAO.selectHouseDeals(conditions);
	}

	@Override
	public List<SidoGugunCodeDto> getSido() {
		return houseDealDAO.getSido();
	}

	@Override
	public List<SidoGugunCodeDto> getGugunInSido(String sido) {
		return houseDealDAO.getGugunInSido(sido);
	}

	@Override
	public List<HouseDealDto> getDongInGugun(String gugun) {
		return houseDealDAO.getDongInGugun(gugun);
	}
}
