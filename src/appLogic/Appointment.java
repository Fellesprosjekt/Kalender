package appLogic;
import java.util.HashMap;


public class Appointment {

	private String description;
	private Room room;
	private final Employee leader;
	private HashMap<User, Boolean> participants;
	
	public Appointment() {
		//TODO
	}
	
	public void setRoom(Room room) {
		//TODO
	}
	
	public Room getRoom() {
		return this.room;
	}
	
	public void setDescription(String description) {
		//TODO
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public Employee getLeader() {
		return this.leader;
	}
	
	public void setParticipantStatus(User user, boolean status) {
		//TODO
	}
	
	public void bookRoom(int numberOfParticipants) {
		//TODO
	}
	
	
}
