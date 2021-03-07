package com.bookshop.admin.member.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.bookshop.member.vo.MemberVO;

@Repository("adminMemberDao")
public class AdminMemberDAOImpl implements AdminMemberDAO {
	@Autowired
	private SqlSession sqlSession;

	/** 관리자 회원 목록 가져오기 **/
	public ArrayList<MemberVO> listMember(HashMap condMap) throws DataAccessException {
		ArrayList<MemberVO> memberList = (ArrayList) sqlSession.selectList("mapper.admin.member.listMember", condMap);
		return memberList;
	}

	/** 관리자 회원 정보 가져오기 **/
	public MemberVO memberDetail(String member_id) throws DataAccessException {
		MemberVO memberBean = (MemberVO) sqlSession.selectOne("mapper.admin.member.memberDetail", member_id);
		return memberBean;
	}

	/** 관리자 회원 정보 수정하기 **/
	public void modifyMemberInfo(HashMap memberMap) throws DataAccessException {
		sqlSession.update("mapper.admin.member.modifyMemberInfo", memberMap);
	}

}
