package sms;

import java.io.*;

import java.util.InputMismatchException;




public class Start  {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void mainMenu() throws  InvalidInputException, NumberFormatException, IOException {
		try {
		System.out.println("Hello User Please Enter Your Name: \n");
		String user = input.readLine();
		System.out.println("Welcome To Student Management App. " + user+" !!");
		while(true) {
			System.out.println("");
			System.out.println("PRESS 1 to ADD student");
			System.out.println("PRESS 2 to DELETE student");
			System.out.println("PRESS 3 to DISPLAY student");
			System.out.println("PRESS 4 to UPDATE student");
			System.out.println("PRESS 5 to EXIT App");
				
			int choice = Integer.parseInt(input.readLine());
			switch(choice) {
			
				case 1:	//Add student
						System.out.println("\nEnter Student Details...");

						break;
						
				case 2:	//Delete student
						System.out.println("");
						deleteStudent();
						break;
						
				case 3:	//Display student
						StudentDao.showAllStudentRecords();
						break;
						
				case 4:	//Update student
				
						System.out.println("PRESS 1 to UPDATE name");
						System.out.println("PRESS 2 to UPDATE phone");
						System.out.println("PRESS 3 to UPDATE city");
						updateStudent();
						break;
				case 5: //Exit
		
						System.out.println("Thank You For Using Application...If You Enjoyed, Please Experience It Again!" + user);
						System.exit(0);
						break;
				
				default:
						System.out.println("Error! Please input only the number options available above!!!");                
				}		
			}
		}catch(InputMismatchException e) {
			 System.out.println("Please input only the number options available above!!!");
			 mainMenu();
		} 
	}

	//Add Student	
	public static void addStudent() throws InvalidInputException, IOException
		{
			System.out.println("\nEnter User Name: ");
			String name;
			name = input.readLine();
			if(name==""){
				throw new InvalidInputException("User Name cannot be empty");	
			}
			System.out.println("Enter User Phone: ");
			String phone = input.readLine();
			if(phone.length()!=10) {
				throw new InvalidInputException("Enter a valid phone number");
			}
			System.out.println("Enter User City: ");
			String city = input.readLine();
			if(city=="") {
				throw new InvalidInputException("City cannot be empty");
			}
			//create student object
			Student st = new Student(name,phone,city);
			boolean ans = StudentDao.insertStudentRecordToDB(st);
			if(ans) {
				System.out.println("Student record Inserted Successfully...");
				System.out.println("Student Record:" + st);
			}else {
				System.out.println("Some error Occured While Inserting...Please try Again!");
			}
			
	}
  
	//Delete Student
	public static void deleteStudent() {
		
			System.out.println("Enter Student ID To Delete: ");
			int userID;
			try {
				userID = Integer.parseInt(input.readLine());
				boolean setboolean = StudentDao.deleteStudentRecordFromDB(userID);
				if(setboolean) {
					System.out.println("Student Of ID " + userID + " Record Deleted... ");
				}else {
					//throw new InvalidInputException("No such record found");	
					System.out.println("Something Went Wrong.. Please try Again!");
				}
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}  
	}
  
	//Update Student
	public static void updateStudent() throws NumberFormatException, IOException {

			int val = Integer.parseInt(input.readLine());
			if(val == 1) {
				//Update Name
				System.out.println("Enter name to UPDATE...");
				String name = input.readLine();
				System.out.println("Enter ID to identify student!");
				int id = Integer.parseInt(input.readLine());
				Student st = new Student();
				st.setStudentName(name);
				boolean setboolean = StudentDao.updateStudentRecord(val,name,id,st);
				if(setboolean) {
					System.out.println("Student Name Updated Successfully...");
				}else {
					System.out.println("Something Went Wrong Please try Again!");
				}
			}
			else if(val == 2) {
				//Update Phone
				System.out.println("Enter phone to UPDATE...");
				String phone = input.readLine();
				System.out.println("Enter ID to identify student!");
				int id = Integer.parseInt(input.readLine());
				Student st = new Student();
				st.setStudentPhone(phone);
				boolean setboolean = StudentDao.updateStudentRecord(val,phone,id,st);
				if(setboolean) {
					System.out.println("Student Phone Updated Successfully...");
				}else {
					System.out.println("Something Went Wrong Please try Again!");
				}
			}
			else if(val == 3) {
				//Update city
				System.out.println("Enter city to UPDATE...");
				String city = input.readLine();
				System.out.println("Enter ID to identify student!");
				int id = Integer.parseInt(input.readLine());
				Student st = new Student();
				st.setStudentCity(city);
				boolean setboolean = StudentDao.updateStudentRecord(val,city,id,st);
				if(setboolean) {
					System.out.println("Student City Updated Successfully...");
				}else {
					System.out.println("Something Went Wrong Please try Again!");
				}
			}
			else {
				System.out.println("Hey You have not updated Anything... Please choose option Correctly!");
			}
	}

	public static void main(String[] args) throws IOException, InvalidInputException{		
			//Main method
				mainMenu();		
	}	
}

	

