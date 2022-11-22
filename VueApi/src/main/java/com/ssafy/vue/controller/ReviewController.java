package com.ssafy.vue.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.vue.model.ReviewDto;
import com.ssafy.vue.model.service.ReviewService;

@RequestMapping("/reviews")
@RestController
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	@GetMapping("/{aptCode}")
	private ResponseEntity<List<ReviewDto>> getReviews(@PathVariable int aptCode) {
		List<ReviewDto> reviews = reviewService.getReviews(aptCode);
		System.out.println("length : " + reviews.size());
		return ResponseEntity.ok(reviews);
	}
	
	@PostMapping
	private ResponseEntity<?> registerReview(@RequestBody ReviewDto review) {
		boolean result = reviewService.registerReview(review);
		if (result)	return ResponseEntity.created(URI.create("/reviews/" + review.getDealIdx())).build();
		else	return ResponseEntity.internalServerError().build();
	}
	
	@DeleteMapping
	private ResponseEntity<?> deleteReview(@RequestParam int reviewIdx) {
		boolean result = reviewService.deleteReview(reviewIdx);
		if(result)	return ResponseEntity.noContent().build();
		else	return ResponseEntity.internalServerError().build();
	}
}
