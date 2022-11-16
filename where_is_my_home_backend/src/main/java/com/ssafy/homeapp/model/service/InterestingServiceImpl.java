package com.ssafy.homeapp.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.homeapp.model.dao.InterestingDAO;
import com.ssafy.homeapp.model.dto.CommercialArea;
import com.ssafy.homeapp.model.dto.InterestingPlace;

@Service
public class InterestingServiceImpl implements InterestingService {

	@Autowired
	private InterestingDAO interestingDAO;

	@Override
	public boolean registerPlace(InterestingPlace interestingPlace) {
		return interestingDAO.registerPlace(interestingPlace) > 0;
	}

	@Override
	public boolean deletePlace(HashMap<String, String> map) {
		return interestingDAO.deletePlace(map) > 0;
	}
	
	@Override
	public List<CommercialArea> getCommercialArea(String dongName) {
		return interestingDAO.getCommercialArea(dongName);
	}
	
	@Override
	public List<InterestingPlace> getPlaces(String userid) {
		return interestingDAO.getPlaces(userid);
	}

	@Override
	public InterestingPlace getPlace(HashMap<String, String> map) {
		return interestingDAO.getPlace(map);
	}
}
