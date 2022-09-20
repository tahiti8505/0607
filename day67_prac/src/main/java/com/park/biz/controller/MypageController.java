package com.park.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.park.biz.member.MemberVO;
import com.park.biz.member.impl.MemberDAO;

public class MypageController implements Controller {

		@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String mid = request.getParameter("mid");
			String mpw = request.getParameter("mpw");
			MemberVO mvo = new MemberVO();
			mvo.setMid(mid);
			mvo.setMpw(mpw);
			MemberDAO mDAO = new MemberDAO();
			
			ModelAndView mav = new ModelAndView();
			mDAO.updateMember(mvo);
			
			HttpSession session = request.getSession();
			session.invalidate();
			mav.setViewName("redirect:login.jsp");
			return mav;
	}
}
