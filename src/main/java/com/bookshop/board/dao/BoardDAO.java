package com.bookshop.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.bookshop.board.vo.ArticleVO;

public interface BoardDAO {
	/** 게시물 목록 list로 가져오기 **/
	public List selectAllArticlesList(Map<String, Integer> pagingMap) throws DataAccessException;

	/** 새 글의 데이터 추가하기 **/
	public int insertNewArticle(Map articleMap) throws DataAccessException;

	/** 새 글의 첨부파일 데이터 추가하기 **/
	public void insertNewImage(Map articleMap) throws DataAccessException;

	/** 해당 게시물의 데이터 가져오기 **/
	public ArticleVO selectArticle(int articleNO) throws DataAccessException;

	/** 해당 게시물 수정하기 **/
	public void updateArticle(Map articleMap) throws DataAccessException;
	
	/** 해당 게시물 첨부파일 삭제하기 **/
	public void deleteImage(List<Integer> delFileNO) throws DataAccessException; 

	/** 해당 게시물 삭제하기 **/
	public void deleteArticle(int articleNO) throws DataAccessException;

	/** 해당 게시물의 첨부파일 가져오기 **/
	public List selectImageFileList(int articleNO) throws DataAccessException;
	
	/** 전체 글 수를 조회하기 **/
	public int selectTotArticles() throws DataAccessException;
}
