package com.bookshop.admin.member.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.bookshop.member.vo.MemberVO;

public interface AdminMemberService {
	/** 관리자 회원 목록 가져오기 **/
	public ArrayList<MemberVO> listMember(HashMap condMap) throws Exception;

	/** 관리자 회원 상세보기 **/
	public MemberVO memberDetail(String member_id) throws Exception;

	/** 관리자 회원 정보수정 **/
	public void modifyMemberInfo(HashMap memberMap) throws Exception;
}
