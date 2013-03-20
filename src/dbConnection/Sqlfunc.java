package dbConnection;

import java.sql.SQLException;
import java.util.ArrayList;

import org.joda.time.DateTime;

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
	
	
	private ArrayList<Employee> loadEmployees(){
		ArrayList<Employee> employees = new ArrayList<Employee>();
		db.get("SELECT * FROM Calendar.CalendarUser WHERE UType = 'Employee'");
		return null;
	}
	
	private int getAppointmentId(Appointment a) {
		return 0;
	}
	
	private int getEmpId() {
		return 0;
	}
	
	
	private int getUserId(User u) {
		return 0;
	}
	
	public void saveParticipant(Appointment a, User u){
		int aId = getAppointmentId(a);
		int uId = getUserId(u);
		db.send(String.format("INSERT INTO AppInvitation VALUES ('%s', '%s', null)",aId,uId));
	}
	
	public void createAppiontment(Appointment a) {
		DateTime start = a.getStart();
		DateTime end = a.getEnd();
		String desc = a.getDescription();
		Employee leader = a.getLeader();
		int lId=getEmpId();
		db.send(String.format("INSERT INTO Appointment VALUES ('?', '%s', '%s','%s', '%s')",start, end, desc, lId));
	}
	
	public void deleteParticipant(Appointment a, User u) {
		int aId = getAppointmentId(a);
		int uId = getUserId(u);
		db.send(String.format("DELETE FROM AppInvitation WHERE AppID = '%s' AND UserID = '%s')", aId, uId));
		}
	
	public void updateUserStatus (boolean status, Appointment a) {
		
	}
}
