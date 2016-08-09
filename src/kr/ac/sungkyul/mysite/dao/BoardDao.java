package kr.ac.sungkyul.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.sungkyul.mysite.vo.BoardVo;

public class BoardDao {
	
	public BoardVo get(Long vno) {
		BoardVo vo = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			connection = DriverManager.getConnection(url, "webdb", "webdb");
			

			String sql = "select no, title, content, view_count from board where no=? ";
			pstmt = connection.prepareStatement(sql);

			pstmt.setLong(1, vno);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()){
				Long no = rs.getLong(1);
				String title =rs.getString(2);
				String content =rs.getString(3);
				Long viewNo = rs.getLong(4);

			vo= new BoardVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setViewNo(viewNo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null){
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (connection != null) {

					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vo;
	}
	
	
	public boolean viewcount(BoardVo vo) {
		Connection connection =null;
		PreparedStatement pstmt = null;
		int count = 0;
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		connection = DriverManager.getConnection(url, "webdb", "webdb");
		
		
		
		String sql = "update BOARD set view_count =? where no=?";
			pstmt= connection.prepareStatement(sql);
			System.out.println(vo.getViewNo());
		Long vcount = vo.getViewNo()+1;
		pstmt.setLong(1, vcount);
		pstmt.setLong(2, vo.getNo());
		
		count = pstmt.executeUpdate();
		
		
		}catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				
				if (pstmt != null) {

					pstmt.close();
				}
				if(connection != null){
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return (count==1);
	
	}
	public List<BoardVo> getList() {
		List<BoardVo> list = new ArrayList<BoardVo>();
		Statement stmt = null;
		Connection connection = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			connection = DriverManager.getConnection(url, "webdb", "webdb");
			stmt = connection.createStatement();
			String sql ="select a.no, title, b.name, content, reg_date, view_count, b.no from board a, users b where a.user_no = b.no order by group_no DESC, order_no ASC";
			
			rs = stmt.executeQuery(sql);

			
			while(rs.next()){
				Long no = rs.getLong(1);
				String title = rs.getString(2);
				String name = rs.getString(3);
				String content = rs.getString(4);
				String regDate = rs.getString(5);
				Long viewNo = rs.getLong(6);
				Long userNo = rs.getLong(7);
				
				BoardVo vo = new BoardVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setName(name);
				vo.setContent(content);
				vo.setRegDate(regDate);
				vo.setViewNo(viewNo);
				vo.setUserNo(userNo);
				
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
	
	
	public boolean delete(BoardVo vo) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		int count= 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			connection = DriverManager.getConnection(url, "webdb", "webdb");
			String sql ="delete from board where no =?";
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setLong(1, vo.getNo());
			
			count = pstmt.executeUpdate();

		
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				
				if (pstmt != null) {

					pstmt.close();
				}
				if(connection != null){
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return (count==1);

	}
	public boolean write(BoardVo vo) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		int count= 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			connection = DriverManager.getConnection(url, "webdb", "webdb");
			String sql ="insert into board values(seq_board.nextval, ?, ?, sysdate, 0, 1, 1, 1, ?)";
			pstmt = connection.prepareStatement(sql);
		
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setLong(3, vo.getUserNo());//userno
			
			count = pstmt.executeUpdate();

		
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				
				if (pstmt != null) {

					pstmt.close();
				}
				if(connection != null){
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return (count==1);

	}
	
	public boolean  modify(BoardVo vo) {
		Connection connection =null;
		PreparedStatement pstmt = null;
		int count=0;
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		connection = DriverManager.getConnection(url, "webdb", "webdb");
		
		
		
		String sql = "update BOARD set title =?, content=? where no=?";
		System.out.println(vo.getNo());
		pstmt= connection.prepareStatement(sql);
		
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		pstmt.setLong(3, vo.getNo());
		
		count = pstmt.executeUpdate();
		
		
		}catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				
				if (pstmt != null) {

					pstmt.close();
				}
				if(connection != null){
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return (count==1);
	
	}
}
