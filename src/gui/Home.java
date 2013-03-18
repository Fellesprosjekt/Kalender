package gui;

import java.util.Scanner;

public class Home {
	Scanner sc;
	
	public Home(){
		sc = new Scanner(System.in);
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
	}
}
