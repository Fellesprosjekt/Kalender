import java.sql.SQLException;

import exceptions.InvalidEmailException;
import exceptions.InvalidNameException;


public class Maintesting {
	
	
	
public static void main(String args[]) throws ClassNotFoundException, SQLException, InvalidNameException, InvalidEmailException{
		
	
	Simpleconnect a= new Simpleconnect("SklSkl91");
	a.rs("select * from calendaruser");
//		Sqlfunc a= new Sqlfunc();
//		a.createEmployee("Steffen", "email@post.com");
		
	}
	

}
