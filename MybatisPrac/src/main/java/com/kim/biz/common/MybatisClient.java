package com.kim.biz.common;

import java.util.List;

import com.kim.biz.board.BoardVO;
import com.kim.biz.board.impl.BoardDAO3;

public class MybatisClient {
	
	public static void main(String[] args) {

		BoardDAO3 boardDAO=new BoardDAO3();
		
		BoardVO vo=new BoardVO();
		vo.setTitle("���̹�Ƽ��");
		vo.setWriter("����Ƽ��");
		vo.setContent("mybatis");
		boardDAO.insertBoard(vo);
		
		vo.setSearchCondition("TITLE");
		vo.setSearchContent("��");
		List<BoardVO> datas=boardDAO.selectAllBoard(vo);
		for(BoardVO v:datas) {
			System.out.println(v);
		}
		
	}
}
