package com.park.biz.board.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.park.biz.board.BoardVO;
import com.park.biz.common.SqlSessionBean;

public class BoardDAO3 {
	
	private SqlSession mybatis;
	
	// 생성자 주입
	public BoardDAO3() {
		mybatis=SqlSessionBean.getSqlSessionInstance();
	}
	
	public void insertBoard(BoardVO vo) {
		mybatis.insert("BoardDAO.insertBoard",vo);
		mybatis.commit();
	}
	public void updateBoard(BoardVO vo) {
		mybatis.update("BoardDAO.updateBoard",vo);
		mybatis.commit();
	}
	public void deleteBoard(BoardVO vo) {
		mybatis.delete("BoardDAO.deleteBoard",vo);
		mybatis.commit();
	}
	public BoardVO selectOneBoard(BoardVO vo) {
		return mybatis.selectOne("BoardDAO.selectOneBoard",vo);
	}
	public List<BoardVO> selectAllBoard(BoardVO vo) {
		return mybatis.selectList("BoardDAO.selectAllBoard",vo);
	}
}
