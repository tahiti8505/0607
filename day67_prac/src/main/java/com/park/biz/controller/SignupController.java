package com.park.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.park.biz.member.MemberVO;
import com.park.biz.member.impl.MemberDAO;

public class SignupController implements Controller{
	
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
			ModelAndView mav = new ModelAndView();
			mav.setViewName("redirect:main.do");
			return mav;
	}
}
