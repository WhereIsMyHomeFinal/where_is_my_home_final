package com.ssafy.vue.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.vue.model.HouseDealDto;
import com.ssafy.vue.model.SidoGugunCodeDto;
import com.ssafy.vue.model.service.HouseDealService;

@RequestMapping("/house-deals")
@RestController
public class HouseDealController {
	
	@Autowired
	private HouseDealService houseService;
	
	@GetMapping	// 둘 다 선택 안하면 그냥 전체 데이터에서 dealAmount가 큰 순으로 9개 가져옴 -> 사용자에게 유도하도록 추후 수정?
	private ResponseEntity<List<HouseDealDto>> getHouseDeals(@RequestParam(required = false) String aptName, @RequestParam(required = false) String dongName) {
		
		HashMap<String, Object> conditions = new HashMap<String, Object>();
		if(aptName != null) conditions.put("aptName", aptName);
		if(dongName != null) conditions.put("dongName", dongName);
		List<HouseDealDto> houseDeals = houseService.getHouseDeals(conditions);
		if(houseDeals != null) {
			if(houseDeals.size() == 0) {
				return ResponseEntity.noContent().build();
			} else {
				return ResponseEntity.ok(houseDeals);
			}
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}

	@GetMapping("/{no}")
	private ResponseEntity<HouseDealDto> getHouse(@PathVariable int no) {
		HouseDealDto houseDeal = houseService.getHouseDeal(no);
		if(houseDeal != null) {
			return ResponseEntity.ok(houseDeal);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/sido")
	private ResponseEntity<List<SidoGugunCodeDto>> getSido() {
		return new ResponseEntity<List<SidoGugunCodeDto>>(houseService.getSido(), HttpStatus.OK);
	}
	
	@GetMapping("/{sido}/gugun")
	private ResponseEntity<List<SidoGugunCodeDto>> getGugunInSido(@PathVariable String sido) {
		return new ResponseEntity<List<SidoGugunCodeDto>>(houseService.getGugunInSido(sido), HttpStatus.OK);
	}
	
	@GetMapping("/{gugun}/dong")
	private ResponseEntity<List<HouseDealDto>> getDongInGugun(@PathVariable String gugun) {
		return new ResponseEntity<List<HouseDealDto>>(houseService.getDongInGugun(gugun), HttpStatus.OK);
	}
}
