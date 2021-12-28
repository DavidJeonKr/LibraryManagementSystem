package com.david.dao;

import java.util.List;

import com.david.vo.Book;
import com.david.vo.IssueBook;
import com.david.vo.ReturnBook;

public interface BookDao {
	
	
	List<Book> selectList();
	
	Book selectone(int no);
	
	
	int insert(Book book);
	
	int update(int book);
	
	int delete(int no);
	
	int updateissue(String book_seq, String user_seq, String bname, String uname);	
	
	List<IssueBook> select();
	
	int returnbook(ReturnBook returnBook);
	
	IssueBook selectIssueBook(int book_seq, int user_seq);
	
	void deleteIssue(int no);
	
	List<ReturnBook> selectReturnBooks();
}
