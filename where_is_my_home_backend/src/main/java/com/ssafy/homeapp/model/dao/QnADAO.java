package com.ssafy.homeapp.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.homeapp.model.dto.BoardParameterDto;
import com.ssafy.homeapp.model.dto.QnADto;

@Mapper
public interface QnADAO {
	
	public int writeArticle(QnADto QnADto);
	public List<QnADto> listArticle(BoardParameterDto boardParameterDto);
	public QnADto getArticle(int articleno);
	public int modifyArticle(QnADto QnADto);
	public int deleteArticle(int articleno);
	public int getTotalCount(BoardParameterDto boardParameterDto);
	public void updateHit(int articleno);
	public void deleteMemo(int articleno);
}