package com.park.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.park.biz.member.MemberService;
import com.park.biz.member.MemberVO;

@Controller
@SessionAttributes("member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String index() {
		return "login.jsp";
	}
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String handleRequest(MemberVO mvo, HttpServletRequest request) {
		System.out.println("로그인 로그");
		mvo = memberService.selectOneMember(mvo);
		
		String path;
		if(mvo==null) {
			path = "redirect:login.jsp";
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute("member", mvo);
			path = "redirect:main.do";
		}
		return path;
	}

	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:main.do";
	}
	@RequestMapping(value="/signup.do", method=RequestMethod.POST)
	public String insertMember(MemberVO mvo, HttpServletRequest request) {
		memberService.insertMember(mvo);
		return "redirect:main.do";
	}
	@RequestMapping(value="/signup.do", method=RequestMethod.GET)
	public String showsignup(MemberVO mvo) {
		return "signin.jsp";
	}
	@RequestMapping("/deleteM.do")
	public String deleteMember(MemberVO mvo, HttpServletRequest request) {
		memberService.deleteMember(mvo);
		HttpSession session = request.getSession();
		session.invalidate();

		return "redirect:main.do";
	}
	@RequestMapping("/updateM.do")
	public String updateMember(MemberVO mvo, HttpServletRequest request ) {
		System.out.println("update 로그 : " + mvo);
		memberService.updateMember(mvo);
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:login.jsp";
	}
}
