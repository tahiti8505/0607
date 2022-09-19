package com.park.biz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.park.biz.board.BoardVO;
import com.park.biz.board.impl.BoardDAO;

public class MainController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		BoardVO bvo = new BoardVO();
		BoardDAO bDAO = new BoardDAO();
		
		List<BoardVO> datas = bDAO.selectAllBoard(bvo);
		HttpSession session = request.getSession();
		session.setAttribute("datas", datas);
		return "main.do";
	}

}
