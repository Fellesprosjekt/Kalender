package appLogic;
import java.util.ArrayList;


public class Group extends User {

	private String name;
	private ArrayList<Employee> members;
	
	public Group(String name, String email) throws InvalidEmailException, InvalidNameException{
		super(email);
		setGroupName(name);
	}
	
	private void setGroupName(String name) throws InvalidNameException{
		if(!isValidName(name)) throw new InvalidNameException();
		else this.name = name;
	}
	
	private boolean isValidName(String name){
		if(name.length()>30) return false;
		for(int i = 0; i < name.length(); i++){
			if(!Character.isLetterOrDigit(name.charAt(i))) return false;
		}
		return true;
	}
	
	public ArrayList<Employee> getMembers(){
		return members;
	}
	
	public void addMember(Employee employee) {
		members.add(employee);
	}
	
	public void removeMember(Employee employee) {
		members.remove(employee);
	}
	
	public String getName(){
		return name;
	}
}
