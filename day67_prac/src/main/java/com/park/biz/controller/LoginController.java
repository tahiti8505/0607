package com.park.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

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
public class LoginController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("로그인 로그");
		MemberVO mvo = new MemberVO();
		mvo.setMid(request.getParameter("mid"));
		mvo.setMpw(request.getParameter("mpw"));

		
		MemberDAO mDAO = new MemberDAO();
		mvo = mDAO.selectOneMember(mvo);
		
		ModelAndView mav = new ModelAndView();
		if(mvo==null) {
			mav.setViewName("login.jsp");
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute("member", mvo);
			mav.setViewName("main.do");
		}
		return mav;
	}
	
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
