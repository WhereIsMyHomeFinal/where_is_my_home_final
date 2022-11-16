package com.ssafy.homeapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.homeapp.model.dao.QnADAO;
import com.ssafy.homeapp.model.dto.BoardParameterDto;
import com.ssafy.homeapp.model.dto.QnADto;
import com.ssafy.util.PageNavigation;

@Service
public class QnAServiceImpl implements QnAService {
	
	@Autowired
	private QnADAO qnaDAO;
	
	@Override
	public boolean writeArticle(QnADto qnaDto) {
		return qnaDAO.writeArticle(qnaDto) > 0;
	}
	
	@Override
	public List<QnADto> listArticle(BoardParameterDto boardParameterDto) {
		return qnaDAO.listArticle(boardParameterDto);
	}

	@Override
	@Transactional
	public boolean modifyArticle(QnADto qnaDto) {
		return qnaDAO.modifyArticle(qnaDto) > 0;
	}

	@Override
	@Transactional
	public boolean deleteArticle(int articleno) {
		return qnaDAO.deleteArticle(articleno) > 0;
	}

	@Override
	public QnADto getArticle(int articleno) {
		return qnaDAO.getArticle(articleno);
	}
	
	@Override
	public PageNavigation makePageNavigation(BoardParameterDto boardParameterDto) {
		int naviSize = 5;
		PageNavigation pageNavigation = new PageNavigation();
		pageNavigation.setCurrentPage(boardParameterDto.getPg());
		pageNavigation.setNaviSize(naviSize);
		int totalCount = qnaDAO.getTotalCount(boardParameterDto); //총글갯수  269
		pageNavigation.setTotalCount(totalCount);  
		int totalPageCount = (totalCount - 1) / boardParameterDto.getSpp() + 1; //27
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = boardParameterDto.getPg() <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < boardParameterDto.getPg();
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();
		return pageNavigation;
	}
	
	@Override
	public void updateHit(int articleno){
		qnaDAO.updateHit(articleno);
	}

}