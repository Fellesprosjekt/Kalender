package appLogic;


public class DateTime implements Comparable<DateTime> {

	/*
	 * Vi bruker heller 'joda time'
	 * dvs:
	 *  import org.joda.time.*
	 *
	 * 
	 */
	
//	private final int year;
//	private final int month;
//	private final int day;
//	private final int hours;
//	private final int minutes;
//
//	
//	public DT(int year, int month, int day, int hours, int minutes) {
//		this.year = year;
//		this.month = month;
//		this.day = day;
//		this.hours = hours;
//		this.minutes = minutes;		
//	}
//	
//	
//	
//	public int getYear() {
//		return year;
//	}
//	public int getMonth() {
//		return month;
//	}
//	public int getDay() {
//		return day;
//	}
//	public int getHours() {
//		return hours;
//	}
//	public int getMinutes() {
//		return minutes;
//	}
//	
//	public int timeTo(DT other) {
//		return 1;
//	}
//	
//	public DT endTime(int durationMinutes) {
//		return null;
//	}

//	/* en DateTime er storre hvis den kommer senere i tid */
//	@Override
//	public int compareTo(DT other) {
//		if (this.year > other.year) {return 1;}
//		if (this.year < other.year) {return -1;}
//		if (this.month > other.month) {return 1;}
//		if (this.month < other.month) {return -1;}
//		if (this.day > other.day) {return 1;}
//		if (this.day < other.day) {return -1;}
//		if (this.hours > other.hours) {return 1;}
//		if (this.hours < other.hours) {return -1;}
//		if (this.minutes > other.minutes) {return 1;}
//		if (this.minutes < other.minutes) {return -1;}
//		return 0; 
//	}
//	
//	/* returnerer DD-MM-YYYY HH:MM */
//	public String toString() {
//		String dt = "";
//		dt += (day < 10 ? "0" + day + "-" : day + "-");		
//		dt += (month < 10 ? "0" + month + "-" : month + "-");
//		dt += year + " ";
//		dt += (hours < 10 ? "0" + hours + ":" : hours + ":");
//		dt += (minutes < 10 ? "0" + minutes + " " : minutes + " ");
//		return dt; 
//	}
}
