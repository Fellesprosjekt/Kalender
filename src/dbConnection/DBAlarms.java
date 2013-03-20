package dbConnection;

import java.util.ArrayList;
import java.util.HashMap;


import appLogic.Appointment;
import appLogic.Alarm;
import appLogic.Employee;
import appLogic.Room;
import exceptions.DateTimeException;
import exceptions.InvalidAlarmException;

import org.joda.time.DateTime;

import appLogic.Room;
public class DBAlarms {
	private Simpleconnect db;

	public DBAlarms(){
		db = new Simpleconnect("Calendar", "");
	}

	public void loadAlarms(){
		for(Employee e : Employee.employees){
			int empId = e.getId();
			String sql = String.format("SELECT * FROM Alarm WHERE EmpID=%s", empId);
			ArrayList<HashMap<String,String>> posts = db.get(sql);

			for(HashMap<String,String> post : posts){
				String label=(post.get("Label"));
				int offset=Integer.parseInt(post.get("AlarmTime"));
				int appId = Integer.parseInt(post.get("AppID"));
				Appointment a = e.getAppointment(appId);
				if(a!=null){
					Alarm alarm = new Alarm(label, a, offset);
					try {
						e.addAlarm(alarm);
					} catch (InvalidAlarmException e1) {
						e.removeAlarm(alarm);
						deleteAlarm(empId,appId,offset);
					}
				}
			}
		}
	}

	private void deleteAlarm(int empId, int appId, int offset){
		db.send(String.format("DELETE FROM Alarm WHERE AppID = %s, EmpID=%s, AlarmTime=%s", empId,appId,offset));
	}

	public void addAlarm(int appId, int empId, int offset, String label) {
		db.send(String.format("INSERT INTO Alarm VALUES ('%s','%s','%s','%s)",appId,empId,offset,label));
	}

//	public static void main(String args[]){
//		DBEmployees e= new DBEmployees();
//		DBGroups dbg = new DBGroups();
//		DBRooms dbr = new DBRooms();
//		DBAppointments ale = new DBAppointments();
//		DBAlarms a= new DBAlarms();
//		
//		
//		e.loadEmployees();
//		dbg.loadGroups();
//		dbr.loadRooms();
//		ale.loadAppointments();
//		a.loadAlarms();	
//		for(Employee e1 : Employee.employees){
//			for(Alarm a1 : e1.getAlarms()){
//				System.out.println(a1.getLabel());
//			}
//		}
//	}

	//removeAlarm(a.getId(), currentUser.getId(), alarm.getTime());

}
