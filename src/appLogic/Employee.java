package appLogic;

import java.util.ArrayList;

public class Employee extends User{

	private String firstname;
	private String lastname;
	
	
	public Employee(String name, String email) throws InvalidNameException{
		super(email);
		setEmployeeName(name);
	}

	private void setEmployeeName(String name) throws InvalidNameException {
		if(!validateName(name)) throw new InvalidNameException();
		else{
			String[] fullname = name.split(" ");
			firstname = fullname[0];
			for(int i = 1; i<fullname.length; i++){
				lastname+=fullname[i];
				lastname+=" ";
			}
			lastname.trim();
		}	
	}
	
	public String getFirstNnme(){
		return firstname;
	}
	
	public String getLastname(){
		return firstname;
	}
	
	private boolean validateName(String name){
		String[] fullname = name.split(" ");
		if(fullname.length>=2){
			for(String s : fullname){
				s.trim();
				for(int i = 0; i < s.length(); i++){
					if(!Character.isLetter(name.charAt(i))) break;
				}
			}
		}
		return false;
	}
}
