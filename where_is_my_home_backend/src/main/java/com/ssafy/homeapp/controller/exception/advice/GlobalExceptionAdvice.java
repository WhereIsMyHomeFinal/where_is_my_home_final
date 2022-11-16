package com.ssafy.homeapp.controller.exception.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e) {
		log.error("exception 발생 : "+e.getMessage(), e);
		
		return ResponseEntity.internalServerError()
				.header("content-type", "text/plain;charset=utf-8")
				.body("처리 중 문제가 발생하였습니다. : "+e.getMessage());
	}
}
