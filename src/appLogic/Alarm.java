package appLogic;

import org.joda.time.DateTime;

public class Alarm {

	private final DateTime time;
	private String label;
	private final Appointment appointment;
	private final int offset;
	
	public Alarm(String label, Appointment appointment,int offset) {
		this.time = appointment.getStart().minusMinutes(offset);
		this.appointment=appointment;
		this.offset=offset;
		setLabel(label);
	}
	
	public int getOffset(){
		return this.offset;
	}
	
	public String getLabel() {
		return this.label;
	}
	
	public DateTime getTime() {
		return this.time;
	}
	
	public Appointment getAppointment(){
		return this.appointment;
	}
	
	/* sorger for at label ikke blir lenger enn 100 tegn */
	public void setLabel(String label) {
		this.label = ( label.length() < 100 ? label : label.substring(0, 99) ); 
	}
	
	public void fireAlarm() {
		//TODO: "Noe"
	}

	
	public boolean isEqual(Alarm other) {
		return (this.appointment.equals(other.appointment) && this.time.equals(other.time)? true : false);
		
	}
	
	
}
