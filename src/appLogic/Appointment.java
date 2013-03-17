package appLogic;
import java.util.ArrayList;
import java.util.HashMap;
import org.joda.time.DateTime;


public class Appointment implements ObservableAppointment{

	private String description;
	private Room room;
	private final Employee leader;
	private HashMap<User, Boolean> participants;
	
	public Appointment(String description, Room room, Employee leader, ArrayList<User> participants, DateTime start, DateTime end) throws DateTimeException, RoomBookedException, RoomSizeException{
		this.leader=leader;
		for(User p : participants){
			this.participants.put(p, null);
		}
		this.participants.put(leader, true);
		int numOfParticipants = participants.size();
		bookRoom(start,end,room,numOfParticipants);
		setDescription(description);
		leader.appointmentCreated(this, start, end);
	}
	/* Sjekker om reommet er ledig
	 * Setter rommet og "booker" det ved Œ legge det i romkalenderen til rommet dersom det er ledig
	 */
	public void bookRoom(DateTime start, DateTime end, Room room,int numOfParticipants) throws DateTimeException, RoomBookedException, RoomSizeException{
		if(room.isBooked(new CalendarRow(start, end, this))) throw new RoomBookedException();
		if(numOfParticipants>room.getSize()) throw new RoomSizeException();
		else{
			this.room=room;
			room.appointmentCreated(this, start, end);
		}
	}
	
	public Room getRoom() {
		return this.room;
	}
	
	// Dersom beskrivelsen er lengre enn det databsen st¿tter trimmer vi den til maxlengde
	public void setDescription(String description) {
		this.description = (description.length() < 100 ? description : description.substring(0, 99)); 
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public Employee getLeader() {
		return this.leader;
	}
	
	@Override
	public void addParticipant(User user) {
		participants.put(user, null);
	}
	@Override
	public void removeParticipant(User user) {
		if(participants.containsKey(user)) participants.remove(user);
		
	}
	@Override
	public void fireAppointmentCreated() {
		// TODO Auto-generated method stub		
	}
	@Override
	public void fireDescriptionChanged() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void fireRoomChanged() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void fireParticipantChangedStatus(User user, boolean status) {
		if(participants.containsKey(user)) participants.put(user, status);
	}	
}
