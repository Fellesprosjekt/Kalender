package dbConnection;

import java.util.ArrayList;
import java.util.HashMap;

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

		ArrayList<HashMap<String,String>> alarms = db.get("SELECT * FROM Calendar.alarm");
		for(Employee e : Employee.employees){

			for(HashMap<String,String> alarm : alarms){
				String UID = (alarm.get("EmpID"));

				if(Integer.parseInt(UID)==e.getId()){
					String label=(alarm.get("Label"));
					int offset=Integer.parseInt(alarm.get("AlarmTime"));
					String appoint = alarm.get("AppID");
					Alarm al= new Alarm(label, appointment, offset)
					e.addAlarm(al);
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

	//public static void main(String args[]){
	//	
	//	DBAlarms a= new DBAlarms();
	//	a.removeAlarm(2, 2, 12);
	//	
	//	
	//
	//	
	//	
	//	
	//		
	//	}




	//removeAlarm(a.getId(), currentUser.getId(), alarm.getTime());

}
