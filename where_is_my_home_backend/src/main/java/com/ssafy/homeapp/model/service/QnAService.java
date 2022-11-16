package com.ssafy.homeapp.model.service;

import java.util.List;

import com.ssafy.homeapp.model.dto.BoardParameterDto;
import com.ssafy.homeapp.model.dto.QnADto;
import com.ssafy.util.PageNavigation;

public interface QnAService {
	
	public boolean writeArticle(QnADto QnADto);
	public List<QnADto> listArticle(BoardParameterDto boardParameterDto);
	public QnADto getArticle(int articleno);
	public boolean modifyArticle(QnADto QnADto);
	public boolean deleteArticle(int articleno);
	
	public PageNavigation makePageNavigation(BoardParameterDto boardParameterDto);
	public void updateHit(int articleno);
}
