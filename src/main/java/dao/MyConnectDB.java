package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
SQL> CREATE DATABASE logindb;



 */

public class MyConnectDB {
	public static String sqlDB;

	//localhost: là địa chỉ nội bộ
	//jdbc:mysql://localhost:3306/TableName?autoReconnect=true&useSSL=false
	static final String DB_URL = "jdbc:mysql://localhost/"; //Tomcat và Mysql on the same computer
	// jdbc:mysql://192.168.15.25:3306/yourdatabase
	//Make sure there is no firewall blocking the access to port 3306

	//  Database credentials
	static final String USER = "root"; //root
	static final String PASS = "123456789"; //123456789



	private MyConnectDB() {
		super();
		// =========================for Microsoft SQL
		//			sqlDB = "jdbc:sqlserver://shopphone.database.windows.net:1433;database=sqlshop;user=admin0107@shopphone;password=ABCDabcd0107;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30";
	}
	
	public static MyConnectDB getNewInstance(){
		return new MyConnectDB();
	}

	public static  Connection connect() throws Exception{
		try {
			Connection connect;
			/*          	
                //for Microsoft SQL
   			    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");			
				Connection connect = DriverManager.getConnection(sqlDB);
			 */

			//============================= for MySQL server =====================
			String databaseName = "logindb";
			String sqlOption = "?autoReconnect=true&useSSL=false";
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connect = DriverManager.getConnection(DB_URL+databaseName+sqlOption,USER,PASS); 
			return connect;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public void insertSql(String sql) throws Exception{
		Connection connect =connect();
		Statement stmt = connect.createStatement();
		stmt.executeUpdate(sql);
	}
	public ResultSet selectSql(String sql) throws Exception{
		Connection connect =connect();
		Statement stmt = connect.createStatement();
		ResultSet rs=	stmt.executeQuery(sql);
		return rs;
	}


	public PreparedStatement getPreparedStatement(String sql) throws SQLException, Exception{
		return connect().prepareStatement(sql);
	}

	public static void main(String[] args) throws Exception {
		System.out.println(new MyConnectDB().connect());
	}
}
