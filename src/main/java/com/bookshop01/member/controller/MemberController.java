package com.bookshop01.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookshop01.member.vo.MemberVO;

public interface MemberController {
	/** 로그인 기능 구현 **/
	public ModelAndView login(@RequestParam Map<String, String> loginMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	/** 로그아웃 기능 구현 **/
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception;

	/** 회원가입 기능 구현 **/
	public ResponseEntity addMember(@ModelAttribute("member") MemberVO member, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	/** 아이디 중복인지 확인하는 기능 구현 **/
	public ResponseEntity overlapped(@RequestParam("id") String id, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

}
