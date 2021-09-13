package com.linhkien.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

		public static Connection getJDBCConnection() throws ClassNotFoundException {
			Connection connection = null;
			System.out.println("************JDBC Start***********");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String user = "root";
				String pass = "";
				String url = "jdbc:mysql://localhost:3306/linhkienjava?useUnicode=true&characterEndcoding=UTF-8";

				connection = DriverManager.getConnection(url, user, pass);
				System.out.println("************JDBC thanh cong***********");
				// crate statement
	            // Statement stmt = connection.createStatement();
	            // get data from table 'student'
	            // ResultSet rs = stmt.executeQuery("select * from Product");
	            // show data
	            // while (rs.next()) {
	            //     System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5));
	            // }
			} catch (SQLException ex) {
				System.out.println("************JDBC Failed***********");
				ex.printStackTrace();
			}
			//System.out.println("************return connection***********");
			//System.out.println(connection);
			return connection;
	}

}
