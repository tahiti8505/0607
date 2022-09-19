package com.park.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.park.biz.member.MemberVO;
import com.park.biz.member.impl.MemberDAO;

public class SignupController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String name = request.getParameter("name");
		String role = request.getParameter("role");
		MemberVO mvo = new MemberVO();
		mvo.setMid(mid);
		mvo.setMpw(mpw);
		mvo.setName(name);
		mvo.setRole(role);
		MemberDAO mDAO = new MemberDAO();
		
		mDAO.insertMember(mvo);
		return "main.do";
	}
	
}
