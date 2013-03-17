package appLogic;

import org.joda.time.DateTime;

public interface AppointmentListener {

	/* sjekk: public el. private */
	public void appointmentCreated(Appointment appointment, DateTime start, DateTime end) throws DateTimeException;
	
	/* kobles disse til noen objekter */
	public void startChanged(Appointment appointment, DateTime start);
	
	public void endChanged(Appointment appointment, DateTime end);
	
	public void descriptionChanged(Appointment appointment);
	
	public void roomChanged(Appointment appointment);
	
	public void participantDeclined(Appointment appointment, User user);
}
