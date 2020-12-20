package app.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import app.modeles.User;
import app.modeles.participation;
import config.Config;

public class ParticipationController {

	User user;
	Config DataBaseConn;
	 
	 Scanner scanner = new Scanner(System.in);
	 Scanner scanner1 = new Scanner(System.in);
	
	public ParticipationController() {
		
		DataBaseConn = new Config("jdbc:mysql://localhost/gottalent", "root", "0000");
	}
	
	  String categoriesRegex = "^[1-5]{1}$";
			
		/////////////////////add participation
			public void AddParti () throws SQLException {
				
				participation demande  = new participation();
				
				System.out.println("Enter votre ID :");
				
				Long iduser = scanner.nextLong();
				
				demande.setIduser(iduser);
				
				
				String sqlD = "select * from participation where user_id = '"+ iduser +"'";
	            PreparedStatement stmD = DataBaseConn.connect().prepareStatement(sqlD);
				ResultSet resD = stmD.executeQuery();
				if(resD.next()) {
				
				
			
				
				
				
				System.out.println("choisir votre categories id : \n 1-dance \n 2-comidia");
				
				Long cateid = scanner.nextLong(); 
				if(cateid==1 ||cateid==2 ||cateid==3 ||cateid==4 ||cateid==5 ||cateid==6 ) {
		        	  //correct email format
		          }else {
		        	  System.out.println("***********   Cette catégorie n'a pas été trouvée  ************");
		        	  AddParti();
		        	 
		          }
				  String tel = scanner.nextLine();
				
				
				demande.setCategoryID(cateid);
				
				String sql = "select * from participation where user_id = '"+ iduser +"' and id_category = '"+ cateid +"'";
				
				PreparedStatement stm = DataBaseConn.connect().prepareStatement(sql);
				
				ResultSet res = stm.executeQuery();
				
				if(res.next()) {
					
					long idu = res.getLong("user_id");
					
					long idc = res.getLong("id_category");
					
					if(idu == iduser && idc == cateid) {
						
						System.out.println("***************** Utilisateur déjà Participer dans cette catégorie *******************************");
						
						
					} 
				
				} else {
					
					System.out.println("Enter the Participation Description :");
					
					String descParti = scanner.next();
						
					demande.setDescParti(descParti);
						
					System.out.println("date début");
						
					String td = scanner1.next();
					
					demande.setTimeStart(td);
						
					System.out.println("date fin");
						
					String tf = scanner1.next();
					
					demande.setTimeEnd(tf);
						
					String sql1 = "insert into participation (user_id, id_category, description, show_start_time, show_end_time, attached_file, is_accepted) values('"+ iduser +"', '"+ cateid +"', '"+ descParti +"', '"+ td +"', '"+ tf+"', 'test', '0')";
						
					PreparedStatement stm1 = DataBaseConn.connect().prepareStatement(sql1);
						
					int row1 = stm1.executeUpdate();
						
						if(row1 > 0) {
							
							System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~>>> votre participation été ajouté <<<~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
							
							String sql3 = "select * from users where user_id = '"+ iduser +"'";
							
							java.sql.Statement stm3 = DataBaseConn.connect().createStatement();
							
							ResultSet res3 = stm3.executeQuery(sql3);
							
							if (res3.next()) {
								
								System.out.println("votre informations: \n Your id :"+res3.getString("user_id")+" \n Your firstName : "+res3.getString("first_name")+"\n Your LastName :"+res3.getString("last_name")+" \n Your Email:"+res3.getString("email")+"\n Your Phone : "+res3.getString("phone"));
							}
							else {System.out.println("********************* Id user utilisateur introuvable **********************");
							}
						
						}
					
				}
				
				
				
				
				}else {
					System.out.println("********************* Id user utilisateur introuvable **********************");
					AddParti ();
				}
				
			}
			
			
			
			
			
			
				
	}
