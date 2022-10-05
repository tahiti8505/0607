package com.kim.biz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kim.biz.board.BoardVO;
import com.kim.biz.board.impl.BoardDAO;

public class MainController {

	@ModelAttribute("scMap")
	public Map<String,String> searchConditionMap(){
		Map<String,String> scMap=new HashMap<String,String>();
		scMap.put("����", "TITLE");
		scMap.put("�ۼ���", "WRITER");
		return scMap;
	}
	
	@RequestMapping("/main.do")
	public String main(@RequestParam(value="searchCondition",defaultValue="TITLE",required=false)String searchCondition,@RequestParam(value="searchContent",defaultValue="",required=false)String searchContent,BoardVO bVO,BoardDAO bDAO,Model model) {
		System.out.println("�˻�����: "+searchCondition);
		System.out.println("�˻���: "+searchContent);
		
		List<BoardVO> datas=bDAO.selectAllBoard(bVO);
		
		model.addAttribute("datas", datas);
		return "main.jsp";
	}

	/*
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		BoardVO bVO=new BoardVO();
		
		BoardDAO bDAO=new BoardDAO();
		List<BoardVO> datas=bDAO.selectAllBoard(bVO);
		
		HttpSession session=request.getSession();
		session.setAttribute("datas", datas);
		
		return "main";
	}
	*/
	
}
