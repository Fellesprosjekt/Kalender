package appLogic;

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
	
	/* sorger for at label ikke blir lenger enn 100 tegn */
	public void setLabel(String label) {
		if (label.length()<100){
			this.label = label;
		} else {
			this.label = label.substring(0, 99); 
		}
	}
	
	public void fireAlarm() {
		//TODO: "Noe"
	}
	
}
