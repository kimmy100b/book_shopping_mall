package com.bookshop01.board.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.bookshop01.board.vo.ArticleVO;
import com.bookshop01.board.vo.ImageVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	private SqlSession sqlSession;

	/** 게시물 목록 list로 가져오기 **/
	@Override
	public List selectAllArticlesList(Map<String, Integer> pagingMap) throws DataAccessException {
		List<ArticleVO> articlesList = new ArrayList<ArticleVO>();
		int section = (Integer) pagingMap.get("section");
		int pageNum = (Integer) pagingMap.get("pageNum");
		
		articlesList = sqlSession.selectList("mapper.board.selectAllArticlesList", pagingMap);
		return articlesList;
	}

	/** 새 글의 데이터 추가하기 **/
	@Override
	public int insertNewArticle(Map articleMap) throws DataAccessException {
		int articleNO = selectNewArticleNO();
		articleMap.put("articleNO", articleNO);
		sqlSession.insert("mapper.board.insertNewArticle", articleMap);
		return articleNO; // 게시물 번호 반환
	}

	/** 새 글의 첨부파일 데이터 추가하기 **/
	@Override
	public void insertNewImage(Map articleMap) throws DataAccessException {
		List<ImageVO> imageFileList = (ArrayList) articleMap.get("imageFileList");
		int articleNO = (Integer) articleMap.get("articleNO");
		int imageFileNO = selectNewImageFileNO();
		for (ImageVO imageVO : imageFileList) {
			imageVO.setImageFileNO(++imageFileNO);
			imageVO.setArticleNO(articleNO);
		}
		sqlSession.insert("mapper.board.insertNewImage", imageFileList);
	}

	/** 해당 게시물의 데이터 가져오기 **/
	@Override
	public ArticleVO selectArticle(int articleNO) throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectArticle", articleNO);
	}

	/** 해당 게시물 수정하기 **/
	@Override
	public void updateArticle(Map articleMap) throws DataAccessException {
		sqlSession.update("mapper.board.updateArticle", articleMap);
	}
	
	/** 해당 게시물 첨부파일 삭제하기 **/
	@Override
	public void deleteImage(List<Integer> delFileNO) throws DataAccessException {
		sqlSession.delete("mapper.board.deleteImage", delFileNO);
	}

	/** 해당 게시물 삭제하기 **/
	@Override
	public void deleteArticle(int articleNO) throws DataAccessException {
		sqlSession.delete("mapper.board.deleteArticle", articleNO);

	}

	/** 해당 게시물의 첨부파일 가져오기 **/
	@Override
	public List selectImageFileList(int articleNO) throws DataAccessException {
		List<ImageVO> imageFileList = null;
		imageFileList = sqlSession.selectList("mapper.board.selectImageFileList", articleNO);
		return imageFileList;
	}
	
	/** 전체 글 수를 조회하기 **/
	@Override
	public int selectTotArticles() throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectTotArticles");
	}

	/** 새로 추가한 게시물 articleNO을 가져오기 **/
	private int selectNewArticleNO() throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectNewArticleNO");
	}

	/** 새로 추가한 게시물 imageFileNo을 가져오기 **/
	private int selectNewImageFileNO() throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectNewImageFileNO");
	}
}
