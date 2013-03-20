package dbConnection;

import java.util.ArrayList;
import java.util.HashMap;

import org.joda.time.DateTime;

import appLogic.Appointment;
import appLogic.Employee;
import appLogic.Group;
import appLogic.User;
import dbConnection.*;


public class DBAppointments {
	
	Simpleconnect db = new Simpleconnect("Calendar", "");
	
	
	public void saveParticipant(Appointment a, User u){
		int aId = a.getId();
		int uId = u.getId();
		db.send(String.format("INSERT INTO AppInvitation VALUES ('%s', '%s', null)",aId,uId));
	}
	
	public void createAppiontment(Appointment a) {
		DateTime start = a.getStart();
		DateTime end = a.getEnd();
		String desc = a.getDescription();
		int lId = a.getLeader().getId();
		db.send(String.format("INSERT INTO Appointment VALUES ('?', '%s', '%s','%s', '%s')",start, end, desc, lId));
	}
	
	public void deleteParticipant(Appointment a, User u) {
		int aId = a.getId();
		int uId = u.getId();
		db.send(String.format("DELETE FROM AppInvitation WHERE (AppID = '%s' AND UserID = '%s')", aId, uId));
		}
	
	public void updateUserStatus (boolean status, Appointment a, User u) {
		int aId = a.getId();
		int uId = u.getId();
		db.send(String.format("UPDATE Calendar.AppInvitation SET Confirmed = %s WHERE (AppID = '%s' AND UserID = '%s')", status, aId, uId));
	}
	
	public void updateAppDesc(Appointment a, String desc) {
		int aId = a.getId();
		db.send(String.format("UPDATE Calendar.AppInvitation SET Description = %s WHERE AppID = '%s'", desc, aId));
	}
	
	public void updateAppointmentStart(Appointment a, DateTime start) {
		int aId = a.getId();
		db.send(String.format("UPDATE Calendar.AppInvitation SET startTime = %s WHERE AppID = '%s'", start, aId));
	}
	
	public void updateAppointmentEnd(Appointment a, DateTime end) {
		int aId = a.getId();
		db.send(String.format("UPDATE Calendar.AppInvitation SET endTime = %s WHERE AppID = '%s'", end, aId));
	}
	
	public void deleteAppointment(Appointment a) {
		int aId = a.getId();
		db.send(String.format("DELETE FROM Calendar.Appointment WHERE AppID = '%s'", aId));
	}
	
	private DateTime toDateTime(String datetime){
		String[] temp = datetime.split(" ");
		String[] date = temp[0].split("-");
		String[] time = temp[1].split(":");
		ArrayList<Integer> dt = new ArrayList<Integer>();
		for(int i=0;i<3;i++){
			dt.add(Integer.parseInt(date[i]));
		}
		for(int i=0;i<2;i++){
			dt.add(Integer.parseInt(time[i]));
		}
		return new DateTime(dt.get(0),dt.get(1),dt.get(2),dt.get(3),dt.get(4),0);
	}
	
	private ArrayList<User> loadAppParticipants(int appId){
		String sql = String.format("SELECT user.UserID, user.UType FROM AppInvitation AS inv, CalendarUser AS user WHERE inv.UserID=user.UserID AND inv.AppID = %s",appId);
		ArrayList<HashMap<String,String>> posts = db.get(sql);
		ArrayList<User> participants = new ArrayList<User>();
		for(HashMap<String,String> post : posts){
			int userId = Integer.parseInt(post.get("UserID"));
			if(post.get("UType").equals("Employee")) 
				participants.add(Employee.getEmployee(userId));
			else participants.add(Group.getGroup(userId));
		}
		return participants;
	}
	
	private Room loadAppRoom
	
	
	public void loadAppointments(){
		String sql = "SELECT * FROM Calendar.Appointment";
		ArrayList<HashMap<String,String>> posts =db.get(sql);
		for(HashMap<String,String> post : posts){
			int appId = Integer.parseInt(post.get("AppId"));;
			DateTime start = toDateTime(post.get("StartTime").substring(0,16));
			DateTime end = toDateTime(post.get("EndTime").substring(0,16));
			String description = post.get("Description");
			int leaderId = Integer.parseInt(post.get("LeaderID"));
			Employee leader = Employee.getEmployee(leaderId);
			ArrayList<User> participants = loadAppParticipants(appId);
			
//			new Appointment(description, room, leader, participants, start, end)
		}
	}
	
	public static void main(String[] args) {
		DBAppointments dba = new DBAppointments();
		dba.loadAppointments();
	}
}
