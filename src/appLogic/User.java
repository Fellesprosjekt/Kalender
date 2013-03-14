package appLogic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.joda.time.DateTime;

public class User implements AppointmentListener {
	private String email;
	private Calendar calendar;
	//Disse brukes for Œ validere strenger
	private Pattern pattern;
	private Matcher matcher;
	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public User(String email) throws InvalidEmailException{
		setEmail(email);
		calendar = new Calendar();
	}
	
	
	private void setEmail(String email) throws InvalidEmailException{
		if(!isValidEmail(email)) throw new InvalidEmailException();
		else this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public Calendar getCalendar() {
		return this.calendar;
	}
	
	private void acceptAppointment(Appointment appointment) {
	}
	
	private void declineAppointment(Appointment appointment) {
	}
	
	private boolean isValidEmail(String email){
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(email);
		return matcher.matches() && email.length()<=40;
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
