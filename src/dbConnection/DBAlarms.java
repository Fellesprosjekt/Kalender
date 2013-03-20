package dbConnection;

import java.util.ArrayList;
import java.util.HashMap;


import appLogic.Appointment;
import appLogic.Alarm;
import appLogic.Employee;
import appLogic.Room;
import exceptions.DateTimeException;
import org.joda.time.DateTime;

import appLogic.Room;
public class DBAlarms {


	public Simpleconnect db= new Simpleconnect("calendar","SklSkl91");

	public DBAlarms(){

	}

	public void loadAlarms(){
		System.out.println("kjører loadAlarm");

		ArrayList<HashMap<String,String>> alarms = db.get("SELECT * FROM Calendar.alarm");
		for(Employee e : Employee.employees){
			System.out.println("emp");

			for(HashMap<String,String> alarm : alarms){
				String UID = (alarm.get("EmpID"));
				System.out.println("alarm");

				if(Integer.parseInt(UID)==e.getId()){
					String label=(alarm.get("Label"));
					int offset=Integer.parseInt(alarm.get("AlarmTime"));
					String appoint = alarm.get("AppID");
					Appointment a=e.getAppointment(appoint);
					new Alarm(label, a, offset);
					
					System.out.println("lagt til appointment "+appoint+" for bruker" +
							" "+UID);
				}

			}
			//ArrayList<HashMap<String,String>> users = db.get("SELECT * FROM Calendar.calendaruser");
		}
	}






	public void addAlarm(int AppointmentID, int UserID, int offsetMins, String label) {
		db.send("INSERT INTO `calendar`.`alarm` " +
				"(`AppID`, `EmpID`, `AlarmTime`, `Label`) " +
				"VALUES ('"+AppointmentID+"', '"+UserID+"', '"+offsetMins+"', '"+label+"')");



		//INSERT INTO `calendar`.`alarm` (`AppID`, `EmpID`, `AlarmTime`, `Label`) VALUES ('3', '44', '15', 'Møte');
	}

	public void removeAlarm(int Appid, int userid, int offset){

		db.send("DELETE FROM `calendar`.`alarm` WHERE `AppID`='"+Appid+"' and`EmpID`='"+userid+"' and`AlarmTime`='"+offset+"'");


	}

	public static void main(String args[]){
		
		DBAlarms a= new DBAlarms();
		DBEmployees e= new DBEmployees();
		e.loadEmployees();
		System.out.println("go!");
		a.loadAlarms();
		
		
	
		
		
		
			
		}




	//removeAlarm(a.getId(), currentUser.getId(), alarm.getTime());

}
