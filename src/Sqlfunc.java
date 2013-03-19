import java.sql.SQLException;

import appLogic.Employee;
import exceptions.InvalidEmailException;
import exceptions.InvalidNameException;


public class Sqlfunc {
	
	public Simpleconnect sp= new Simpleconnect("SklSkl91");
	
	
	
	public Sqlfunc(){
		
		
	}
	
	public  void  createEmployee(String name, String email) throws ClassNotFoundException, SQLException, InvalidNameException, InvalidEmailException
	{
		sp.send("INSERT INTO `calendar`.`calendaruser` (`Email`, `UName`, `UType`) VALUES ('"+email+"', '"+name+"', 'Employee')");
		ResultSet res=sp.rs("")	
		
		
		//INSERT INTO `calendar`.`calendaruser` (`Email`, `UName`, `UType`) VALUES ('ste@ste', 'ewijioew', 'Employee');

	 
		//Employee e= new Employee(5,name, email);
		
		
		//return e;
	}
	
	
		
	
	
	
	
	

}
