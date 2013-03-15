package appLogic;
import java.util.ArrayList;

import org.joda.time.DateTime;


public class Room implements AppointmentListener{

	public static ArrayList<Room> rooms = new ArrayList<Room>(); 
	private final int size;
	private Calendar room_calendar;
	
	public Room(int size) {
		this.size = size;
		this.room_calendar = new Calendar();
		rooms.add(this); 
	}
	
	
	public int getSize() {
		return this.size;
	}
	
	public Calendar getCalendar() {
		return this.room_calendar;
	}
	
	/* -- endret input til calendarRow --
	 * gar gjennom alle innslagene i rommets kalender og sjekker om other
	 * krasjer med noen av de andre
	 */
	public boolean isBooked(CalendarRow row) {
		for (CalendarRow other : room_calendar)
			if(row.isOverlapping(other))
				return true;
		return false;
	}
	
	public static ArrayList<Room> getFreeRooms(DateTime start, DateTime end) {
		//TODO
		return null;
	}
	
	public void bookRoom(CalendarRow row){
		room_calendar.addCalendarRow(row);
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
