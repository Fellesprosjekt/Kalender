package dbConnection;

import exceptions.DateTimeException;
import org.joda.time.DateTime;
public class DBAlarms {


	public Simpleconnect db= new Simpleconnect("calendar","SklSkl91");

	public DBAlarms(){

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
