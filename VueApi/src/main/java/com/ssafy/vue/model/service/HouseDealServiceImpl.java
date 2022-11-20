package com.ssafy.vue.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vue.model.HouseDeal;
import com.ssafy.vue.model.SidoGugunCodeDto;
import com.ssafy.vue.model.mapper.HouseDealDAO;

@Service
public class HouseDealServiceImpl implements HouseDealService {

	private HouseDealDAO houseDealDAO;
	
	@Autowired
	public HouseDealServiceImpl(HouseDealDAO houseDealDao) {
		this.houseDealDAO = houseDealDao;
	}
	
	@Override
	public HouseDeal getHouseDeal(int no) {
		return houseDealDAO.selectHouseDeal(no);
	}

	@Override
	public List<HouseDeal> getHouseDeals(Map<String, Object> conditions) {
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
	public List<HouseDeal> getDongInGugun(String gugun) {
		return houseDealDAO.getDongInGugun(gugun);
	}
}
