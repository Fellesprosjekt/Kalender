package appLogic;
import java.util.ArrayList;
import java.util.Iterator;

import org.joda.time.DateTime;

import exceptions.DateTimeException;


public class Calendar implements Iterable<CalendarRow>{
	
	/*
	 * 
	 * 
	 *   Ferdig 15.03.2013
	 * 	 (sannsynligvis)
	 * 
	 * 
	 */
	
	
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
	
	/* returnerer alle calendarRow som har starttid tilsvarende weekNumber */
	public ArrayList<CalendarRow> getWeekCalendar(int weekNumber) {
		ArrayList<CalendarRow> week = new ArrayList<CalendarRow>();
		for (CalendarRow row: calendar) {
			if (row.getStart().getWeekOfWeekyear() == weekNumber) {
				week.add(row);
			}
		}
		return week;
	}
	
	/* oppretter ny CalendarRow og legger inn i calendar */
	public void addAppointment(DateTime start, DateTime end, Appointment appointment) throws DateTimeException {
		if (end.isBefore(start)) {throw new DateTimeException("end is before start"); }
		calendar.add(new CalendarRow(start, end, appointment)); 
	}
	
	/* fjerner CalendarRow som er assosiert med gitt appointment */
	public void removeCalendarRow(Appointment appointment) {
		for (CalendarRow row : calendar) {
			if (row.getAppointment().equals(appointment)) {
				calendar.remove(row); 
			}
		}
	}
	
	/* returnerer CalendarRow som har gitt start, ellers null */
	public CalendarRow findCalendarRow(DateTime start) {
		for (CalendarRow row : calendar) {
			if (row.getStart().equals(start)) {
				return row; 
			}
		}
		return null;
	}
	
	/* returnerer CalendarRow som har gitt appointment, ellers null */
	public CalendarRow findCalendarRow(Appointment appointment) {
		for (CalendarRow row : calendar) {
			if (row.getAppointment().equals(appointment)) {
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
