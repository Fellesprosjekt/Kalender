package dbConnection;

import java.util.ArrayList;
import java.util.HashMap;

import exceptions.InvalidEmailException;
import exceptions.InvalidNameException;

import appLogic.Employee;

public class DBEmployees {
	Simpleconnect db;
	
	public DBEmployees(){
		db = new Simpleconnect("Calendar", "SklSkl91");
	}
	
	public void loadEmployees(){
		ArrayList<HashMap<String,String>> posts = db.get("SELECT * FROM CalendarUser WHERE UType='Employee'");
		for(HashMap<String,String> post : posts){
			int id = Integer.parseInt(post.get("UserID"));
			String email = post.get("Email");
			String name = post.get("UName");
			try {
				new Employee(id, name, email);
			} catch (InvalidNameException e) {
				deleteEmployee(id);
			} catch (InvalidEmailException e) {
				deleteEmployee(id);
			}
		}
	}
	
	private void deleteEmployee(int id){
<<<<<<< HEAD
		db.send(String.format("DELETE FROM CalendarUser WHERE UserID = %s", id));
=======
		
		db.send(String.format("DELETE FROM Calendar.CalendarUser WHERE UserID = %s", id));
>>>>>>> b86ffb895537671f261ba3041d3b019b68156789
	}
}
