package gui;

import java.util.ArrayList;
import java.util.Scanner;

import exceptions.InvalidEmailException;
import exceptions.InvalidNameException;

import appLogic.Employee;
import appLogic.Group;

public class Home {
	Scanner sc;
	ArrayList<Group> groups = new ArrayList<Group>();
	ArrayList<Employee> employees = new ArrayList<Employee>();
	Employee currentUser;
	
	public Home(){
		sc = new Scanner(System.in);
	}
	
	private void loadMenu(){
		System.out.println(" -- Meny, velg funksjon --");
		System.out.println("'r' --> Registrer ansatt");
		System.out.println("'l' --> Logg inn ansatt");
		System.out.print("Funksjon: ");
		char valg = sc.nextLine().charAt(0);
		switch(valg){
		case('r'):
			createEmployee();
			break;
		case('l'):
			chooseEmployee();
			break;
		default:
			System.err.println("Ugyldig kommando.");
			break;
		}
	}
	
	private void createEmployee(){
		System.out.println("-- Registrer ansatt -- ");
		try {
			System.out.print("Navn: ");
			String name = sc.nextLine();
			System.out.print("Epost: ");
			String email = sc.nextLine();
			System.out.println();
			Employee e = new Employee(0, name, email);
			employees.add(e); 
		} catch (InvalidNameException e) {
			System.err.println("Ugyldig navn");
		} catch (InvalidEmailException e) {
			System.err.println("Ugyldig email");
		}
		System.out.println("-------------------- \n");
	}

	private Employee chooseEmployee(){
		System.out.println("-- Velg ansatt --");
		for(int i = 0; i<employees.size(); i++){
			System.out.println(String.format("%d. %s %s", i+1,employees.get(i).getFirstName(),employees.get(i).getLastname()));
		}
		System.out.print("Ansattnummer: ");
		int index = sc.nextInt()-1;
		System.out.println("--------------------\n");
		return employees.get(index);
	}
	
	private void createGroup(){
		System.out.println(" -- Opprett gruppe -- ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
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
		System.out.println(employees);
	}
	
	public static void main(String[] args) {
		Home h = new Home();
		try {
			h.employees.add(new Employee(0, "Peter Sandberg", "peter.sandberg@live.no"));
			h.employees.add(new Employee(1, "Ola Nordmann", "ola.nordmann@live.no"));
		} catch (InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidEmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		h.loadMenu();
//		h.createEmployee();
//		h.createEmployee();
//		h.createGroup();
//		h.addToGroup();
//		h.addToGroup();
	}
}
