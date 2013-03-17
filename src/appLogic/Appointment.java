package appLogic;
import java.util.ArrayList;
import java.util.HashMap;
import org.joda.time.DateTime;

import exceptions.BusyUserException;
import exceptions.DateTimeException;
import exceptions.RoomBookedException;
import exceptions.RoomSizeException;


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
		bookRoom(start,end,room, participants.size());
		setDescription(description);
		fireAppointmentCreated(start, end);
	}
	/* Sjekker om reommet er ledig
	 * Setter rommet og "booker" det ved Œ legge det i romkalenderen til rommet dersom det er ledig
	 */
	public void bookRoom(DateTime start, DateTime end, Room room,int numOfParticipants) throws DateTimeException, RoomBookedException, RoomSizeException{
		if(room.isBooked(new CalendarRow(start, end, null))) throw new RoomBookedException();
		else if(numOfParticipants>room.getSize()) throw new RoomSizeException();
		else{
			if(!this.room.equals(null)){
				this.room.getCalendar().removeCalendarRow(this);
				this.room=room;
				fireRoomChanged();
			}else this.room=room;
		}
	}
	
	public Room getRoom() {
		return this.room;
	}
	
	// Dersom beskrivelsen er lengre enn det databsen st¿tter trimmer vi den til maxlengde
	public void setDescription(String description) {
		if(!this.description.equals(null)){
			this.description = (description.length() > 100 ? description.substring(0,99) : description);
			fireDescriptionChanged();
		}else this.description = (description.length() > 100 ? description.substring(0,99) : description);
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public Employee getLeader() {
		return this.leader;
	}
	
	public void setParticipantStaus(User user, boolean status){
		if(participants.containsKey(user)){
			participants.put(user, status);
			if(!status) fireParticipantDeclined(user);
		}
	}
	
	public void setStart(DateTime start) throws DateTimeException, RoomBookedException{
		fireStartChanged(start);
	}
	
	public void setEnd(DateTime end) throws DateTimeException, RoomBookedException{
		fireEndChanged(end);
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
	public void fireAppointmentCreated(DateTime start, DateTime end) throws DateTimeException {
		for(User u : participants.keySet()){
			try{
				u.appointmentCreated(this, start, end);
			}catch(BusyUserException e){
				participants.put(u, false);
				fireParticipantDeclined(u);
			}
		}
		room.appointmentCreated(this, start, end);
	}
	@Override
	public void fireDescriptionChanged() {
		for(User u : participants.keySet()){
			u.descriptionChanged(this);
		}	
	}
	@Override
	public void fireRoomChanged() {
		for(User u : participants.keySet()){
			u.roomChanged(this);
		}
	}
	@Override
	public void fireParticipantDeclined(User user){
		for(User u : participants.keySet()){
			u.participantDeclined(this, user);
		}
	}
	@Override
	public void fireStartChanged(DateTime start) throws DateTimeException, RoomBookedException {
		for(User u : participants.keySet()){
			try{
				u.startChanged(this, start);
			}catch(BusyUserException e){
				participants.put(u, false);
				fireParticipantDeclined(u);
			}
		}
		room.startChanged(this, start);
	}
	@Override
	public void fireEndChanged(DateTime end) throws DateTimeException, RoomBookedException {
		for(User u : participants.keySet()){
			try{
				u.endChanged(this, end);
			}catch(BusyUserException e){
				participants.put(u, false);
				fireParticipantDeclined(u);
			}
		}
		room.endChanged(this, end);
	}
}
