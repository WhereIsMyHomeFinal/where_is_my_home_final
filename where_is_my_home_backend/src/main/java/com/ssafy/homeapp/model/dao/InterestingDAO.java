package com.ssafy.homeapp.model.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.homeapp.model.dto.CommercialArea;
import com.ssafy.homeapp.model.dto.InterestingPlace;

@Mapper
public interface InterestingDAO {

	List<InterestingPlace> getPlaces(String userid);

	InterestingPlace getPlace(HashMap<String, String> map);

	int registerPlace(InterestingPlace interestingPlace);

	int deletePlace(HashMap<String, String> map);

	List<CommercialArea> getCommercialArea(String dongName);

}