package com.park.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.park.biz.member.MemberVO;
import com.park.biz.member.impl.MemberDAO;

/*
package com.park.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	
	String handleRequest(HttpServletRequest request, HttpServletResponse response);
}

 */

public class LoginController {
	
	@RequestMapping("/login.do")
	public void selectOneMember(HttpServletRequest request) {
		System.out.println("로그인 로그");
		MemberVO mvo = new MemberVO();
		mvo.setMid(request.getParameter("mid"));
		mvo.setMpw(request.getParameter("mpw"));

		
		MemberDAO mDAO = new MemberDAO();
		mvo = mDAO.selectOneMember(mvo);
		
		if(mvo==null) {
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute("member", mvo);
		}
	}
	
	/*
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("로그인 로그");
		MemberVO mvo = new MemberVO();
		mvo.setMid(request.getParameter("mid"));
		mvo.setMpw(request.getParameter("mpw"));

		
		MemberDAO mDAO = new MemberDAO();
		mvo = mDAO.selectOneMember(mvo);
		
		ModelAndView mav = new ModelAndView();
		if(mvo==null) {
			mav.setViewName("redirect:login.jsp");
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute("member", mvo);
			mav.setViewName("redirect:main.do");
		}
		return mav;
	}
	*/
	
	/*
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
	*/

	
}
