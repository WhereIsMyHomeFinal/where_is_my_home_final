package com.ssafy.homeapp.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.homeapp.model.dto.Notice;

@Mapper
public interface NoticeDAO {

	List<Notice> getNotices();

	Notice getNotice(int id);

	int registerNotice(Notice notice);

	int modifyNotice(Notice notice);

	int deleteNotice(int id);

}