package com.david.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.david.vo.Book;
import com.david.vo.IssueBook;
import com.david.vo.ReturnBook;

public class BookDaoImpl implements BookDao {
	private static BookDaoImpl instance = null;

	private BookDaoImpl() {
	}

	public static BookDaoImpl getInstance() {
		if (instance == null) {
			instance = new BookDaoImpl();
		}
		return instance;
	}

	Conn con = new Conn();
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public List<Book> selectList() {
		return null;
	}

	@Override
	public Book selectone(int no) {
		Conn conn = new Conn();
		Book book = new Book();
		try {
			String sql = "select * from book where book_seq = ?";
			pstmt = con.connection.prepareStatement(sql);

			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("데이터 넘기는 중!!!");
				book.setBook_seq(rs.getInt("book_seq"));
				book.setBook_isbn(rs.getLong("book_isbn"));
				book.setBook_title(rs.getString("book_title"));				
				book.setBook_autor(rs.getString("book_author"));
				book.setBook_price(rs.getInt("book_price"));
				book.setBook_pages(rs.getInt("book_pages"));
				book.setBook_code(rs.getInt("book_code"));
				book.setBook_publisher(rs.getString("book_publisher"));
				book.setRent(rs.getInt("book_rent"));
			}

			return book;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if ( rs != null ) try{rs.close();}catch(Exception e){}
		    if ( pstmt != null ) try{pstmt.close();}catch(Exception e){}
	        if ( conn != null ) try{conn.connection.close();}catch(Exception e){}
			
		}

		return book;
	}

	@Override
	public int insert(Book book) {
		int result = 0;
		Conn conn = new Conn();
		String sql = "insert into book(book_isbn, book_title, book_author, book_price, book_pages, book_code, book_publisher)"
				+ " values(?,?,?,?,?,?,?)";
		try {
			pstmt = con.connection.prepareStatement(sql);

			pstmt.setLong(1, book.getBook_isbn());
			pstmt.setString(2, book.getBook_title());
			pstmt.setString(3, book.getBook_autor());
			pstmt.setInt(4, book.getBook_price());
			pstmt.setInt(5, book.getBook_pages());
			pstmt.setInt(6, book.getBook_code());
			pstmt.setString(7, book.getBook_publisher());

			int i = pstmt.executeUpdate();
			if (i > 0) {
				result = 1;
				System.out.println("북 인서트 성공(데이트베이스)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if ( rs != null ) try{rs.close();}catch(Exception e){}
		    if ( pstmt != null ) try{pstmt.close();}catch(Exception e){}
		    if ( conn != null ) try{conn.connection.close();}catch(Exception e){}
			
		}
		return result;
	}

	@Override
	public int update(int no) {
		int result = 0;

		return result;
	}

	@Override
	public int delete(int no) {
		return 0;
	}

	// issuebook update
	@Override
	public int updateissue(String book_seq, String user_seq, String bname, String uname) {
		int result = 0;
		Conn conn = new Conn();
		String sql = "insert into issuebook (book_seq, user_seq, bname, uname) values(?,?,?,?)";
		try {
			pstmt = con.connection.prepareStatement(sql);
			pstmt.setString(1, book_seq);
			pstmt.setString(2, user_seq);
			pstmt.setString(3, bname);
			pstmt.setString(4, uname);

			int i = pstmt.executeUpdate();
			if (i > 0) {
				result = 1;
				System.out.println("ISSUEbook 인서트 성공(데이트베이스)");
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

	// 이슈 북 전체검색
	@Override
	public List<IssueBook> select() {
		Conn conn = new Conn();
		List<IssueBook> list = new ArrayList<IssueBook>();
		String sql = "select * from issuebook ";
		try {
			pstmt = con.connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				IssueBook ib = new IssueBook();
				ib.setBook_seq(rs.getString("book_seq"));
				ib.setUser_seq(rs.getString("user_seq"));
				ib.setBname(rs.getString("bname"));
				ib.setUname(rs.getString("uname"));
				ib.setDateofissue(rs.getDate("dateofissue"));
				System.out.println(ib);
				list.add(ib);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if ( rs != null ) try{rs.close();}catch(Exception e){}
		    if ( pstmt != null ) try{pstmt.close();}catch(Exception e){}
		    if ( conn != null ) try{conn.connection.close();}catch(Exception e){}
			
		}
		return list;
	}

	@Override
	public int returnbook(ReturnBook rebook) {
		Conn conn = new Conn();
		int result = 0;
		try {
			String sql = "insert into returnbook(book_seq, user_seq, bname, uname) values(?,?,?,?) ";
			pstmt = con.connection.prepareStatement(sql);
			pstmt.setInt(1, rebook.getBook_seq());
			pstmt.setInt(2, rebook.getUser_seq());
			pstmt.setString(3, rebook.getBname());
			pstmt.setString(4, rebook.getUname());
//			pstmt.setDate(5, (Date) rebook.getDateofissue());
//			pstmt.setDate(6, (Date) rebook.getDateofreturn());

			int i = pstmt.executeUpdate();
			if (i > 0) {
				result = 1;
				System.out.println("return book 데이터 베이스 성공");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) try {rs.close();} catch (Exception e) {}
			if (pstmt != null) try {pstmt.close();} catch (Exception e) {}
		     if ( conn != null ) try{conn.connection.close();}catch(Exception e){}

		}

		return result;
	}

	@Override
	public IssueBook selectIssueBook(int book_seq, int user_seq) {
		// TODO Auto-generated method stub
		Conn conn = new Conn();
		IssueBook issueBook = new IssueBook();
		try {
			String sql = "select * from issuebook where book_seq = ? and user_seq = ?";
			pstmt = con.connection.prepareStatement(sql);
			pstmt.setInt(1, book_seq);
			pstmt.setInt(2, user_seq);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				issueBook.setBname(rs.getString("bname"));
				issueBook.setUname(rs.getString("uname"));
				issueBook.setDateofissue(rs.getDate("dateofissue"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				if ( rs != null ) try{rs.close();}catch(Exception e){}
			     if ( pstmt != null ) try{pstmt.close();}catch(Exception e){}
			     if ( conn != null ) try{conn.connection.close();}catch(Exception e){}
				
		}
		return issueBook;
	}

	@Override
	public void deleteIssue(int no) {
		Conn conn = new Conn();
		try {
			String sql = "delete from issuebook where book_seq = ?";
			pstmt = con.connection.prepareStatement(sql);
			pstmt.setInt(1, no);

			int i = pstmt.executeUpdate();
			if (i > 0) {
				System.out.println("delete 성공");
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
	
		}

	@Override
	public List<ReturnBook> selectReturnBooks() {
		Conn conn = new Conn();
		List<ReturnBook> list = new ArrayList<ReturnBook>();
		String sql = "select * from returnbook ";
		try {
			pstmt = con.connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ReturnBook rb = new ReturnBook();
				rb.setBook_seq(rs.getInt("book_seq"));
				rb.setUser_seq(rs.getInt("user_seq"));
				rb.setBname(rs.getString("bname"));
				rb.setUname(rs.getString("uname"));
				rb.setDateofissue(rs.getDate("dateofissue"));
				rb.setDateofreturn(rs.getDate("dateofreturn"));
				list.add(rb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if ( rs != null ) try{rs.close();}catch(Exception e){}
		    if ( pstmt != null ) try{pstmt.close();}catch(Exception e){}
		    if ( conn != null ) try{conn.connection.close();}catch(Exception e){}
			
		}
		return list;
	}

}