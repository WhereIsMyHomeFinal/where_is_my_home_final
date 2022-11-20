package com.ssafy.vue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.vue.model.LikeDealDto;
import com.ssafy.vue.model.service.LikeDealService;

@RequestMapping("/like-deals")
@RestController
public class LikeDealController {
	
	@Autowired
	private LikeDealService likeDealService;
	
	@GetMapping("/{user_idx}")
	private ResponseEntity<List<LikeDealDto>> getLikeDealsByUserIdx(@PathVariable int user_idx) {
		
		List<LikeDealDto> likeDeals = likeDealService.getLikeDealsByUserIdx(user_idx);
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
}
