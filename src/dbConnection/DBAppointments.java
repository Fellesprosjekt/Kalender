package dbConnection;

import java.util.ArrayList;
import java.util.HashMap;

import org.joda.time.DateTime;

import appLogic.Appointment;
import appLogic.Employee;
import appLogic.User;
import dbConnection.*;


public class DBAppointments {
	
	Simpleconnect db = new Simpleconnect("test", null);
	
	
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
		db.send(String.format("UPDATE AppInvitation SET Confirmed = %s WHERE (AppID = '%s' AND UserID = '%s')", status, aId, uId));
	}
	
	public void updateAppDesc(Appointment a, String desc) {
		int aId = a.getId();
		db.send(String.format("Update AppInvitation SET Description = %s WHERE AppID = '%s'", desc, aId));
	}
	
	public void updateAppointmentStart(Appointment a, DateTime start) {
		int aId = a.getId();
		db.send(String.format("Update AppInvitation SET startTime = %s WHERE AppID = '%s'", start, aId));
	}
	
	public void updateAppointmentEnd(Appointment a, DateTime end) {
		int aId = a.getId();
		db.send(String.format("Update AppInvitation SET endTime = %s WHERE AppID = '%s'", end, aId));
	}
	
	public void deleteAppointment(Appointment a) {
		int aId = a.getId();
		db.send(String.format("DELETE FROM Appointment WHERE AppID = '%s'", aId));
	}
	
	public Appointment getAppointment(int id) {
		ArrayList<HashMap<String,String>>app=db.get(String.format("SELECT * FROM Appointment WHERE AppID = '%s'", id));
		
	}
	
	
	
}
