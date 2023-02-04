package com.other.delete;

import java.sql.SQLException;

public class Error {

	public static void err() throws SQLException {
		
		try {
			throw new SQLException("ERR");
		} finally {
			
			System.out.println("Finally");
		}
//		throw new SQLException("ERR");
//		System.out.println("ERR");
	}
	
	public static void err2() {
		
		try {
			throw new SQLException("ERR");
		} catch(SQLException e) {
			
			System.out.println("Finally");
		}
	}
	
	public static void main(String[] args) {
		
		try {
			
			err();
		} catch(SQLException e) {
			
			System.out.println(e.getMessage());
		}
	}

}
