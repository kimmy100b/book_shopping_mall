package com.bookshop.board.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bookshop.board.dao.BoardDAO;
import com.bookshop.board.vo.ArticleVO;
import com.bookshop.board.vo.ImageVO;

@Service("boardService")
@Transactional(propagation = Propagation.REQUIRED)
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDAO boardDAO;
	
	/** 페이징 게시물 목록 표시하기 **/
	@Override
	public Map listArticles(Map pagingMap) throws Exception {
		Map articlesMap = new HashMap();
		List<ArticleVO> articlesList = boardDAO.selectAllArticlesList(pagingMap);
		int totArticles = boardDAO.selectTotArticles();
		articlesMap.put("articlesList",articlesList);
		articlesMap.put("totArticles",totArticles);
		return articlesMap;
	}

	/** 새 글 추가하기 & 답글 추가하기 **/
	@Override
	public int addNewArticle(Map articleMap) throws Exception {
		int articleNO = boardDAO.insertNewArticle(articleMap);
		articleMap.put("articleNO", articleNO);
		List<ImageVO> imageFileList = (ArrayList) articleMap.get("imageFileList");
		if (imageFileList != null && imageFileList.size() != 0) { 
			boardDAO.insertNewImage(articleMap);
		}
		return articleNO;
	}
	
	/** 게시물 수정하기 **/
	@Override
	public void modArticle(Map articleMap) throws Exception {
		boardDAO.updateArticle(articleMap);
		
		// 기존 첨부파일 삭제
		List<Integer> delFileNO =   (List<Integer>) articleMap.get("delFileNO");
		if(delFileNO != null && delFileNO.size() != 0) {
			boardDAO.deleteImage(delFileNO);
		}
		
		// 새로운 첨부파일 등록
		List<ImageVO> imageFileList = (ArrayList) articleMap.get("imageFileList");
		if (imageFileList != null && imageFileList.size() != 0) { 
			boardDAO.insertNewImage(articleMap);
		}		
	}

	/** 특정 게시물 보기 **/
	@Override
	public Map viewArticle(int articleNO) throws Exception {
		Map articleMap = new HashMap();
		ArticleVO articleVO = boardDAO.selectArticle(articleNO);
		List<ImageVO> imageFileList = boardDAO.selectImageFileList(articleNO);
		articleMap.put("article", articleVO);
		articleMap.put("imageFileList", imageFileList);
		return articleMap;
	}

	/** 게시물 삭제하기 **/
	@Override
	public void removeArticle(int articleNO) throws Exception {
		boardDAO.deleteArticle(articleNO);
	}
}
