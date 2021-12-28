package com.david.dao;

import static com.david.ojdbc.OracleJdbc.*;

import oracle.jdbc.OracleDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
	Connection connection;
	Statement stmt;

	public Conn() {
		try {
			DriverManager.registerDriver(new OracleDriver());
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = connection.createStatement();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
