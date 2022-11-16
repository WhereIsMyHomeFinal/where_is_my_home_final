package com.ssafy.homeapp.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.homeapp.model.dto.CommercialArea;
import com.ssafy.homeapp.model.dto.InterestingPlace;
import com.ssafy.homeapp.model.service.InterestingService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/interesting-places")
public class InterestingController {

	@Autowired
	private InterestingService interestingService;
//	
	@DeleteMapping("/{userid}/{dongName}")
	private ResponseEntity<?> interestingPlaceDelete(@PathVariable String userid, @PathVariable String dongName) throws Exception {
		HashMap<String, String> map = new HashMap<>();
		map.put("userid", userid);
		map.put("dongName", dongName);
		InterestingPlace ip = interestingService.getPlace(map);
		if (ip != null) {
			boolean result = interestingService.deletePlace(map);
			if (result)	return ResponseEntity.noContent().build();
			else	return ResponseEntity.internalServerError().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/{userid}")
	private ResponseEntity<?> interestingPlaceRegister(@PathVariable String userid, @RequestBody InterestingPlace ip) throws Exception {
		boolean result = interestingService.registerPlace(ip);
		if (result)	return ResponseEntity.created(URI.create("/interesting-places/" + ip.getUserid())).build();
		else	return ResponseEntity.internalServerError().build();
	}

	@GetMapping("/ca/{userid}/{dongName}/commercial-area")
	private ResponseEntity<List<CommercialArea>> commercialAreaList(@PathVariable String userid, @PathVariable String dongName) throws Exception {
		return ResponseEntity.ok(interestingService.getCommercialArea(dongName));
	}
	
	@GetMapping("/{userid}")
	private ResponseEntity<List<InterestingPlace>> interestingPlaceList(@PathVariable String userid) throws Exception {
		log.info("interestingPlaceList :{}",userid);
		List<InterestingPlace> list = interestingService.getPlaces(userid);
		if (list.size() > 0) {
			return ResponseEntity.ok(list);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@GetMapping("/{userid}/{dongName}")
	private ResponseEntity<InterestingPlace> interestingPlaceDetail(@PathVariable String userid, @PathVariable String dongName) throws Exception {
		HashMap<String, String> map = new HashMap<>();
		map.put("userid", userid);
		map.put("dongName", dongName);
		InterestingPlace ip = interestingService.getPlace(map);
		if (ip != null)	return ResponseEntity.ok(ip);
		else	return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e) {
		return ResponseEntity.internalServerError()
				.header("content-type", "text/plain;charset=utf-8")
				.body("처리 중 문제가 발생하였습니다.");
	}
}
