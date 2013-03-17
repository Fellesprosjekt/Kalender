package appLogic;

import java.util.ArrayList;

import exceptions.InvalidEmailException;
import exceptions.InvalidNameException;

public class Employee extends User{

	private String firstname;
	private String lastname;
	
	
	public Employee(String name, String email) throws InvalidNameException, InvalidEmailException{
		super(email);
		setEmployeeName(name);
	}

	private void setEmployeeName(String name) throws InvalidNameException {
		if(!isValidName(name)) throw new InvalidNameException();
		else{
			String[] fullname = name.split(" ");
			firstname = fullname[0];
			lastname = "";
			for(int i = 1; i<fullname.length; i++){
				lastname+=fullname[i];
				lastname+=" ";
			}
			lastname.trim();
		}	
	}
	
	public String getFirstName(){
		return firstname;
	}
	
	public String getLastname(){
		return lastname;
	}
	
	private boolean isValidName(String name){
		if(name.length()>30) return false;
		String[] fullname = name.split(" ");
		if(fullname.length>=2){
			for(String s : fullname){
				s.trim();
				for(int i = 0; i < s.length(); i++){
					if(!Character.isLetter(s.charAt(i))) return false;
				}
			}
			return true;
		}
		return false;
	}
}
