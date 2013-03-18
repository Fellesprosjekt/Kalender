package gui;

import java.util.Scanner;

import exceptions.InvalidEmailException;
import exceptions.InvalidNameException;

import appLogic.Employee;

public class Home {
	Scanner sc;
	
	public Home(){
		sc = new Scanner(System.in);
	}
	
	private Employee createEmployee(){
		System.out.println("Name: ");
		String name = sc.nextLine();
		System.out.println("Email: ");
		String email = sc.nextLine();
		System.out.println();
		try {
			return new Employee(name, email);
		} catch (InvalidNameException e) {
			System.err.println("Ugyldig navn");
			createEmployee();
		} catch (InvalidEmailException e) {
			System.err.println("Ugyldig email");
			createEmployee();
		}
		return null;
	}
	
	private void createGroup(){
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Name: ");
		String name = sc.nextLine();
	}
	
	public static void main(String[] args) {
		Home h = new Home();
		h.createGroup();
		h.createEmployee();
	}
}
