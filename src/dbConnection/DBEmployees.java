package dbConnection;

import java.util.ArrayList;
import java.util.HashMap;

import exceptions.InvalidEmailException;
import exceptions.InvalidNameException;

import appLogic.Employee;

public class DBEmployees {
	Simpleconnect db;
	
	public DBEmployees(){
		db = new Simpleconnect("Calendar", "");
	}
	
	public ArrayList<Employee> loadEmployees(){
		ArrayList<Employee> employees = new ArrayList<Employee>();
		ArrayList<HashMap<String,String>> posts = db.get("SELECT * FROM Calendar.CalendarUser WHERE UType='Employee'");
		for(HashMap<String,String> post : posts){
			int id = Integer.parseInt(post.get("UserID"));
			String email = post.get("Email");
			String name = post.get("UName");
			try {
				Employee e = new Employee(id, name, email);
				employees.add(e);
			} catch (InvalidNameException e) {
				deleteEmployee(id);
			} catch (InvalidEmailException e) {
				deleteEmployee(id);
			}
		}
		return employees;
	}
	
	public void deleteEmployee(int id){
		db.send(String.format("DELETE FROM Calendar.CalendarUser WHERE UserID = %s", id));
	}
}
