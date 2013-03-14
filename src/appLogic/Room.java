package appLogic;
import java.util.ArrayList;

import org.joda.time.DateTime;


public class Room implements AppointmentListener{

	public static ArrayList<Room> rooms = new ArrayList<Room>(); 
	private final int size;
	private Calendar calendar;
	
	public Room(int size) {
		this.size = size;
		this.calendar = new Calendar();
	}
	
	
	public int getSize() {
		return this.size;
	}
	
	public Calendar getCalendar() {
		return this.calendar;
	}
	
	/* maa vel vite slutt-tid også??  */
	public boolean isBooked(DateTime start) {
		//TODO
		return true;
	}
	
	public ArrayList<Room> getFreeRooms(DateTime start, DateTime end) {
		//TODO
		return null;
	}

	@Override
	public void appointmentCreated(Appointment appointment, DateTime start, DateTime end) {
		// TODO Auto-generated method stub
	}

	@Override
	public void startChanged(DateTime start) {
		// TODO Auto-generated method stub
	}

	@Override
	public void descriptionChanged(String description) {
		// TODO Auto-generated method stub
	}

	@Override
	public void roomChanged(Room room) {
		// TODO Auto-generated method stub
	}

	@Override
	public void durationChanged(int minutes) {
		// TODO Auto-generated method stub
	}

	@Override
	public void participantDeclined(User user) {
		// TODO Auto-generated method stub
	}
	
	
}
