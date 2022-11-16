package com.ssafy.homeapp.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.homeapp.model.dto.Notice;
import com.ssafy.homeapp.model.service.NoticeService;

@RestController
@RequestMapping("/notices")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@DeleteMapping("/{id}")
	private ResponseEntity<?> deleteNotice(@PathVariable int id, @RequestBody String userid) {
		Notice notice = noticeService.getNotice(id);
		if (notice == null || !notice.getUserid().equals("admin")) {
			return ResponseEntity.notFound().build();
		} else {
			boolean result = noticeService.deleteNotice(id);
			if (result)	return ResponseEntity.noContent().build();
			else	return ResponseEntity.internalServerError().build();
		}
	}

	@PutMapping("/{id}")
	private ResponseEntity<?> modifyNotice(@RequestBody Notice notice) {
		Notice target = noticeService.getNotice(notice.getId());
		if (target == null || !notice.getUserid().equals("admin")) {
			return ResponseEntity.notFound().build();
		} else {
			boolean result = noticeService.modifyNotice(notice);
			if (result)	return ResponseEntity.ok(notice);
			else	return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping
	private ResponseEntity<?> registerNotice(@RequestBody Notice notice) {
		boolean result = noticeService.registerNotice(notice);
		if (!result || !notice.getUserid().equals("admin"))	return ResponseEntity.internalServerError().build();	
		else	return ResponseEntity.ok(URI.create("/notice/" + notice.getTitle()));
	}

	@GetMapping("/{id}")
	private ResponseEntity<Notice> detailNotice(@PathVariable int id) {
		Notice notice = noticeService.getNotice(id);
		if (notice != null)	return ResponseEntity.ok(notice);
		else	return ResponseEntity.notFound().build();
	}

	@GetMapping
	private ResponseEntity<List<Notice>> listNotice() {
//		List<Notice> list = noticeService.getNotices();
//		if (list.size() > 0)	return ResponseEntity.ok(list);
//		else	return ResponseEntity.noContent().build();
		return ResponseEntity.ok(noticeService.getNotices());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e) {
		return ResponseEntity.internalServerError()
				.header("content-type", "text/plain;charset=utf-8")
				.body("처리 중 문제가 발생하였습니다.");
	}
}
