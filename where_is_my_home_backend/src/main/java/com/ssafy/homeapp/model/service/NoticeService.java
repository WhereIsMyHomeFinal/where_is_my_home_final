package com.ssafy.homeapp.model.service;

import java.util.List;

import com.ssafy.homeapp.model.dto.Notice;

public interface NoticeService {

	List<Notice> getNotices();

	Notice getNotice(int id);

	boolean registerNotice(Notice notice);

	boolean modifyNotice(Notice notice);

	boolean deleteNotice(int id);

}