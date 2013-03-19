package gui;

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

public class Home {
	Scanner sc;
	ArrayList<Group> groups = new ArrayList<Group>();
	ArrayList<Employee> employees = new ArrayList<Employee>();
	Employee currentUser;
	
	/*
	 * 
	 * 		!!   OBS   !!
	 * 			Scanner kan skape trøbbel
	 * 
	 * 		Gruppenavn kan ikke inneholde mellomrom
	 * 
	 */
	
	
	
	
	
	
	
	
	private void init(){
		try {
			employees.add(new Employee(0, "Ola Nordmann", "ola@nordmann.no"));
			employees.add(new Employee(1, "Kari Nordmann", "kari@nordmann.no"));
			employees.add(new Employee(2, "Harald Rex", "harald@rex.no"));
			employees.add(new Employee(3, "Sonja Haraldsen", "sonja@haraldsen.no"));
			groups.add(new Group(0, "Nordmann", "nordmann@nordmann.no"));
			groups.add(new Group(1, "KingKong", "king@kong.no"));
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
	
	public Home(){
		sc = new Scanner(System.in);
		init(); 
	}
	
	private void loadMenu(){
		/*
		 * 
		 * Sjekk rekursive kall !! 
		 * 
		 */
		System.out.println(" -- Meny, velg funksjon --");
		System.out.println("'r' --> Registrer ansatt");
		System.out.println("'l' --> Logg inn ansatt");
		System.out.print("Funksjon: ");
		char valg = sc.nextLine().charAt(0);
		switch(valg){
		case('r'):
			createEmployee();
			loadMenu();
			break;
		case('l'):
			System.out.println("-- 'Logg inn som' --");
			currentUser = chooseEmployee();
			loadLoggedInMenu();
			break;
		default:
			System.err.println("Ugyldig kommando.");
			loadMenu();				///////////////////////////////////////tilbake til meny///////////////////////////////
			break;
		}
	}
	
	private void loadLoggedInMenu() {
		/*
		 * !!!!
		 * fikk problemer med å lese inn funksjon; så skiftet til å ta inn tall
		 * !!!!
		 */
		System.out.println(" Logget inn som: " + currentUser.getFirstName()+" "+ currentUser.getLastname());
		System.out.println(" -- Meny, velg funksjon --");
		System.out.println("'1' --> Opprett gruppe");
		System.out.println("'2' --> Legg til gruppemedlemmer");
//		System.out.println("'a' --> Opprett avtale");
//		System.out.println("'a' --> Legg til alarm");
//		System.out.println("'a' --> Legg til alarm");
		System.out.print("Funksjon: ");
		int valg = sc.nextInt();
		switch(valg){
		case(1):
			createGroup();
			break;
		case(2):
			addToGroup();
			break;
		default:
			System.err.println("Ugyldig kommando.");
			break;
		}
	}
	
	private void createEmployee(){
		System.out.println("-- Registrer ansatt -- ");
		try {
			System.out.println("Name: ");
			String name = sc.nextLine();
			System.out.println("Email: ");
			String email = sc.nextLine();
			System.out.println();
			Employee e = new Employee(0, name, email);
			employees.add(e); 
		} catch (InvalidNameException e) {
			System.err.println("Ugyldig navn");
		} catch (InvalidEmailException e) {
			System.err.println("Ugyldig email");
		}
		System.out.println(" -------------------- \n");
	}

	private Employee chooseEmployee(){
		System.out.println(" -- Velg ansatt -- ");
		System.out.println("Ansatte: " + employees);
		System.out.print("Indeks på ansatt: ");
		int index = sc.nextInt();
		System.out.println(" -------------------- \n");
		return employees.get(index);
	}
	
	private ArrayList<User> chooseParticipants() {
		System.out.println(" -- Velg deltakere -- ");
		ArrayList<User> users = new ArrayList<User>();
		users.addAll(employees);
		users.addAll(groups);
		System.out.println(users);
		System.out.println("Indekser separert med mellomrom");
		String indices = sc.nextLine();
		ArrayList<User> chosen = new ArrayList<User>();
		for (String s : indices.split(" ")) {
			int i = Integer.parseInt(s);
			chosen.add(users.get(i)); 
		}
		System.out.println(" -------------------- \n");
		return chosen;
		
		
	}
	
	private void createGroup(){
		System.out.println(" -- Opprett gruppe -- ");
		System.out.println("Name: ");
		String name = sc.nextLine();
		sc.nextLine(); 
		System.out.println("Email: ");
		String email = sc.nextLine();
		try{
			Group g = new Group(0,name,email);
			groups.add(g);
		}catch(InvalidNameException e){
			System.err.println("Ugyldig navn.");
			createGroup();
		}catch(InvalidEmailException e){
			System.err.println("Ugyldig epost.");
			createGroup();
		}
		System.out.println(" -------------------- \n");
	}
	
	private Group chooseGroup(){
		System.out.println(" -- Velg gruppe -- ");
		System.out.println("Grupper: " + groups);
		System.out.print("Indeks på gruppe: ");
		int index = sc.nextInt();
		System.out.println(" -------------------- \n");
		return groups.get(index);
	}
	
	private void addToGroup() {
		System.out.println(" -- Legg til i gruppe --");
		Group g = chooseGroup();
		System.out.println(g);
		Employee e = chooseEmployee();
		g.addMember(e);
		System.out.println(" -------------------- \n");
	}
	
	private void createAlarm(){	
	}
	
	private DateTime createDate(){
		System.out.println(" -- Velg tidspunkt -- ");
		System.out.println("Skriv inn dato [YYYY-M-D-H-M]");
		String in = sc.nextLine();
		String[] val = in.split("-");
		int year = Integer.parseInt(val[0]);
		int month = Integer.parseInt(val[1]);
		int day = Integer.parseInt(val[2]);
		int hour = Integer.parseInt(val[3]);
		int min = Integer.parseInt(val[4]);
		System.out.println(" -------------------- \n");
		return new DateTime(year, month, day, hour, min); 
	}
	
	private Room chooseRoom(DateTime start, DateTime end) throws DateTimeException {
		/*
		 * 
		 * OBS! tar ikke høyde for størrelse på rom
		 * 
		 */
		Room room = null;
		if (Room.getFreeRooms(start, end).size() >= 1) {
			room = Room.getFreeRooms(start, end).get(0); 			
		}
		return room; 

	}
	
	private Appointment createAppointment() {
		try {
			System.out.println(" -- Opprett avtale -- ");
			System.out.println(" -- Velg starttidspunkt --");
			DateTime start = createDate();
			System.out.println(" -- Velg slutt-tidspunkt --");
			DateTime end = createDate();
			System.out.println("Beskrivelse: ");
			String description = sc.nextLine();
			ArrayList<User> participants = chooseParticipants();
			Room room = chooseRoom(start, end);
			Appointment app = new Appointment(description, room, currentUser, participants, start, end);
			System.out.println(" -------------------- \n");
			return app;
		} catch (DateTimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RoomBookedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RoomSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		Home h = new Home();
		System.out.println(h.groups);
		h.loadMenu();
	}
}
