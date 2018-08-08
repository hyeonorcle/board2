package board.qna.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class qaDao {

	DataSource dataSource;

	public qaDao() {

		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public ArrayList<qaDto> listQ() {

		ArrayList<qaDto> list = new ArrayList<qaDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		qaDto dto = null;

		try {
			conn = dataSource.getConnection();

			String sql = "select qa_id, qa_name, qa_subject, qa_date, qa_read, qa_replyCount from QnAboard";

			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();

			while(rs.next()) {
				
				dto = new qaDto();
				dto.setQa_id(rs.getInt("qa_id"));
				dto.setQa_name(rs.getString("qa_name"));
				dto.setQa_sub(rs.getString("qa_subject"));
				dto.setQa_date(rs.getTimestamp("qa_date"));
				dto.setQa_read(rs.getInt("qa_read"));
				dto.setQa_count(rs.getInt("qa_replyCount"));

				list.add(dto);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
		
				e2.printStackTrace();
			}
		}

		return list;
	}
	
	public qaDto contentQ(int no) {
		qaDto dto = new qaDto();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		
		int rs = 0;
		ResultSet rs2 = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "update QnAboard set qa_read = qa_read+1 where qa_id =?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeUpdate();
			
			String sql2 = "select qa_id, qa_name, qa_subject,qa_content, qa_date, qa_read, qa_replyCount from QnAboard" 
						  +" where qa_id = ?";

			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setInt(1, no);
			rs2= pstmt2.executeQuery();
			
			if(rs2.next()) {
				
				dto.setQa_id(rs2.getInt("qa_id"));
				dto.setQa_name(rs2.getString("qa_name"));
				dto.setQa_sub(rs2.getString("qa_subject"));
				dto.setQa_con(rs2.getString("qa_content"));
				dto.setQa_date(rs2.getTimestamp("qa_date"));
				dto.setQa_read(rs2.getInt("qa_read"));
				dto.setQa_count(rs2.getInt("qa_replyCount"));
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				if(rs2 != null) rs2.close();
				if(pstmt2 != null) pstmt2.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
		
				e2.printStackTrace();
			}
		}
		
		return dto;
		
		
		
	}
	
	







}
