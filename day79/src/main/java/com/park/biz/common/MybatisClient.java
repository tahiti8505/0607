package com.park.biz.common;

import java.util.List;

import com.park.biz.board.BoardVO;
import com.park.biz.board.impl.BoardDAO3;

public class MybatisClient {
	public static void main(String[] args) {
		
		BoardDAO3 boardDAO = new BoardDAO3();
		
		BoardVO vo = new BoardVO();
		
		vo.setTitle("마이바티스");
		vo.setWriter("허허");
		vo.setContent("mybatis");
		boardDAO.insertBoard(vo);
		
		vo.setSearchCondition("TITLE");
		vo.setSearchContent("이");
		List<BoardVO> datas=boardDAO.selectAllBoard(vo);
		for(BoardVO v : datas){
			System.out.println(v);
		}
	}
}
