package dbConnection;

import java.sql.*;
import java.util.Iterator;

public class Simpleconnect {

	String dbUrl = "jdbc:mysql://localhost:3306/test";
	String dbClass = "com.mysql.jdbc.Driver";
	String operation;
	String brukernavn="root";
	String passord;
	//her trenger man sitt eget passord


	public Simpleconnect(String passord){
		this.passord = passord;
		//passordet man bruker for � koble til sin lokale DB



	}
	//Skal noe sendes til db, bruk sql kommando som message
	public void send(String message){
		connect(message,"up");
	}
	

	//Skal du hente bruk get, med sql kommando
	public void get(String message1){
		connect(message1,"ned");



	}
	
	public ResultSet rs(String message){
		ResultSet rs=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection (dbUrl,brukernavn,passord);
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(message);
			stmt.addBatch(message);
			
			
			con.close();
			return rs;
			
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
				return rs;
			}

			catch(SQLException e) {
				e.printStackTrace();
				return rs;
			}
		
	}
	
	public ResultSetMetaData rsmd(String message){
		ResultSetMetaData rsmd=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection (dbUrl,brukernavn,passord);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(message);
			stmt.addBatch(message);
			rsmd = rs.getMetaData();
			
			con.close();
			return rsmd;
			
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
				return rsmd;
			}

			catch(SQLException e) {
				e.printStackTrace();
				return rsmd;
			}
		
		
	}



	public void connect(String oprasjon, String direction){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection (dbUrl,brukernavn,passord);
			Statement stmt = con.createStatement();

			if (direction=="up"){
				stmt.executeUpdate(oprasjon);
				
				System.out.println("Sendt");
				
			}
			else{
				ResultSet rs = stmt.executeQuery(oprasjon);
				stmt.addBatch(oprasjon);
				//System.out.println(rs.getMetaData());




				ResultSetMetaData rsmd = rs.getMetaData();
				int noc = rsmd.getColumnCount();
				System.out.println("Number of col "+noc);
				//It shows the number of columns

				System.out.println("Tablename"+rsmd.getTableName(1));
				for (int i = 1; i <= noc; i++) {
					System.out.print(rsmd.getColumnName(i)+"\t\t");	
				}
				System.out.println();
				System.out.println("____________________");
				while (rs.next()) {
					
					for (int i = 1; i <= noc; i++) {
						
						System.out.print(rs.getString(i)+"\t\t");
						

					}
					System.out.println();

					//System.out.println(rs.getString(2));
					//System.out.println(String.format("%s %s",rs.getString(1),rs.getString(2)));
				} //end while

			}
			con.close();

		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	
}
