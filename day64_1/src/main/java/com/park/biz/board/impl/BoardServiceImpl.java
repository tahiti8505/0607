package com.park.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.park.biz.board.BoardService;
import com.park.biz.board.BoardVO;

// BaordServiceImpl 구체화됨
@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
		
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO selectOneBoard(BoardVO vo) {
		return boardDAO.selectOneBoard(vo);
	}

	@Override
	public List<BoardVO> selectAllBoard(BoardVO vo) {
		return boardDAO.selectAllBoard(vo);
	}
	
}
