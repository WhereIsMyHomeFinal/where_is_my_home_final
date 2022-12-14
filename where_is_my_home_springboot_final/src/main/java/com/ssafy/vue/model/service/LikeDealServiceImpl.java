package com.ssafy.vue.model.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vue.model.LikeDealDto;
import com.ssafy.vue.model.RegisterLikeDealParameterDto;
import com.ssafy.vue.model.mapper.LikeDealMapper;

@Service
public class LikeDealServiceImpl implements LikeDealService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<LikeDealDto> getLikeDealsByUserIdx(int userIdx) {
		return sqlSession.getMapper(LikeDealMapper.class).getLikeDealsByUserIdx(userIdx);
	}

	@Override
	public boolean registerLikeDeal(RegisterLikeDealParameterDto registerLikeDealParameterDto) {
		return sqlSession.getMapper(LikeDealMapper.class).insertLikeDeal(registerLikeDealParameterDto) > 0;
	}

	@Override
	public boolean deleteLikeDeal(HashMap<String, Integer> map) {
		return sqlSession.getMapper(LikeDealMapper.class).deleteLikeDeal(map) > 0;
	}
}
