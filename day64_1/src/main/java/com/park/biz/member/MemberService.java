package com.park.biz.member;

import java.util.List;

import com.park.biz.board.BoardVO;

public interface MemberService {
	void insertMember(MemberVO mvo);
	void updateMember(MemberVO mvo);
	void deleteMember(MemberVO mvo);
	MemberVO selectOneMember(MemberVO mvo);
	List<MemberVO> selectAllMember(MemberVO mvo);
}
