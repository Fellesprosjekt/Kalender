package dbConnection;

import java.sql.SQLException;
import java.util.ArrayList;

import appLogic.Appointment;
import appLogic.Employee;
import appLogic.User;
import exceptions.InvalidEmailException;
import exceptions.InvalidNameException;


public class Sqlfunc {
	
	public Simpleconnect db= new Simpleconnect("");
	
	
	
	public Sqlfunc(){
		
		
	}
	
	public  void  createEmployee(String name, String email) throws ClassNotFoundException, SQLException, InvalidNameException, InvalidEmailException
	{
		db.send("INSERT INTO `calendar`.`calendaruser` (`Email`, `UName`, `UType`) VALUES ('"+email+"', '"+name+"', 'Employee')");
//		ResultSet res=db.rs("");	
		
		
		//INSERT INTO `calendar`.`calendaruser` (`Email`, `UName`, `UType`) VALUES ('ste@ste', 'ewijioew', 'Employee');

	 
		//Employee e= new Employee(5,name, email);
		
		
		//return e;
	}
	
	
	private int getAppointmentId(Appointment a) {
		return 0;
	}
	
	
	private int getUserId(User u) {
		return 0;
	}
	
	private void saveParticipant(Appointment a, User u){
		int aId = getAppointmentId(a);
		int uId = getUserId(u);
		db.send(String.format("INSERT INTO AppInvitation VALUES ('%s', '%s', null)",aId,uId));
	}
	
	private ArrayList<Employee> loadEmployees(){
		ArrayList<Employee> employees = new ArrayList<Employee>();
		db.get("SELECT * FROM Calendar.CalendarUser WHERE UType = 'Employee'");
		return null;
	}
}
