package dbConnection;

import java.util.ArrayList;
import java.util.HashMap;

import appLogic.Employee;
import appLogic.Group;
import exceptions.InvalidEmailException;
import exceptions.InvalidNameException;

public class DBGroups {
	Simpleconnect db;
	
	public DBGroups(){
		db = new Simpleconnect("Calendar", "");
	}
	
	public void loadGroups(){
		ArrayList<HashMap<String,String>> posts = db.get("SELECT * FROM Calendar.CalendarUser WHERE UType='Group'");
		for(HashMap<String,String> post : posts){
			int id = Integer.parseInt(post.get("UserID"));
			String email = post.get("Email");
			String name = post.get("UName");
			try {
				Group g = new Group(id, name, email);
				loadGroupMembers(g);
			} catch (InvalidNameException e) {
				deleteGroup(id);
			} catch (InvalidEmailException e) {
				deleteGroup(id);
			}
		}
	}
	
	private void loadGroupMembers(Group g){
		int groupId = g.getId();
		String query = String.format("SELECT (UserID) FROM Calendar.CalendarUser, Calendar.Groupmember WHERE UserID=EmpID AND GroupID=%s",groupId);
		ArrayList<HashMap<String,String>> posts = db.get(query);
		for(HashMap<String,String> post : posts){
			int empId = Integer.parseInt(post.get("UserID"));
			Employee e = Employee.getEmployee(empId);
			if(e != null) g.addMember(e);
		}
	}
	
	private void deleteGroup(int id){
		db.send(String.format("DELETE FROM Calendar.CalendarUser WHERE UserID = %s", id));
	}
	
//	public static void main(String[] args) {
//		DBGroups dbg = new DBGroups();
//		DBEmployees dbe = new DBEmployees();
//		
//		dbe.loadEmployees();
//		dbg.loadGroups();
//		
//		Group g = Group.groups.get(0);
//		for(Employee e : g.getMembers()){
//			System.out.println(e.toString());
//		}
//	}
}
