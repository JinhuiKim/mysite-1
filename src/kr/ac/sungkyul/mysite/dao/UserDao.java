package kr.ac.sungkyul.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.ac.sungkyul.mysite.vo.UserVo;

public class UserDao {

	public UserVo get(String email, String password) {
		UserVo vo = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			connection = DriverManager.getConnection(url, "webdb", "webdb");
			

			String sql = "select no, name from users where email=? and password=?";
			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()){
				Long no = rs.getLong(1);
				String name =rs.getString(2);
			
			vo= new UserVo();
			vo.setNo(no);
			vo.setName(name);
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

	public boolean insert(UserVo vo) {

		PreparedStatement pstmt = null;
		Connection connection = null;
		int count = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			connection = DriverManager.getConnection(url, "webdb", "webdb");
			String sql = "insert into Users values(seq_Users.nextval, ?, ?, ?, ?)";

			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getGender());
			pstmt.setString(4, vo.getPassword());

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
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return (count == 1);

	}

	public boolean delete(UserVo vo) {
		PreparedStatement pstmt = null;
		Connection connection = null;
		int count = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			connection = DriverManager.getConnection(url, "webdb", "webdb");
			String sql = "delete from User where no =? and password = ?";
			pstmt = connection.prepareStatement(sql);

			pstmt.setLong(1, vo.getNo());
			pstmt.setString(2, vo.getPassword());
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
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return (count == 1);

	}
}
