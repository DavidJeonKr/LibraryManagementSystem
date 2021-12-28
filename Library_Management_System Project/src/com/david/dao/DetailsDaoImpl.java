package com.david.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.david.vo.Book;
import com.david.vo.Users;

public class DetailsDaoImpl implements DetailsDao {

	private static DetailsDaoImpl instance = null;
	
	private DetailsDaoImpl() {}
	
	public static DetailsDaoImpl getInstance() {
		if(instance == null) {
			instance = new DetailsDaoImpl();
		}
		return instance;
	}
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	
	@Override
	public List<Book> selectBook() {
		Conn conn = new Conn();
		List<Book> list = new ArrayList<Book>();
		try {
			String sql= "select * from book";
			pstmt= conn.connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				book.setBook_seq(rs.getInt("book_seq"));
				book.setBook_isbn(rs.getLong("book_isbn"));
				book.setBook_title(rs.getString("book_title"));				
				book.setBook_autor(rs.getString("book_author"));
				book.setBook_price(rs.getInt("book_price"));
				book.setBook_pages(rs.getInt("book_pages"));
				book.setBook_code(rs.getInt("book_code"));
				book.setBook_publisher(rs.getString("book_publisher"));
				book.setRent(rs.getInt("book_rent"));
				list.add(book);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if ( rs != null ) try{rs.close();}catch(Exception e){}
		    if ( pstmt != null ) try{pstmt.close();}catch(Exception e){}
		    if ( conn != null ) try{conn.connection.close();}catch(Exception e){}
			
		}
		return list;
	}

	
	@Override
	public int deleteBook(int no) {
		Conn conn = new Conn();
		int result = 0;
		try {
			String sql = "delete from book where book_seq = ? ";
			pstmt = conn.connection.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			int i = pstmt.executeUpdate();
			if(i > 0) {
				result = 1;
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			if ( rs != null ) try{rs.close();}catch(Exception e){}
		    if ( pstmt != null ) try{pstmt.close();}catch(Exception e){}
		    if ( conn != null ) try{conn.connection.close();}catch(Exception e){}
			
		}
		
		return result;
	}
	
	

	@Override
	public List<Users> selectUsers() {
		Conn conn = new Conn();
		List<Users> list = new ArrayList<Users>();
		try {
			String sql= "select * from users";
			pstmt= conn.connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Users user = new Users();
				user.setUser_seq(rs.getInt("user_seq"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_birth(rs.getString("user_birth"));				
				user.setUser_phone(rs.getString("user_phone"));
				user.setUser_mail(rs.getString("user_mail"));
				user.setUser_address(rs.getString("user_address"));
				user.setUser_rent(rs.getInt("user_rent"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if ( rs != null ) try{rs.close();}catch(Exception e){}
		    if ( pstmt != null ) try{pstmt.close();}catch(Exception e){}
		    if ( conn != null ) try{conn.connection.close();}catch(Exception e){}
		}
		return list;
	}



	@Override
	public int deleteUser(int no) {
		Conn conn = new Conn();
		int result = 0;
		try {
			String sql = "delete from users where user_seq = ? ";
			pstmt = conn.connection.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			int i = pstmt.executeUpdate();
			if(i > 0) {
				result = 1;
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			if ( rs != null ) try{rs.close();}catch(Exception e){}
		    if ( pstmt != null ) try{pstmt.close();}catch(Exception e){}
		    if ( conn != null ) try{conn.connection.close();}catch(Exception e){}
			
		}
		
		return result;
	}
	



	@Override
	public Users selectuserone(int no) {
		return null;
	}

}
