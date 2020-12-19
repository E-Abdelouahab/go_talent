package app.controller;

import java.sql.SQLException;
import java.util.Scanner;



import app.modeles.User;
import config.Config;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UserController extends User {
	
	public UserController(long id, String firstname, String lastname, String email, String tel) {
		super(id, firstname, lastname, email, tel);
		// TODO Auto-generated constructor stub
	}
	
	
	User user;
	Config DataBaseConn;
	
	 Scanner scanner = new Scanner(System.in);
	public UserController() {
		
		
			DataBaseConn = new Config("jdbc:mysql://localhost/gottalent", "root", "0000");

 }

	
	
	

///////Add User
	
	public void AddUser() throws SQLException {
		Scanner reader = new Scanner(System.in);
		Scanner reader2 = new Scanner(System.in);
		Scanner reader3 = new Scanner(System.in);
		
		 System.out.print("Enter votre user_id ");
		  int id= reader.nextInt();
		  System.out.print("Enter votre firstname ");
		  String firstname= reader3.nextLine();
		  System.out.print("Enter votre lastname ");
		  String lastname= reader2.nextLine();
		  System.out.print("Enter votre email ");
		  String email = reader2.nextLine();
		  System.out.print("Enter votre tel ");
		  String tel = reader2.nextLine();
		  UserController user = new UserController(id,firstname,lastname,email,tel); 
		  String sql = "INSERT INTO users (user_id, first_name, last_name, email,phone) VALUES (?, ?, ?,?,?)";
	 
	    PreparedStatement statement = DataBaseConn.connect().prepareStatement(sql);
    	statement.setLong(1, id);
	    statement.setString(2, firstname);
	    statement.setString(3, lastname);
	    statement.setString(4, email);
	    statement.setString(5, tel);
	    int rowsInserted = statement.executeUpdate();
	    if (rowsInserted > 0) {
	     System.out.println("votre inscription a été validée");
	  
	}
	
	}	

	////Update User
	
	public void updateUser() throws SQLException {
		
		
		  Scanner reader = new Scanner(System.in);
		  System.out.println("Enter votre user_id ");
		  String ido = reader.nextLine();
		  long id = Long.parseLong(ido);
		  System.out.println("Enter votre firstname");
		  String fname = reader.nextLine();
		  System.out.println("Enter votre lastname ");
		  String lname = reader.nextLine();
		  System.out.println("Enter your email:");
		  String email = reader.nextLine();
		  System.out.println("Enter votre tel");
		  String tel = reader.nextLine();
          String sqlq =  "update users set first_name = '"+ fname +"', last_name = '"+ lname +"', email = '"+ email +"', phone = '"+ tel +"' where user_id = '"+ id +"'";
		                    
		  PreparedStatement statement = DataBaseConn.connect().prepareStatement(sqlq);
			
			statement.executeUpdate(sqlq);
		 
		
		    System.out.println("Your account is updated");

		
	}
	
	
	//Find user 
		
        public void findUserById () throws SQLException {
	    Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the User ID to Update :");
		
		long idScan = scanner.nextLong();
		
		
		
	
		
		String sql2 = "select * from users where user_id = '"+ idScan +"'";
		
		java.sql.Statement stm2 = DataBaseConn.connect().createStatement();
		
		ResultSet res1 = stm2.executeQuery(sql2);
		
		while(res1.next()) {
			
			System.out.println("Your Informations are : " + res1.getLong("user_id")+" "+res1.getString("first_name")+" "+res1.getString("last_name")+" "+res1.getString("email")+" "+res1.getString("phone"));
			
		}
		}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
}

