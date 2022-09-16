package com.park.biz.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.park.biz.member.MemberService;
import com.park.biz.member.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired // MemberDAO 타입의 객체가 메모리에 있어야지만 DI(의존성 주입) 가능함!
	private MemberDAO memberDAO;
	
	@Override
	public void insertMember(MemberVO mvo) {
		memberDAO.insertMember(mvo);
	}
	@Override
	public void updateMember(MemberVO mvo) {
		memberDAO.updateMember(mvo);
	}
	@Override
	public void deleteMember(MemberVO mvo) {
		memberDAO.deleteMember(mvo);
	}
	@Override
	public MemberVO selectOneMember(MemberVO mvo) {
		return memberDAO.selectOneMember(mvo);
	}
	@Override
	public List<MemberVO> selectAllMember(MemberVO mvo) {
		return memberDAO.selectAllMember(mvo);
	}
}
