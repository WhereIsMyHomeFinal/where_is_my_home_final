package com.ssafy.vue.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vue.model.LikeDealDto;
import com.ssafy.vue.model.mapper.LikeDealMapper;

@Service
public class LikeDealServiceImpl implements LikeDealService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<LikeDealDto> getLikeDealsByUserIdx(int user_idx) {
		return sqlSession.getMapper(LikeDealMapper.class).getLikeDealsByUserIdx(user_idx);
	}

}
