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
	 * gar gjennom alle innslagene i rommets kalender og sjekker om row
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

	@Override
	public void appointmentCreated(Appointment appointment, DateTime start, DateTime end) throws DateTimeException {
		room_calendar.addAppointment(start, end, appointment);
	}


	@Override
	public void startChanged(Appointment appointment, DateTime start)
			throws DateTimeException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void endChanged(Appointment appointment, DateTime end)
			throws DateTimeException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void descriptionChanged(Appointment appointment) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void roomChanged(Appointment appointment) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void participantDeclined(Appointment appointment, User user) {
		// TODO Auto-generated method stub
		
	}
}
