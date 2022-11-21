package com.ssafy.vue.controller;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.vue.model.LikeDealDto;
import com.ssafy.vue.model.RegisterLikeDealParameterDto;
import com.ssafy.vue.model.service.LikeDealService;

@RequestMapping("/like-deals")
@RestController
public class LikeDealController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private LikeDealService likeDealService;
	
	@GetMapping("/{userIdx}")
	private ResponseEntity<List<LikeDealDto>> getLikeDealsByUserIdx(@PathVariable int userIdx) {
		
		List<LikeDealDto> likeDeals = likeDealService.getLikeDealsByUserIdx(userIdx);
		System.out.println(likeDeals);
		if(likeDeals != null) {
			if(likeDeals.size() == 0) {
				return ResponseEntity.noContent().build();
			} else {
				return ResponseEntity.ok(likeDeals);
			}
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@PostMapping("/{userIdx}/{dealIdx}")
	private ResponseEntity<?> registerLikeDeal(@PathVariable("userIdx") int userIdx, @PathVariable("dealIdx") int dealIdx) {
		logger.info("registerLikeDeal - 호출");
		if (likeDealService.registerLikeDeal(new RegisterLikeDealParameterDto(userIdx, dealIdx))) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}
