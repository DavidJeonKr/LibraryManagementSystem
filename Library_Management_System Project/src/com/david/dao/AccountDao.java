package com.david.dao;

import com.david.vo.Account;

public interface AccountDao {
	
	int insertid(Account account);
	
	int checkid(Account account);
}
