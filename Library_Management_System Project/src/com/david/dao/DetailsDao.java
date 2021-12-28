package com.david.dao;

import java.util.List;

import com.david.vo.Book;
import com.david.vo.Users;

public interface DetailsDao {
	List<Book> selectBook();
	
	int deleteBook(int no);
	
	List<Users> selectUsers();
	
	Users selectuserone(int no);
	
	int deleteUser(int no);
}
