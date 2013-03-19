package appLogic;

import java.util.ArrayList;
import java.util.Scanner;

import org.joda.time.DateTime;

import exceptions.DateTimeException;
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
	Scanner sc;
	ArrayList<Group> groups = new ArrayList<Group>();
	ArrayList<Employee> employees = new ArrayList<Employee>();
	Employee currentUser;
	
	
	
	private void init(){
		try {
			employees.add(new Employee("Ola Nordmann", "ola@nordmann.no"));
			employees.add(new Employee("Kari Nordmann", "kari@nordmann.no"));
			employees.add(new Employee("Harald Rex", "harald@rex.no"));
			employees.add(new Employee("Sonja Haraldsen", "sonja@haraldsen.no"));
			groups.add(new Group("Nordmann", "nordmann@nordmann.no"));
			groups.add(new Group("KingKong", "king@kong.no"));
			groups.get(0).addMember(employees.get(0));
			groups.get(0).addMember(employees.get(1));
			groups.get(1).addMember(employees.get(2));
			groups.get(1).addMember(employees.get(3));
		} catch (InvalidNameException e) {
			System.err.println("invalid name");
		} catch (InvalidEmailException e) {
			System.err.println("invalid email");
		}
	}
	
	public MainLogic(){
		init(); 
	}	
	
	private void createEmployee(String name, String email){
		try {
			Employee e = new Employee(name, email);
			employees.add(e);
//			--- Mot databasen ---
//			Legg til i CalendarUser: createUser(name, email, "Employee")
//			Hent fra CalendarUser: getUser(email), skal returnere id
//			e.setId(id);
//			---------------------
			
		} catch (InvalidNameException e1) {
//			Error: Invalid name
		} catch (InvalidEmailException e1) {
//			Error: Invalid email
		}
	}
	
	private void createGroup(String name, String email, ArrayList<Employee> members){
		try {
			Group g = new Group(name, email);
			groups.add(g);
			
//			--- Mot databasen ---
//			Legg til i CalendarUser: createUser(name, email, "Group")
//			Hent fra CalendarUser: getUserId(email), skal returnere id
//			----------------------
			
//			g.setId(id);
			for(Employee e : members){
				addGroupmember(g,e);
			}
			
		} catch (InvalidNameException e1) {
//			Error: Invalid name
		} catch (InvalidEmailException e1) {
//			Error: Invalid email
		}
	}
	
	private void addGroupmember(Group g, Employee e){
		g.addMember(e);
		
//		--- Mot databasen ---
//		Legg til i Groupmember: addGroupmember(g.getId(), e.getId())
//		----------------------
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
	
	
	public static void main(String[] args) {
		MainLogic h = new MainLogic();
		System.out.println(h.groups);
	}
}
