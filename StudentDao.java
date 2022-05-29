package sms;


import java.sql.*;


public class StudentDao {
	public static boolean insertStudentRecordToDB(Student st) {
		boolean setboolean = false;
		try {
			Connection con = DBConnection.createconnection();
			String query = "insert into students(sname,sphone,scity) values(?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			//set the value of parameters
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			
			//execute..
			pstmt.executeUpdate();
			
			setboolean = true;
			
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return setboolean;
	}
	
	public static boolean deleteStudentRecordFromDB(int userID)  {
		// TODO Auto-generated method stub
		boolean setboolean = false;
		try {
			Connection con = DBConnection.createconnection();
			String query = "delete from students where sid=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			//set the value of parameters
			pstmt.setInt(1, userID);
			
			//execute..
			pstmt.executeUpdate();
			setboolean = true;
		
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return setboolean;
	}


	public static void showAllStudentRecords() {
		// TODO Auto-generated method stub
		
		try {
			Connection con = DBConnection.createconnection();
			String query = "select * from students";
			Statement st = con.createStatement();
			ResultSet set = st.executeQuery(query);
			
			while(set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString("scity");
				
				System.out.println("Student ID: " + id + " \n Student Name: " + name + " \nStudent Phone: " + phone + " \nStudent city: " + city);
				System.out.println("----------------------------------------------");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
	}


	public static boolean updateStudentRecord(int val,String toUpdate,int id,Student st) {
		// TODO Auto-generated method stub
		boolean setboolean = false;
		
		try {
			  Connection con = DBConnection.createconnection();
			 if(val == 1) {
					//Update Name
					
						String query = "update students set sname=? where sid=?";
						PreparedStatement pstmt = con.prepareStatement(query);
						pstmt.setString(1, toUpdate);
						pstmt.setInt(2, id);
						
						//execute..
						pstmt.executeUpdate();
						setboolean = true;
				}
				else if(val == 2) {
					//Update Phone
					String query = "update students set sphone=? where sid=?";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setString(1, toUpdate);
					pstmt.setInt(2, id);
					
					//execute..
					pstmt.executeUpdate();
					setboolean = true;
				}
				else if(val == 3) {
					//Update City
					String query = "update students set scity=? where sid=?";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setString(1, toUpdate);
					pstmt.setInt(2, id);
					
					//execute..
					pstmt.executeUpdate();
					setboolean = true;
				}
				else {
					
				}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return setboolean;
	}
}
