package com.bookshop.admin.member.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bookshop.admin.member.dao.AdminMemberDAO;
import com.bookshop.member.vo.MemberVO;

@Service("adminMemberService")
@Transactional(propagation = Propagation.REQUIRED)
public class AdminMemberServiceImpl implements AdminMemberService {
	@Autowired
	private AdminMemberDAO adminMemberDAO;

	/** 관리자 회원 목록 가져오기 **/
	public ArrayList<MemberVO> listMember(HashMap condMap) throws Exception {
		return adminMemberDAO.listMember(condMap);
	}

	/** 관리자 회원 상세보기 **/
	public MemberVO memberDetail(String member_id) throws Exception {
		return adminMemberDAO.memberDetail(member_id);
	}

	/** 관리자 회원 정보수정 **/
	public void modifyMemberInfo(HashMap memberMap) throws Exception {
		String member_id = (String) memberMap.get("member_id");
		adminMemberDAO.modifyMemberInfo(memberMap);
	}
}
