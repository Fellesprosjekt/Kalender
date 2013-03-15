package appLogic;
import org.joda.*;

import org.joda.time.DateTime;

public class Alarm {

	private final DateTime time;
	private String label;
	
	public Alarm(DateTime time, String label) {
		this.time = time;
		setLabel(label);
	}
	
	public String getLabel() {
		return this.label;
	}
	
	public DateTime getTime() {
		return this.time;
	}
	
	public void setLabel(String label) throws //Some Exception e{
		if (label.length()<100){
			this.label = label;
		}
		
	}
	
	public void fireAlarm() {
		//TODO: "Noe"
	}
	
	
}
