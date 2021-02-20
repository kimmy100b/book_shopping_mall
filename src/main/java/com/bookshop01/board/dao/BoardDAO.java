package com.bookshop01.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.bookshop01.board.vo.ArticleVO;

public interface BoardDAO {
	/** �Խù� ��� list�� �������� **/
	public List selectAllArticlesList() throws DataAccessException;

	/** �� ���� ������ �߰��ϱ� **/
	public int insertNewArticle(Map articleMap) throws DataAccessException;

	/** �� ���� ÷������ ������ �߰��ϱ� **/
	public void insertNewImage(Map articleMap) throws DataAccessException;

	/** �ش� �Խù��� ������ �������� **/
	public ArticleVO selectArticle(int articleNO) throws DataAccessException;

	/** �ش� �Խù� �����ϱ� **/
	public void updateArticle(Map articleMap) throws DataAccessException;

	/** �ش� �Խù� �����ϱ� **/
	public void deleteArticle(int articleNO) throws DataAccessException;

	/** �ش� �Խù��� ÷������ �������� **/
	public List selectImageFileList(int articleNO) throws DataAccessException;
}
