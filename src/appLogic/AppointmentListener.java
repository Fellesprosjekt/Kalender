package appLogic;

import org.joda.time.DateTime;

import exceptions.BusyUserException;
import exceptions.DateTimeException;
import exceptions.RoomBookedException;

public interface AppointmentListener {

	/* sjekk: public el. private */
	public void appointmentCreated(Appointment appointment, DateTime start, DateTime end) throws DateTimeException, BusyUserException;
	
	/* kobles disse til noen objekter */
	public void startChanged(Appointment appointment, DateTime start) throws DateTimeException, RoomBookedException, BusyUserException;
	
	public void endChanged(Appointment appointment, DateTime end) throws DateTimeException, RoomBookedException, BusyUserException;
	
	public void descriptionChanged(Appointment appointment);
	
	public void roomChanged(Appointment appointment);
	
	public void participantDeclined(Appointment appointment, User user);
}
