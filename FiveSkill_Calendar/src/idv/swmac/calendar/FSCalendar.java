package idv.swmac.calendar;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class FSCalendar {

	private GregorianCalendar calendar;
	
	private int year;
	
	private int month;
	
	private int dayOfMonth;
	
	private int hourOfDay;
	
	private int minute;
	
	private int second;
	
	private int twoHour;
	
	private int solarTerm;
	
	public FSCalendar() {
		this.calendar = new GregorianCalendar();
		this.calendar.setTime(new Date());
		initProperties(this.calendar);
	}
	
	public FSCalendar(GregorianCalendar calendar) {
		this.calendar = calendar;
		initProperties(this.calendar);
	}
	
	public FSCalendar(int year, int month, int dayOfMonth, int hourOfDay, int minute, int second) {
		this(new GregorianCalendar(year, month, dayOfMonth, hourOfDay, minute, second));
	}
	
	private void initProperties(GregorianCalendar calendar) {
		GregorianCalendar showCalendar = new GregorianCalendar();
		showCalendar.setTime(calendar.getTime());
		if (calendar.get(Calendar.HOUR_OF_DAY) >= 23) {
			showCalendar.add(Calendar.DATE, 1);
		}
		this.year = showCalendar.get(Calendar.YEAR);
		this.month = showCalendar.get(Calendar.MONTH);
		this.dayOfMonth = showCalendar.get(Calendar.DAY_OF_MONTH);
		this.hourOfDay = this.calendar.get(Calendar.HOUR_OF_DAY);
		this.minute = this.calendar.get(Calendar.MINUTE);
		this.second = this.calendar.get(Calendar.SECOND);
		this.twoHour = calculateTwoHour(this.hourOfDay);
		this.solarTerm = calculateSolarTerm();
	}
	
	public String getDescription() {
		StringBuilder builder = new StringBuilder();
		builder.append("Date: ").append(this.year).append("-").append(this.month).append("-").append(this.dayOfMonth)
			.append(", Time: ").append(this.hourOfDay).append(":").append(this.minute).append("'").append(this.second)
			.append(", 時辰: ").append(this.twoHour);
		return builder.toString();
	}
	
	private int calculateTwoHour(int hourOfDay) {
		return ((hourOfDay + 1) % 24) / 2;
	}
	
	private int calculateSolarTerm() {
		//TODO
		return 0;
	}

	public GregorianCalendar getCalendar() {
		return calendar;
	}

	public void setTime(int year, int month, int dayOfMonth, int hourOfDay, int minute, int second) {
		this.calendar = new GregorianCalendar(year, month, dayOfMonth, hourOfDay, minute, second);
		initProperties(this.calendar);
	}
	
	public void setCalendar(GregorianCalendar calendar) {
		this.calendar = calendar;
		initProperties(this.calendar);
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDayOfMonth() {
		return dayOfMonth;
	}

	public int getHourOfDay() {
		return hourOfDay;
	}

	public int getMinite() {
		return minute;
	}
	
	public int getSecond() {
		return second;
	}

	public int getTwoHour() {
		return twoHour;
	}
	
	public int getSolarTerm() {
		return solarTerm;
	}
	

}
