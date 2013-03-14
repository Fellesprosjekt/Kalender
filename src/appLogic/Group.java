package appLogic;
import java.util.ArrayList;


public class Group extends User {

	private String name;
	private ArrayList<Employee> members;
	
	public Group() {
		
	}
	
	private void setGroupName(String name) {
		
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
