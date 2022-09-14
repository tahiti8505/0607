package com.park.biz.member.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.park.biz.common.JDBCUtil;
import com.park.biz.member.MemberVO;

@Repository("memberDAO")
public class MemberDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	
	final String sql_insert="INSERT INTO MEMBER VALUES(?,?,?,?)";
	final String sql_login ="SELECT * FROM MEMBER WHERE MID=? AND MPW=?";
	final String sql_update="UPDATE BOARD SET TITLE=?,CONTENT=? WHERE BID=?";
	final String sql_delete="DELETE BOARD WHERE BID=?";
	
	void insertMember(MemberVO mvo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql_insert);
			pstmt.setString(1, mvo.getMid());
			pstmt.setString(2, mvo.getMpw());
			pstmt.setString(3, mvo.getName());
			pstmt.setString(4, mvo.getRole());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	void updateMember(MemberVO mvo) {
	}
	void deleteMember(MemberVO mvo) {
	}
	MemberVO selectOneMember(MemberVO mvo) {
		conn=JDBCUtil.connect();
		ResultSet rs = null;
		try {
			pstmt=conn.prepareStatement(sql_login);
			pstmt.setString(1, mvo.getMid());
			pstmt.setString(2, mvo.getMpw());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				MemberVO data = new MemberVO();
				data.setMid(rs.getString("MID"));
				data.setMpw(rs.getString("MPW"));
				data.setName(rs.getString("NAME"));
				data.setRole(rs.getString("ROLE"));
				return data;
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return null;
	}
	List<MemberVO> selectAllMember(MemberVO mvo){
		return null;
	}
}
