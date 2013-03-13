package fellesprosjekt;

public interface ObservableAppointment {

	public void addParticipant(User user);
	
	public void removeParticipant(User user);
	
	public void fireAppointmentCreated();
	
	public void fireDescriptionChanged();
	
	public void fireRoomChanged();
	
	public void fireParticipantDeclined(User user);
	
}
