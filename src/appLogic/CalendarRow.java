package appLogic;
import java.util.ArrayList;


public class CalendarRow implements Comparable<CalendarRow>{

	private DateTime start;
	private DateTime end;
	private final Appointment appointment;
	private ArrayList<Alarm> alarms;
	
	public CalendarRow(DateTime start, DateTime end, Appointment appointment) {
		this.start = start;
		this.end = end;
		this.appointment = appointment;
		this.alarms = new ArrayList<Alarm>();
	}

	public DateTime getStart() {
		return start;
	}
	public void setStart(DateTime start) {
		this.start = start;
	}
	public DateTime getEnd() {
		return end;
	}
	public void setEnd(DateTime end) {
		this.end = end;
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public ArrayList<Alarm> getAlarms() {
		return alarms;
	}

	// holder med compareTo i DateTime ?? hva skal sammenliknes?:
	// starttider, hva med overlapp ?? ...
	@Override
	public int compareTo(CalendarRow o) {
		return 0;
	}
	
	
	
	
}
