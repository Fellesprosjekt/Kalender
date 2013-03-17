package appLogic;

import org.joda.time.DateTime;

public interface ObservableAppointment {

	public void addParticipant(User user);
	
	public void removeParticipant(User user);
	
	public void fireDescriptionChanged();
	
	public void fireRoomChanged();

	public void fireParticipantDeclined(User user);

	public void fireAppointmentCreated(DateTime start, DateTime end) throws DateTimeException;
	
	public void fireStartChanged(DateTime start);
	
	public void fireEndChanged(DateTime end);
	
}
