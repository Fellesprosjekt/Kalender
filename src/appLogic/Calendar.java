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
	
	
	public ArrayList<CalendarRow> getWeekCalendar(int weekNumber) {
		// TODO: mulig fordel a lage hjelpemetode for a finne DateTime
		//       for forste dag i uken
		return null;
	}
	
	/* oppretter ny CalendarRow og legger inn i calendar */
	public void addAppointment(DateTime start, DateTime end, Appointment appointment) {
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
