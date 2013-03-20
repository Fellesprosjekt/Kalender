package dbConnection;

import java.util.ArrayList;
import java.util.HashMap;

import org.joda.time.DateTime;

import appLogic.Appointment;
import appLogic.CalendarRow;
import appLogic.Employee;
import appLogic.Group;
import appLogic.Room;
import appLogic.User;
import dbConnection.*;
import exceptions.DateTimeException;
import exceptions.RoomBookedException;
import exceptions.RoomSizeException;


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
		String sql = String.format("SELECT * FROM AppInvitation WHERE AppID=%s",appId);
		ArrayList<HashMap<String,String>> posts = db.get(sql);
		ArrayList<User> participants = new ArrayList<User>();
		for(HashMap<String,String> post : posts){
			int userId = Integer.parseInt(post.get("UserID"));
			sql = String.format("SELECT UType FROM CalendarUser WHERE UserID=%s",userId);
			String type = db.get(sql).get(0).get("UType");
			
			participants.add((type.equals("Employee") ? Employee.getEmployee(userId) : Group.getGroup(userId)));
		}
		return participants;
	}
	
	private Room loadAppRoom(int appId){
		String sql = String.format("SELECT RoomID FROM Booking WHERE AppID=%s",appId);
		ArrayList<HashMap<String,String>> posts = db.get(sql);
		String roomId = posts.get(0).get("RoomID");
		return Room.getRoom(roomId);
	}
	
	
	public void loadAppointments(){
		String sql = "SELECT * FROM Calendar.Appointment";
		ArrayList<HashMap<String,String>> posts =db.get(sql);
		for(HashMap<String,String> post : posts){
			int appId = Integer.parseInt(post.get("AppID"));
			DateTime start = toDateTime(post.get("StartTime").substring(0,16));
			DateTime end = toDateTime(post.get("EndTime").substring(0,16));
			String description = post.get("Description");
			int leaderId = Integer.parseInt(post.get("LeaderID"));
			
			Employee leader = Employee.getEmployee(leaderId);
			Room room = loadAppRoom(appId);
			ArrayList<User> participants = loadAppParticipants(appId);
			
			try {
				Appointment a = new Appointment(appId, description, room, leader, participants, start, end);
				loadParticipantsStatus(a);
			} catch (DateTimeException e) {
				deleteAppointment(appId);
			} catch (RoomBookedException e) {
				deleteAppointment(appId);
			} catch (RoomSizeException e) {
				deleteAppointment(appId);
			}
		}
		System.out.println("Appointments loaded.");
	}
	
	private void loadParticipantsStatus(Appointment a){
		int appId = a.getId();
		String sql = String.format("SELECT * FROM AppInvitation WHERE AppID=%s",appId);
		ArrayList<HashMap<String,String>> posts =db.get(sql);
		for(HashMap<String,String> post : posts){
			int userId = Integer.parseInt(post.get("UserID"));
			sql =String.format("SELECT UType FROM CalendarUser WHERE UserID=%s",userId);
			String type = db.get(sql).get(0).get("UType");
			
			User u = (type.equals("Employee") ? Employee.getEmployee(userId) : Group.getGroup(userId));
			
			if(post.get("Confirmed").equals("0")) u.declineAppointment(a);
			else if(post.get("Confirmed").equals("1")) u.acceptAppointment(a);
		}
	}
	
	private void deleteAppointment(int id){
		db.send(String.format("DELETE FROM Calendar.Appointment WHERE AppID = %s", id));
	}
	
//	public static void main(String[] args) {
//		DBAppointments dba = new DBAppointments();
//		DBEmployees dbe = new DBEmployees();
//		DBGroups dbg = new DBGroups();
//		DBRooms dbr = new DBRooms();
//		
//		dbe.loadEmployees();
//		dbg.loadGroups();
//		dbr.loadRooms();
//		
//		dba.loadAppointments();
//		Employee leader = Employee.getEmployee(8);
//		System.out.println(leader.getInvitations());
//		for(CalendarRow cr : leader.getCalendar()){
//			System.out.println(cr.getAppointment());
//		}
//	}
}
