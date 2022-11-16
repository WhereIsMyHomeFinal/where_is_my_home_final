package com.ssafy.homeapp.model.service;

import java.util.HashMap;
import java.util.List;

import com.ssafy.homeapp.model.dto.CommercialArea;
import com.ssafy.homeapp.model.dto.InterestingPlace;

public interface InterestingService {

	boolean registerPlace(InterestingPlace interestingPlace);

	boolean deletePlace(HashMap<String, String> map);

	List<InterestingPlace> getPlaces(String userid);

	InterestingPlace getPlace(HashMap<String, String> map);

	List<CommercialArea> getCommercialArea(String dongName);

}