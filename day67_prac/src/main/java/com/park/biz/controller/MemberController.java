package com.park.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.park.biz.member.MemberVO;
import com.park.biz.member.impl.MemberDAO;

@Controller
public class MemberController {
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String index() {
		return "login.jsp";
	}
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public ModelAndView handleRequest(MemberVO mvo, MemberDAO mDAO, ModelAndView mav, HttpServletRequest request) {
		System.out.println("로그인 로그");
		mvo = mDAO.selectOneMember(mvo);

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

	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:login.do";
	}
	@RequestMapping("signup.do")
	public String insertMember(MemberVO mvo, MemberDAO mDAO, HttpServletRequest request) {
		mDAO.insertMember(mvo);
		return "redirect:main.do";
	}
	@RequestMapping("/deleteM.do")
	public String deleteMember(MemberVO mvo, MemberDAO mDAO, HttpServletRequest request) {
		mDAO.deleteMember(mvo);
		HttpSession session = request.getSession();
		session.invalidate();

		return "redirect:main.do";
	}
	@RequestMapping("/updateM.do")
	public String updateMember(MemberVO mvo, MemberDAO mDAO, HttpServletRequest request ) {
		mDAO.updateMember(mvo);

		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:login.jsp";
	}
}
