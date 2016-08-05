package kr.ac.sungkyul.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.sungkyul.mysite.vo.BoardVo;

public class BoardDao {
	public List<BoardkVo> getList() {
		List<BoardVo> list = new ArrayList<BoardVo>();
		Statement stmt = null;
		Connection connection = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			connection = DriverManager.getConnection(url, "webdb", "webdb");
			stmt = connection.createStatement();
			String sql = "select  from board";

			rs = stmt.executeQuery(sql);

			
			while(rs.next()){
//				Long no = rs.getLong(1);
//				String name = rs.getString(2);
//				String content = rs.getString(3);
//				String regDate = rs.getString(4);

				BoardVo vo = new BoardVo();
//				vo.setNo(no);
//				vo.setName(name);
//				vo.setContent(content);
//				vo.setRegDate(regDate);

				list.add(vo);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {

					stmt.close();
				}
				if(connection != null){
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;

	}
}
