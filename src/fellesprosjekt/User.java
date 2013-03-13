package fellesprosjekt;

public class User implements AppointmentListener {

	private String email;
	private Calendar calendar;
	
	public User() {	
	}
	
	
	private void setEmail(String email) {
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getName() { //Skal hente navn på enten EMPLOYEE eller GROUP eller PEDER
	}
	
	public Calendar getCalendar() {
		return this.calendar;
	}
	
	private void acceptAppointment(Appointment appointment) {
	}
	
	private void declineAppointment(Appointment appointment) {
	}

	@Override
	public void appointmentCreated(Appointment appointment, DateTime start, DateTime end) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void startChanged(DateTime start) {
		// TODO Auto-generated method stub
	}

	@Override
	public void descriptionChanged(String description) {
		// TODO Auto-generated method stub
	}

	@Override
	public void roomChanged(Room room) {
		// TODO Auto-generated method stub
	}

	@Override
	public void durationChanged(int minutes) {
		// TODO Auto-generated method stub
	}

	@Override
	public void participantDeclined(User user) {
		// TODO Auto-generated method stub
	}
	
	
}
