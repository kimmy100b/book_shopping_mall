package com.bookshop.admin.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface AdminMemberController {
	/** 관리자 회원관리 **/
	public ModelAndView adminGoodsMain(@RequestParam Map<String, String> dateMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	/** 관리자 회원 상세보기 **/
	public ModelAndView memberDetail(HttpServletRequest request, HttpServletResponse response) throws Exception;

	/** 관리자 회원 정보수정 **/
	public void modifyMemberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception;

	/** 관리자 회원 삭제 **/
	public ModelAndView deleteMember(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
