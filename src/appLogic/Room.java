package appLogic;
import java.util.ArrayList;

import org.joda.time.DateTime;

import exceptions.DateTimeException;
import exceptions.RoomBookedException;


public class Room implements AppointmentListener{
	public static ArrayList<Room> rooms = new ArrayList<Room>();
	private String id;
	private final int size;
	private Calendar room_calendar;
	
	public Room(int size) {
		this.size = size;
		this.id = null;
		this.room_calendar = new Calendar();
		rooms.add(this); 
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		if(this.id.equals(null)){
			if(id.length()>4) this.id=id.substring(0,4);
			else this.id=id;
		}
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
	
	public static ArrayList<Room> getFreeRooms(DateTime start, DateTime end) throws DateTimeException {
		ArrayList<Room> freeRooms = new ArrayList<Room>();
		CalendarRow time_slot = new CalendarRow(start, end, null);
		for (Room room : rooms) {
			if (!room.isBooked(time_slot)) {
				freeRooms.add(room);
			}
		}
		return freeRooms;
	}

	@Override
	public void appointmentCreated(Appointment appointment, DateTime start, DateTime end) throws DateTimeException {
		room_calendar.addAppointment(start, end, appointment);
	}


	@Override
	public void startChanged(Appointment appointment, DateTime start) throws DateTimeException, RoomBookedException {
		CalendarRow row = room_calendar.findCalendarRow(appointment);
		if(!row.equals(null)){
			DateTime end = row.getEnd();
			if(isBooked(new CalendarRow(start,end,null))) throw new RoomBookedException();
			else row.setStart(start);
		}
	}

	@Override
	public void endChanged(Appointment appointment, DateTime end) throws DateTimeException, RoomBookedException {
		CalendarRow row = room_calendar.findCalendarRow(appointment);
		if(!row.equals(null)){
			DateTime start = row.getStart();
			if(isBooked(new CalendarRow(start,end,null))) throw new RoomBookedException();
			else row.setEnd(end);
		}	
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

	@Override
	public void appointmentCancelled(Appointment appointment) {
		room_calendar.removeCalendarRow(appointment);	
	}
}
