package dbConnection;

import exceptions.DateTimeException;
import org.joda.time.DateTime;
public class DBAlarms {
	
	
	public Simpleconnect db= new Simpleconnect("Kalender","SklSkl91");
	
	public DBAlarms(){
		
	}
	
	
	
	
	
	
	public void addAlarm(int AppointmentID, int UserID, int offsetMins, String label) {
	db.send("INSERT INTO `calendar`.`alarm` " +
			"(`AppID`, `EmpID`, `AlarmTime`, `Label`) " +
			"VALUES ('"+AppointmentID+"', '"+UserID+"', '"+offsetMins+"', '"+label+"')");
		
		
		
		//INSERT INTO `calendar`.`alarm` (`AppID`, `EmpID`, `AlarmTime`, `Label`) VALUES ('3', '44', '15', 'Møte');
	}
	
	
	public static void Main(String[] args){
		
	}
	
	
	
	//removeAlarm(a.getId(), currentUser.getId(), alarm.getTime());

}
