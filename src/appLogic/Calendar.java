package appLogic;
import java.util.ArrayList;
import java.util.Iterator;

import org.joda.time.DateTime;


public class Calendar implements Iterable<CalendarRow>{
	
	private ArrayList<CalendarRow> calendar;
	
	public Calendar() {
		calendar = new ArrayList<CalendarRow>();
	}
	
	public ArrayList<CalendarRow> getCalendar() {
		return calendar;
	}
	
	public void addCalendarRow(CalendarRow calendarRow) {
		calendar.add(calendarRow);
	}
	
	
	public ArrayList<CalendarRow> getWeekCalendar(int weekNumber) {
		ArrayList<CalendarRow> week = new ArrayList<CalendarRow>();
		for (CalendarRow)
		
	}
	
	/* oppretter ny CalendarRow og legger inn i calendar */
	public void addAppointment(DateTime start, DateTime end, Appointment appointment) throws DateTimeException {
		if (end.isBefore(start)) {throw new DateTimeException("end is before start"); }
		calendar.add(new CalendarRow(start, end, appointment)); 
	}
	
	/* fjerner CalendarRow som er assosiert med gitt appointment */
	public void removeAppointment(Appointment appointment) {
		for (CalendarRow row : calendar) {
			if (row.getAppointment().equals(appointment)) {
				calendar.remove(row); 
			}
		}
	}
	
	/* returnerer CalendarRow som har gitt start, ellers null */
	public CalendarRow findAppointment(DateTime start) {
		for (CalendarRow row : calendar) {
			if (row.getStart().equals(start)) {
				return row; 
			}
		}
		return null;
	}

	@Override
	public Iterator<CalendarRow> iterator() {
		return calendar.iterator();
	}
	
}
