package com.david.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import com.david.vo.Users;

public class UsersDaoImpl implements UsersDao {
	
	
	private static UsersDaoImpl instance = null;
	
	private UsersDaoImpl() {}
	
	public static UsersDaoImpl getInstance() {
		if(instance == null) {
			instance = new UsersDaoImpl();
		}
		return instance;
	}
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	
	
	@Override
	public List<Users> selectList() {
		return null;
	}

	@Override
	public Users selectone(int no) {
		Conn conn = new Conn();
		Users user = new Users();
		try {
			String sql = "select * from users where user_seq = ?";
			pstmt = conn.connection.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				System.out.println("user data 넘기는중!!!!");
				user.setUser_seq(rs.getInt("user_seq"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_birth(rs.getString("user_birth"));				
				user.setUser_phone(rs.getString("user_phone"));
				user.setUser_mail(rs.getString("user_mail"));
				user.setUser_address(rs.getString("user_address"));
				user.setUser_rent(rs.getInt("user_rent"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if ( rs != null ) try{rs.close();}catch(Exception e){}
		     if ( pstmt != null ) try{pstmt.close();}catch(Exception e){}
		     if ( conn != null ) try{conn.connection.close();}catch(Exception e){}
			
		}
		return user;
	}

	@Override
	public int insert(Users user) {
		Conn conn = new Conn();
		int result  = 0;
		String sql = "insert into users(user_name, user_birth, "
				+ "user_phone, user_mail, user_address) "
				+ " values(?,?,?,?,?)";
		try {
			pstmt = conn.connection.prepareStatement(sql);
			
			pstmt.setString(1, user.getUser_name());
			pstmt.setString(2, user.getUser_birth());
			pstmt.setString(3, user.getUser_phone());
			pstmt.setString(4, user.getUser_mail());
			pstmt.setString(5, user.getUser_address());
			
			int i = pstmt.executeUpdate();
			if(i> 0) {
				result = 1;
				System.out.println("데이터베이스 인서트 성공");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if ( rs != null ) try{rs.close();}catch(Exception e){}
		    if ( pstmt != null ) try{pstmt.close();}catch(Exception e){}
		    if ( conn != null ) try{conn.connection.close();}catch(Exception e){}
			
		}
		return result;
		
		
	}

	@Override
	public int update(Users user) {
		return 0;
	}

	@Override
	public int delete(int no) {
		return 0;
	}

}
