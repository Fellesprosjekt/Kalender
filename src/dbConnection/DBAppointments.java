package dbConnection;

import org.joda.time.DateTime;

import appLogic.Appointment;
import appLogic.Employee;
import appLogic.User;

public class DBAppointments {
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
		db.send(String.format("DELETE FROM AppInvitation WHERE (AppID = '%s' AND UserID = '%s'))", aId, uId));
		}
	
	public void updateUserStatus (boolean status, Appointment a, User u) {
		int aId = getAppointmentId(a);
		int uId = getUserId(u);
		db.send(String.format("Update AppInvitation SET Confirmed = %s WHERE (AppID = '%s' AND UserID = '%s'))", status, aId, uId));
	}
	
	public void updateAppDesc(Appointment a, String desc) {
		int aId = getAppointmentId(a);
		db.send(String.format("Update AppInvitation SET Description = %s WHERE AppID = '%s'", desc, aId));
	}
	
	public void updateAppointmentStart(Appointment a, DateTime start) {
		int aId = getAppointmentId(a);
		db.send(String.format("Update AppInvitation SET startTime = %s WHERE AppID = '%s'", start, aId));
	}
	
	public void updateAppointmentEnd(Appointment a, DateTime end) {
		int aId = getAppointmentId(a);
		db.send(String.format("Update AppInvitation SET endTime = %s WHERE AppID = '%s'", end, aId));
	}
	
	public void removeAppointment(Appointment a) {
		int aId = getAppointmentId(a);
		db.send(String.format("DELETE FROM Appointment WHERE AppID = '%s')", aId);
	}
	
}
