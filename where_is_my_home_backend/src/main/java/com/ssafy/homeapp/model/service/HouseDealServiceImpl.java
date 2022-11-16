package com.ssafy.homeapp.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.homeapp.model.dao.HouseDealDAO;
import com.ssafy.homeapp.model.dto.HouseDeal;

@Service
public class HouseDealServiceImpl implements HouseDealService {

	private HouseDealDAO houseDealDAO;
	
	@Autowired
	public HouseDealServiceImpl(HouseDealDAO houseDealDao) {
		super();
		this.houseDealDAO = houseDealDao;
	}
	
	@Override
	public HouseDeal getHouseDeal(int no) throws Exception {
		return houseDealDAO.selectHouseDeal(no);
	}

	@Override
	public List<HouseDeal> getHouseDeals(Map<String, Object> conditions) throws Exception {
		return houseDealDAO.selectHouseDeals(conditions);
	}
}
