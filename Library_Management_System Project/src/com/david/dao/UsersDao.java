package com.david.dao;

import java.util.List;

import com.david.vo.Users;


public interface UsersDao {
	List<Users> selectList();
	
	Users selectone(int no);
	
	int insert(Users user);
	
	int update(Users user);
	
	int delete(int no);
}
