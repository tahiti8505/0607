package com.park.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.park.biz.board.BoardVO;
import com.park.biz.board.impl.BoardDAO;

public class DeleteBController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardVO bvo = new BoardVO();
		BoardDAO bdao = new BoardDAO();
		
		bvo.setBid(Integer.parseInt(request.getParameter("bid")));
	
		bdao.deleteBoard(bvo);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main.do");
		return mav;
	}
	

}
