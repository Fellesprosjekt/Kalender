package appLogic;

import java.util.ArrayList;
import java.util.HashMap;

import org.joda.time.DateTime;

import exceptions.InvalidAlarmException;
import exceptions.InvalidEmailException;
import exceptions.InvalidNameException;

public class Employee extends User{
	private String firstname;
	private String lastname;
	private ArrayList<Alarm> alarms;
	
	
	public Employee(int id, String name, String email) throws InvalidNameException, InvalidEmailException{
		super(id, email);
		setEmployeeName(name);
		alarms = new ArrayList<Alarm>();
	}

	private void setEmployeeName(String name) throws InvalidNameException{
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
	
	public ArrayList<Alarm> getAlarms(){
		return alarms;
	}
	
	public void addAlarm(Alarm alarm) throws InvalidAlarmException{
		if(!isValidAlarm(alarm)) throw new InvalidAlarmException();
		else alarms.add(alarm);
	}
	
	public void removeAlarm(Alarm alarm){
		if(alarms.contains(alarm)) alarms.remove(alarm);
	}
	
	public boolean isValidAlarm(Alarm alarm){
		HashMap<Appointment,DateTime> test = new HashMap<Appointment, DateTime>();
		for(Alarm a : alarms){
			Appointment app = a.getAppointment();
			DateTime dt = a.getTime();
			if(test.containsKey(app)){
				if(test.get(app).equals(dt)) return false;
			}else test.put(app, dt);
		}
		return true;
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

	@Override
	public String toString() {
		return firstname + " " + lastname;
	}
}


