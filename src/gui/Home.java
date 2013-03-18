package gui;

import java.util.ArrayList;
import java.util.Scanner;

import exceptions.InvalidEmailException;
import exceptions.InvalidNameException;

import appLogic.Employee;
import appLogic.Group;

public class Home {
	Scanner sc;
	ArrayList<Group> groups;
	ArrayList<Employee> employees;
	
	public Home(){
		sc = new Scanner(System.in);
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
	
	private void createEmployee(){
		
	}
	
	public static void main(String[] args) {
		Home h = new Home();
		h.createGroup();
	}
}
