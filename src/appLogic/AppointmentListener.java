package appLogic;

public interface AppointmentListener {

	/* sjekk: public el. private */
	public void appointmentCreated(Appointment appointment, DateTime start, DateTime end);
	
	/* kobles disse til noen objekter */
	public void startChanged(DateTime start);
	
	public void descriptionChanged(String description);
	
	public void roomChanged(Room room);
	
	public void durationChanged(int minutes);
	
	public void participantDeclined(User user);
}
