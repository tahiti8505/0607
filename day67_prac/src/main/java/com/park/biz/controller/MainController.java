package com.park.biz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.park.biz.board.BoardVO;
import com.park.biz.board.impl.BoardDAO;

public class MainController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
			BoardVO bvo = new BoardVO();
			BoardDAO bDAO = new BoardDAO();
			
			List<BoardVO> datas = bDAO.selectAllBoard(bvo);
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("main");
			mav.addObject("datas", datas);
			return mav;
	}
}
