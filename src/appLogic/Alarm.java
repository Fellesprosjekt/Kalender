package appLogic;

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
	
	public void setLabel(String label) {
		// TODO : restriksjon pa lengde av label ? mtp. database
	}
	
	public void fireAlarm() {
		//TODO
	}
	
	
}
