package com.ssafy.homeapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.homeapp.model.dao.NoticeDAO;
import com.ssafy.homeapp.model.dto.Notice;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Override
	public List<Notice> getNotices(){
		return noticeDAO.getNotices();
	}
	
	@Override
	public Notice getNotice(int id) {
		return noticeDAO.getNotice(id);
	}
	
	@Override
	public boolean registerNotice(Notice notice) {
		return noticeDAO.registerNotice(notice) > 0;
	}
	
	@Override
	public boolean modifyNotice(Notice notice) {
		return noticeDAO.modifyNotice(notice) > 0;
	}
	
	@Override
	public boolean deleteNotice(int id) {
		return noticeDAO.deleteNotice(id) > 0;
	}
}
