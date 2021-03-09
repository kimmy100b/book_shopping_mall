package com.bookshop.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

public interface BoardController {

	/** 게시물 목록 표시하기 **/
	public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response) throws Exception;

	/** 새 글 추가하기 **/
	public ResponseEntity addNewArticle(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
			throws Exception;

	/** 특정 게시물 보기 **/
	public ModelAndView viewArticle(@RequestParam("articleNO") int articleNO, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	/** 게시물 수정하기 **/
	public ResponseEntity modArticle(@RequestParam("articleNO") int articleNO, 
			MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception;

	/** 게시물 삭제하기 **/
	public ResponseEntity removeArticle(@RequestParam("articleNO") int articleNO, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	/** 답글 페이지로 이동하기 **/
	public ModelAndView replyForm(@RequestParam("parentNO") int parentNO, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	/** 답글 추가하기 **/
	public ResponseEntity addReply(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)
			throws Exception;

	/** 게시물 삭제하기 **/
	ResponseEntity removeArticle(int articleNO, MultipartHttpServletRequest multipartRequest,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
}
