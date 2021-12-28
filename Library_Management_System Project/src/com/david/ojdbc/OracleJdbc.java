package com.david.ojdbc;

public interface OracleJdbc {
	// Oracle DB 접속 주소/접속 방식
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	// Oracle DB 접속 사용자 이름
	String USER = "scott";
	// Oracle DB 접속 비밀번호
	String PASSWORD = "tiger";
	
	
}
