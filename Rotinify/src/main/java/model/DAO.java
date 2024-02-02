package model;

import java.sql.*;

public class DAO {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/rotinify";
	private String user = "root";
	private String password = "";
	
	public Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void TestConnection() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
