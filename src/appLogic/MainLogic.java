package appLogic;

import java.util.ArrayList;
import java.util.Scanner;

import org.joda.time.DateTime;

import exceptions.DateTimeException;
import exceptions.InvalidAlarmException;
import exceptions.InvalidEmailException;
import exceptions.InvalidNameException;
import exceptions.RoomBookedException;
import exceptions.RoomSizeException;

import appLogic.Appointment;
import appLogic.Employee;
import appLogic.Group;
import appLogic.Room;
import appLogic.User;

public class MainLogic {
	/* I tillegg til alle funksjonene som nevnes underveis
	 * trenger vi funskjoner for å:
	 * - Laste inn alle ansatte
	 * - Laste inn alle grupper
	 * - Laste inn alle appointments og sette statusen til hver bruker i appointmenten lik det som er i AppInvitation
	 * - Laste inn alle rom
	 * - Last inn kalenderene til hver bruker (der hvor brukeren har godtatt avtalen)
	 * - Laste inn kalenderen for hvert rom
	 * - Laste inn alle alarmer for hver ansatt
	 * - Dersom noe ugyldig lastes inn fra databasen (exceptions ved opprettelse av objektet), slett det fra databasen.
	 */
	public Employee currentUser;
	
	//Sett opp brukere og grupper
	private void init() {
		try {
			new Employee(0, "Kong Harald", "harald@konge.no");
			new Employee(1, "Dronning Sonja", "sonja@dronning.no");
			new Employee(2, "Kronprins Haakon", "haakon@nestenkonge.no");
			new Room("r1",500);
			new Room("s656",25);
			new Room("min1",1);
			new Room("min2",2);
		} catch (InvalidNameException e) {
			e.printStackTrace();
		} catch (InvalidEmailException e) {
			e.printStackTrace();
		}
		
	}
	
	//Hjelpemetode for Â hente ut employee fra gitt streng	
	public MainLogic(){
		currentUser = null;
		init(); 
	}
	
	public void logInEmployee(Employee e){
		currentUser = e;
	}
	
	
	private void createAppointment(String description, Room room, ArrayList<User> participants, DateTime start, DateTime end){
		try {
			Appointment a = new Appointment(description, room, currentUser, participants, start, end);
//			--- Mot databasen ---
//			Legg til i Appointment: createAppointment(start, end, description, currentUser.getId())
//			Her vil leaderId = currentUser.getId()
//			Hent fra Appointment: getAppointmentId(leaderId, start), skal returnere id
//			Legg til i Booking: createBooking(a.getId(), room.getId());
//			----------------------
//			a.setId(id);
			
			for(User u : participants){
				addParticipant(a, u);
			}
		} catch (DateTimeException e) {
//			Error: ugyldig tidsrom
		} catch (RoomBookedException e) {
//			Error: rommet er booked i dette tidsrommet
		} catch (RoomSizeException e) {
//			Error: rommet er ikke stort nok til antall deltakere
		}
	}
	
	private void addParticipant(Appointment a, User u){
		if(!a.containsParticipant(u)) a.addParticipant(u);
//		--- Mot databasen ---
//		Legg til i AppInvitation: createAppInvitation(a.getId(),u.getId(),u.getStatus())
//		----------------------
	}
	
	private void removeParticipant(Appointment a, User u){
		a.removeParticipant(u);
//		--- Mot databasen ---
//		Fjern AppInvitation: removeAppInvitation(a.getId(),u.getId(),u.getStatus())
//		----------------------
	}
	
//	Kjøres når den nåværende brukeren aksepterer en invitasjon
	private void updateUserSatus(boolean status, Appointment a){
		if(status) currentUser.acceptAppointment(a);
		else currentUser.declineAppointment(a);
//		--- Mot databasen ---
//		Oppdater AppInvitation: updateAppInvitation(a.getId(),currentUser.getId(),status);
//		----------------------
	}
	
	private void updateAppointmentRoom(Room r, Appointment a){
		try {
			a.bookRoom(r);
//			--- Mot databasen ---
//			Oppdater Booking: updateBooking(a.getId(), r.getId())			
//			----------------------
		} catch (DateTimeException e) {
//			Error: ugyldig tidspunkt for avtalen
		} catch (RoomBookedException e) {
//			Error: rommet er allerede booket på dette tidspunktet
		} catch (RoomSizeException e) {
//			Error: rommet er for lite for denne avtalen
		}
	}
	
	private void updateAppointmentDescription(Appointment a, String description){
		a.setDescription(description);
//		--- Mot databasen ---
//		Oppdater Appointment: updateAppointment(a.getId(), description)			
//		----------------------
	}
	
	private void updateAppointmentStart(Appointment a, DateTime start){
		try {
			a.setStart(start);
//			--- Mot databasen ---
//			Oppdater Appointment: updateAppointment(a.getId(), description)
//			----------------------
		} catch (DateTimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RoomBookedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void updateAppointmentEnd(Appointment a, DateTime end){
		try {
			a.setEnd(end);
//			--- Mot databasen ---
//			Oppdater Appointment: updateAppointment(a.getId(), description)
//			----------------------
		} catch (DateTimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RoomBookedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void removeAppointment(Appointment a){
		a.fireAppointmentCancelled();
		for(Employee e : Employee.employees){
			for(Alarm alarm : e.getAlarms()){
				if(alarm.getAppointment().equals(a)) e.removeAlarm(alarm);
			}
		}
//		--- Mot databasen ---
//		Slett Appointment: removeAppointment(a.getId())
//		----------------------
	}
	
	private void createAlarm(String label, int offsetMins, Appointment a) throws InvalidAlarmException{
		DateTime alarmtime = a.getStart().minusMinutes(offsetMins);
		Alarm alarm = new Alarm(alarmtime, label, a);
		currentUser.addAlarm(alarm);
		
//		--- Mot databasen ---
//		Legg til i Alarm: addAlarm(a.getId(), currentUser.getId(), alarmtime, label)
//		----------------------
	}
	
	private void removeAlarm(Alarm alarm){
		currentUser.removeAlarm(alarm);
//		--- Mot databasen ---
//		Fjern fra Alarm: removeAlarm(a.getId(), currentUser.getId(), alarm.getTime())
//		----------------------
	}
}
