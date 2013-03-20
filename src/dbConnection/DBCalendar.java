package dbConnection;

import java.util.ArrayList;
import java.util.HashMap;

import org.joda.time.DateTime;

public class DBCalendar {
	Simpleconnect db;
	
	public DBCalendar(){
		db = new Simpleconnect("Calendar", "");
	}
	
	public void loadUserCalendar(){
		String sql = "SELECT * FROM Calendar.AppInvitation";
		ArrayList<HashMap<String,String>> posts = new ArrayList<HashMap<String,String>>();
		for(HashMap<String,String> post : posts){
			
		}
	}
	
//	public static void main(String[] args) {
//		DateTime dt = new DateTime(arg0, arg1, arg2, arg3, arg4, arg5)
//	}
}
