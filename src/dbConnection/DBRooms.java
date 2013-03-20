package dbConnection;

import java.util.ArrayList;
import java.util.HashMap;
import appLogic.*;

import appLogic.Group;
import exceptions.InvalidEmailException;
import exceptions.InvalidNameException;

public class DBRooms {
	public Simpleconnect db;
	
	
	public DBRooms(){
		db = new Simpleconnect("Calendar","");
	}
	
	public void updateAppointmentRoom(int appID,String roomID){	
		db.send("update booking set roomid="+roomID+" where appid="+appID);	
	}
	
	public void loadRooms(){
		ArrayList<HashMap<String,String>> posts = db.get("SELECT * FROM Calendar.room ");
		for(HashMap<String,String> post : posts){
			String romid = (post.get("RoomID"));
			int size = Integer.parseInt(post.get("Size"));
			new Room(romid, size);
		}
	}
	
//public static void main(String args[]){
//	
//	DBRooms a= new DBRooms();
//	//ArrayList<HashMap<String,String>> b=a.db.get("SELECT * FROM room");
//	a.loadRooms();
//	//System.out.println(b.toString());
//	
//	for (Room r : Room.rooms) {
//		
//		System.out.println(r.getId()+" "+r.getSize());
//		
//		
//	}	

}
