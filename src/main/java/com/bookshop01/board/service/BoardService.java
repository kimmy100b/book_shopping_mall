package com.bookshop01.board.service;

import java.util.List;
import java.util.Map;

import com.bookshop01.board.vo.ArticleVO;

public interface BoardService {
	/** 게시물 목록 표시하기 **/
	public List<ArticleVO> listArticles() throws Exception;

	/** 새 글 추가하기 **/
	public int addNewArticle(Map articleMap) throws Exception;

	/** 특정 게시물 보기 **/
	public Map viewArticle(int articleNO) throws Exception;

	/** 게시물 수정하기 **/
	public void modArticle(Map articleMap) throws Exception;

	/** 게시물 삭제하기 **/
	public void removeArticle(int articleNO) throws Exception;
}
