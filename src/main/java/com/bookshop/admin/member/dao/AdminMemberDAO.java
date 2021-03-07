package com.bookshop.admin.member.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.dao.DataAccessException;

import com.bookshop.member.vo.MemberVO;

public interface AdminMemberDAO {
	/** 관리자 회원 목록 가져오기 **/
	public ArrayList<MemberVO> listMember(HashMap condMap) throws DataAccessException;

	/** 관리자 회원 정보 가져오기 **/
	public MemberVO memberDetail(String member_id) throws DataAccessException;

	/** 관리자 회원 정보 수정하기 **/
	public void modifyMemberInfo(HashMap memberMap) throws DataAccessException;
}
