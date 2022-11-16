package com.ssafy.homeapp.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.homeapp.model.dto.HouseDeal;

@Mapper
public interface HouseDealDAO {

	List<HouseDeal> selectHouseDeals(Map<String, Object> conditions) throws SQLException;

	HouseDeal selectHouseDeal(int no) throws SQLException;
}