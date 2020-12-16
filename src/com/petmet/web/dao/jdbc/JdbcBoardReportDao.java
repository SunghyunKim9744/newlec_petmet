package com.petmet.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.petmet.web.dao.BoardReportDao;
import com.petmet.web.entity.Board;
import com.petmet.web.entity.BoardCategory;
import com.petmet.web.entity.BoardReport;
import com.petmet.web.entity.BoardReportView;

public class JdbcBoardReportDao implements BoardReportDao {
	private String url = DBContext.URL;
	private String uid = DBContext.UID;
	private String pwd = DBContext.PWD;    

	@Override
	public int insert(BoardReport boardReport) {
		int result = 0;

		String sql = "INSERT INTO BOARD_REPORT(MEM_ID, BOARD_ID, CONTENT) VALUES(?, ?, ?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, boardReport.getMemId());
			pst.setInt(2, boardReport.getBoardId());
			pst.setString(3, boardReport.getContent());

			result = pst.executeUpdate();

			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int update(BoardReport boardReport) {
		int result = 0;
		String sql = "UPDATE BOARD_REPORT SET MEM_ID=?, BOARD_ID=?, CONTENT=? WHERE ID=?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, boardReport.getMemId());
			pst.setInt(2, boardReport.getBoardId());
			pst.setString(3, boardReport.getContent());
			pst.setInt(4, boardReport.getId());

			result = pst.executeUpdate();

			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int delete(int id) {
		int result = 0;

		String sql = "DELETE FROM BOARD_REPORT WHERE ID=?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setInt(1, id);
			result = pst.executeUpdate();

			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public BoardReport get(int id) {
		BoardReport b = null;

		String sql = "SELECT * FROM BOARD_REPORT WHERE ID=?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				String memId = rs.getString("MEM_ID");
				int boardId = rs.getInt("BOARD_ID");
				Date regDate = rs.getDate("REG_DATE");
				String content = rs.getString("CONTENT");
				
			    b = new BoardReport(id, memId, boardId, regDate, content);
			}

			pst.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return b;
	}

	@Override
	public List<BoardReport> getList(String selectBox, String query, String boardCategory, Date startDate, Date endDate,
			int startIndex, int endIndex) {
		String sql = "SELECT * " + 
					"FROM(" + 
					"    SELECT ROWNUM NUM, BR.* " + 
					"    FROM(" + 
					"        SELECT * FROM BOARD_REPORT ORDER BY REG_DATE DESC" + 
					"    ) BR " + 
					") " + 
					"WHERE NUM BETWEEN ? AND ?";

		// 검색폼의 검색 경우의 수
		if (query != null || !(query.equals("")))
			sql += " AND " + selectBox + " LIKE '%" + query + "%'";

		if (boardCategory != null || !(boardCategory.equals("게시판")))
			sql += " AND CATEGORY_ID LIKE '%" + boardCategory + "%'";

		if (startDate != null || endDate != null)
			sql += " AND REG_DATE BETWEEN '" + startDate + " 00:00:00' AND '" + endDate + " 23:59:59'";

		List<BoardReport> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, startIndex);
			pst.setInt(2, endIndex);
			
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID");
				String memId = rs.getString("MEM_ID");
				int boardId = rs.getInt("BOARD_ID");
				Date regDate = rs.getDate("REG_DATE");
				String content = rs.getString("CONTENT");

				BoardReport b = new BoardReport(id, memId, boardId, regDate, content);

				list.add(b);
			}

			rs.close();
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<BoardReportView> getViewList(String selectBox, String query, String boardCategory, Date startDate,
			Date endDate, int startIndex, int endIndex) {
		String sql = "SELECT * FROM REPORTED_BOARD_VIEW WHERE NUM BETWEEN ? AND ?";

		// 검색폼의 검색 경우의 수
		if (query != null)
			sql += " AND " + selectBox + " LIKE '%" + query + "%'";

		if (boardCategory != null)
			sql += " AND CATEGORY_ID LIKE '%" + boardCategory + "%'";

		if (startDate != null || endDate != null)
			sql += " AND REG_DATE BETWEEN '" + startDate + " 00:00:00' AND '" + endDate + " 23:59:59'";

		List<BoardReportView> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, startIndex);
			pst.setInt(2, endIndex);
			
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int num = rs.getInt("NUM");
				int boardId = rs.getInt("BOARD_ID");
				String categoryId = rs.getString("CATEGORY_ID");
				String writerId = rs.getString("WRITER_ID");
				String title = rs.getString("TITLE");
				Date regDate = rs.getDate("REG_DATE");
				int hit = rs.getInt("HIT");
				int reported = rs.getInt("REPORTED");

				BoardReportView brv = new BoardReportView(num, boardId, writerId, categoryId, title, regDate, hit, reported);

				list.add(brv);
			}

			rs.close();
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<BoardReport> getListByBoardId(int boardId) {
		String sql = "SELECT * "
					+ "FROM("
					+ "    SELECT ROWNUM NUM, BR.* "
					+ "    FROM("
					+ "        SELECT * FROM BOARD_REPORT ORDER BY REG_DATE DESC"
					+ "    ) BR "
					+ ") "
					+ "WHERE BOARD_ID = ?";

		List<BoardReport> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, uid, pwd);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, boardId);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID");
				String memId = rs.getString("MEM_ID");
				Date regDate = rs.getDate("REG_DATE");
				String content = rs.getString("CONTENT");

				BoardReport b = new BoardReport(id, memId, boardId, regDate, content);

				list.add(b);
			}

			rs.close();
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return list;
	}

}
