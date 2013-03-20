import java.sql.SQLException;

import appLogic.Appointment;
import appLogic.User;

import exceptions.InvalidEmailException;
import exceptions.InvalidNameException;


public class Maintesting {
	
	Simpleconnect a= new Simpleconnect(null);
	
	public void saveParticipant(){
		String aId = "anniken";
		String uId = "stud.ntnu.no";
		a.send(String.format("INSERT INTO Calendaruser VALUES (null, '%s', '%s')", aId, uId));
	}
	
public static void main(String args[]) throws ClassNotFoundException, SQLException, InvalidNameException, InvalidEmailException{
		
	
	Simpleconnect a= new Simpleconnect(null);
	//a.send("Create table Calendaruser (ID int(4), Name varchar(20), Email varchar(30))");
	//a.rs("select * from calendaruser");
//		Sqlfunc a= new Sqlfunc();
//		a.createEmployee("Steffen", "email@post.com");
	
		Maintesting m = new Maintesting();
		m.saveParticipant();
	}	

}
