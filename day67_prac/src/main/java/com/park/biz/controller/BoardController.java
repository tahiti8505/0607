package com.park.biz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.park.biz.board.BoardVO;
import com.park.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	
	@RequestMapping("/board.do")
	public ModelAndView selectOneBoard(BoardVO bvo, BoardDAO bDAO, ModelAndView mav, HttpServletRequest request) {
		BoardDAO bdao = new BoardDAO();
		bvo = bdao.selectOneBoard(bvo);
		mav.addObject("data", bvo);
		mav.setViewName("boardForm.jsp");
		
		return mav;
	}
	@RequestMapping("/main.do")
	public ModelAndView selectAllBoard(BoardVO bvo, BoardDAO bDAO, ModelAndView mav, HttpServletRequest request) {
			List<BoardVO> datas = bDAO.selectAllBoard(bvo);
			mav.setViewName("main.jsp");
			mav.addObject("datas", datas);
			
			return mav;
	}
	@RequestMapping("/deleteB.do")
	public String deleteBoard(BoardVO bvo, BoardDAO bDAO, HttpServletRequest request) {
		bDAO.deleteBoard(bvo);
		
		return "redirect:main.do";
	}
	@RequestMapping("/updateB.do")
	public String updateBoard(BoardVO bvo, BoardDAO bDAO, HttpServletRequest request) {
		bDAO.updateBoard(bvo);
		
		return "redirect:main.do";
	}


}
