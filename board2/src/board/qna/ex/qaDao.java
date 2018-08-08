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
	
	







}
