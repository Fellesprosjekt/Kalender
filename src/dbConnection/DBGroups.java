package dbConnection;

import java.util.ArrayList;
import java.util.HashMap;

import appLogic.Group;
import exceptions.InvalidEmailException;
import exceptions.InvalidNameException;

public class DBGroups {
	Simpleconnect db;
	
	public DBGroups(){
		db = new Simpleconnect("Calendar", "");
	}
	
	public ArrayList<Group> loadGroups(){
		ArrayList<Group> groups = new ArrayList<Group>();
		ArrayList<HashMap<String,String>> posts = db.get("SELECT * FROM Calendar.CalendarUser WHERE UType='Group'");
		for(HashMap<String,String> post : posts){
			int id = Integer.parseInt(post.get("UserID"));
			String email = post.get("Email");
			String name = post.get("UName");
			try {
				Group g = new Group(id, name, email);
				loadGroupMembers(g);
				groups.add(g);
			} catch (InvalidNameException e) {
				deleteGroup(id);
			} catch (InvalidEmailException e) {
				deleteGroup(id);
			}
		}
		return groups;
	}
	
	public void loadGroupMembers(Group g){
		int id = g.getId();
		String query = String.format("SELECT (UserID) FROM Calendar.CalendarUser, Calendar.Groupmember WHERE UserID=EmpID AND GroupID=%s",id);
		ArrayList<HashMap<String,String>> posts = db.get(query);
	}
	
	public void deleteGroup(int id){
		db.send(String.format("DELETE FROM Calendar.CalendarUser WHERE UserID = %s", id));
	}
}
