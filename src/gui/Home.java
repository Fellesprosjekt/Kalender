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
	
	private void createEmployee(){
		try {
			System.out.println("Name: ");
			String name = sc.nextLine();
			System.out.println("Email: ");
			String email = sc.nextLine();
			System.out.println();
			Employee e = new Employee(name, email);
			employees.add(e); 
		} catch (InvalidNameException e) {
			System.err.println("Ugyldig navn");
		} catch (InvalidEmailException e) {
			System.err.println("Ugyldig email");
		}
	}

	private Employee chooseEmployee(){
		System.out.println("Ansatte: " + employees);
		System.out.print("Skriv inn etternavn > ");
		String last = sc.nextLine();
		for (Employee e : employees){
			if (e.getLastname().equals(last)) {
				return e;
			}
		}
		return null;
	}
	
	private Group createGroup(){
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.println();
		try{
			Group g = new Group(name,email);
			return g;
		}catch(InvalidNameException e){
			System.err.println("Ugyldig navn.");
			createGroup();
		}catch(InvalidEmailException e){
			System.err.println("Ugyldig epost.");
			createGroup();
		}
		return null;
	}
	
	private Group chooseGroup(){
		System.out.println("Grupper: " + groups);
		System.out.print("Skriv inn gruppenavn > ");
		String name = sc.nextLine();
		for (Group g : groups){
			if (g.getName().equals(name)){
				return g;
			}
		}
		return null;
	}
	
	
	private void addToGroup() {
		
	}

	
	private void createAlarm(){
		System.out.println(employees);
	}
	
	
	public static void main(String[] args) {
		Home h = new Home();
		h.createEmployee();
		h.createEmployee();
		h.createAlarm();
		//h.createGroup();
	}
}