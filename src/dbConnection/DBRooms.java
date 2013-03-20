package dbConnection;

public class DBRooms {
	
	
	
	public Simpleconnect db= new Simpleconnect("calendar","SklSkl91");
	
	
	public DBRooms(){
		
	}
	
	public void updateAppointmentRoom(int appID,String roomID){
		
		db.send("update booking set roomid="+roomID+" where appid="+appID);
		
		
		
	}
	
//public static void main(String args[]){
//	
//	DBRooms a= new DBRooms();
//	a.updateAppointmentRoom(1,"2");
//	
//	
//		
//	}
//	
	

}
