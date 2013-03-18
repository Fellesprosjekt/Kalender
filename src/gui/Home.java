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
			System.out.println("-- Velg ansatt --");
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
		h.loadMenu();
		h.createEmployee();
		h.createEmployee();
		h.createGroup();
		h.addToGroup();
		h.addToGroup();
	}
}
