package com.park.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.park.biz.member.MemberVO;
import com.park.biz.member.impl.MemberDAO;

public class LoginController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		MemberVO mvo = new MemberVO();
		mvo.setMid(mid);
		mvo.setMpw(mpw);
		
		MemberDAO mDAO = new MemberDAO();
		mvo = mDAO.selectOneMember(mvo);
		
		if(mvo==null) {
			return "login";
		}
		else {
			return "main.do";
		}
	}

	
}
