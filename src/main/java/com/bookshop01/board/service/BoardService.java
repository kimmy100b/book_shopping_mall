package com.bookshop01.board.service;

import java.util.List;
import java.util.Map;

import com.bookshop01.board.vo.ArticleVO;

public interface BoardService {
	/** �Խù� ��� ǥ���ϱ� **/
	public List<ArticleVO> listArticles() throws Exception;

	/** �� �� �߰��ϱ� **/
	public int addNewArticle(Map articleMap) throws Exception;

	/** Ư�� �Խù� ���� **/
	public Map viewArticle(int articleNO) throws Exception;

	/** �Խù� �����ϱ� **/
	public void modArticle(Map articleMap) throws Exception;

	/** �Խù� �����ϱ� **/
	public void removeArticle(int articleNO) throws Exception;
}
