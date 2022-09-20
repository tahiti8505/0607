package com.park.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.park.biz.board.BoardVO;
import com.park.biz.board.impl.BoardDAO;

public class BoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardVO bvo = new BoardVO();
		bvo.setBid(Integer.parseInt(request.getParameter("bid")));
		
		BoardDAO bdao = new BoardDAO();
		bvo = bdao.selectOneBoard(bvo);
		
		ModelAndView mav= new ModelAndView();
		mav.addObject("data", bvo);
		mav.setViewName("boardForm");
		return mav;
	}
	

}
