package com.david.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.david.vo.Account;


public class AccountDaoImpl implements AccountDao {
	
	private static AccountDaoImpl instance = null;
	
	private AccountDaoImpl() {}
	public static AccountDaoImpl getInstance() {
		if(instance == null) {
			instance = new AccountDaoImpl();
		}
		return instance;
	}
	PreparedStatement pstmt;
	ResultSet rs = null;
	
	

	@Override
	public int insertid(Account account) {
		Conn conn = new Conn();
		int result = 0;
		try {
			String sql = "insert into account(user_name, name, password) values(?,?,?)";
			pstmt = conn.connection.prepareStatement(sql);

			pstmt.setString(1, account.getUser_name());
			pstmt.setString(2, account.getName());
			pstmt.setString(3, account.getPassword());

			int i = pstmt.executeUpdate();
			if (i > 0) {
				result = 1;
				System.out.println("데이터베이스 인서트 성공");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if ( rs != null ) try{rs.close();}catch(Exception e){}
		     if ( pstmt != null ) try{pstmt.close();}catch(Exception e){}
		     if ( conn != null ) try{conn.connection.close();}catch(Exception e){}
		}

		return result;
	}
	
	
	@Override
	public int checkid(Account account) {
		Conn conn = new Conn();
		int result = 0;
		String sql = "select * from account where user_name = ? and password=?";
		try {
			pstmt = conn.connection.prepareStatement(sql);
			
			pstmt.setString(1, account.getUser_name());
			pstmt.setString(2, account.getPassword());
			
			rs = pstmt.executeQuery( );
			if(rs.next()) {
				result = 1;
				System.out.println("아이디 비밀번호 일치");
			} else {
				result = 0;
				System.out.println("아이디 비밀번호 불일치");
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if ( rs != null ) try{rs.close();}catch(Exception e){}
		     if ( pstmt != null ) try{pstmt.close();}catch(Exception e){}
		     if ( conn != null ) try{conn.connection.close();}catch(Exception e){}
			
		}
		return result ;
	}

}
