package sms;

import java.sql.*;

public class DBConnection {
	static Connection con;
	public static Connection createconnection() {
		
		
			
			//load the driver
			try {
				Class.forName("com.mysql.jdbc.Driver");

				//create the Connection

				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_manage", "root", "Hema@3451");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		return con;
		
	
	}
}
