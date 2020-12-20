package app.controller;

import java.sql.SQLException;
import java.util.Random;
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

	//phone number regex
	  String phoneRegex = "^(\\+212|0)([ \\-_/]*)(\\d[ \\-_/]*){9}$";
	//email regex
	  String emilRegex = "^(.+)@(.+)$";
	
	
	
	

///////Add User
	
	public void AddUser() throws SQLException {
		Scanner reader = new Scanner(System.in);
		Scanner reader2 = new Scanner(System.in);
		Scanner reader3 = new Scanner(System.in);
		
		 
		  Random random = new Random();
          int id = (int)(random.nextDouble()*1000000000L);
		  System.out.print("Enter votre firstname : ");
		  String firstname= reader3.nextLine();
		  if(firstname.length() < 3) {
			  System.out.println("*********** FirstName format incorrect  ************");
			  AddUser();
		  }
		  System.out.print("Enter votre lastname : ");
		  String lastname= reader2.nextLine();
		  if(lastname.length() < 3) {
			  System.out.println("***********  LastName format incorrect  ***********");
			  AddUser();
		  }
		  System.out.print("Enter votre email : ");
	      String email = reader2.nextLine();
		  if(email.matches(emilRegex)) {
        	  //correct email format
          }else {
        	  System.out.println("***********  email format incorrect  ***********");
        	  AddUser();
        	 
          }
		  System.out.print("Enter votre tel ");
		  String tel = reader2.nextLine();
		  if(tel.matches(phoneRegex)) {
        	  //correct email format
          }else {
        	  System.out.println("***********   Phone format incorrect ************");
        	  AddUser();
        	 
          }
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
	     System.out.println("~~~~~~~~~~~~~~~~~~~~~~>>>  * votre inscription a été validée *  <<<~~~~~~~~~~~~~~~~~~~~~~");
	  
	}
	
	}	

	////Update User
	
	public void updateUser() throws SQLException {
		
		
		  Scanner reader = new Scanner(System.in);
		  System.out.println("Enter votre id ");
		  String ido = reader.nextLine();
		  long id = Long.parseLong(ido);
		  String sqlD = "select * from participation where user_id = '"+ id +"'";
          PreparedStatement stmD = DataBaseConn.connect().prepareStatement(sqlD);
			
			ResultSet resD = stmD.executeQuery();
			if(resD.next()) {
				
			
		  System.out.print("Enter votre firstname : ");
		  String fname= reader.nextLine();
		  if(fname.length() < 3) {
			  System.out.println("*********** FirstName format incorrect  ************");
			  AddUser();
		  }
		  System.out.print("Enter votre lastname : ");
		  String lname= reader.nextLine();
		  if(lname.length() < 3) {
			  System.out.println("***********  LastName format incorrect  ***********");
			  AddUser();
		  }
		  System.out.print("Enter votre email : ");
	      String email = reader.nextLine();
		  if(email.matches(emilRegex)) {
        	  //correct email format
          }else {
        	  System.out.println("***********  email format incorrect  ***********");
        	  AddUser();
        	 
          }
		  System.out.print("Enter votre tel ");
		  String tel = reader.nextLine();
		  if(tel.matches(phoneRegex)) {
        	  //correct email format
          }else {
        	  System.out.println("***********   Phone format incorrect ************");
        	  AddUser();
        	 
          }
          String sqlq =  "update users set first_name = '"+ fname +"', last_name = '"+ lname +"', email = '"+ email +"', phone = '"+ tel +"' where user_id = '"+ id +"'";
		                    
		  PreparedStatement statement = DataBaseConn.connect().prepareStatement(sqlq);
			
			statement.executeUpdate(sqlq);
			String sql2 = "select * from users where user_id = '"+ id +"'";
			
			java.sql.Statement stm2 = DataBaseConn.connect().createStatement();
			
			ResultSet res1 = stm2.executeQuery(sql2);
		
		    System.out.println("~~~~~~~~~~~~~~~~~~~~~~>>>  * Votre compte est mis à jour  *  <<<~~~~~~~~~~~~~~~~~~~~~~");
			while(res1.next()) {
				
				System.out.println("votre informations: \n Your id :"+res1.getString("user_id")+" \n Your firstName : "+res1.getString("first_name")+"\n Your LastName :"+res1.getString("last_name")+" \n Your Email:"+res1.getString("email")+"\n Your Phone : "+res1.getString("phone"));
				
			}

		///
			}else {System.out.println("********************* Id user utilisateur introuvable **********************");
			}
	}
	
	
	//Find user 
		
        public void findUserById () throws SQLException {
	    Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter votre id :");
		
		long idScan = scanner.nextLong();
		
		
		
	
		
		String sql2 = "select * from users where user_id = '"+ idScan +"'";
		
		java.sql.Statement stm2 = DataBaseConn.connect().createStatement();
		
		ResultSet res1 = stm2.executeQuery(sql2);
		
		if (res1.next()) {
			
			System.out.println("votre informations: \n Your id :"+res1.getString("user_id")+" \n Your firstName : "+res1.getString("first_name")+"\n Your LastName :"+res1.getString("last_name")+" \n Your Email:"+res1.getString("email")+"\n Your Phone : "+res1.getString("phone"));
			
		}
		else {System.out.println("********************* Id user utilisateur introuvable **********************");
		}
		}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
}

