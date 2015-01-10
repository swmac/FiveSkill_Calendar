package idv.swmac.calendar;

import idv.swmac.solarterm.SolarTerm;
import idv.swmac.solarterm.SolarTermManager;

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
	
	private SolarTerm solarTerm;
	
	private byte[] pillars = new byte[8];
	
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
		initTimes(calendar);
		initSolarTerm(calendar);
		initPillars(this.pillars, this.year, this.month, this.dayOfMonth, this.hourOfDay, this.minute, this.second);
	}

	private void initPillars(byte[] pillars, int year, int month, int dayOfMonth, int hourOfDay, int minute, int second) {
		calcYearPillars(pillars, this.solarTerm.getYear());
		calcMonthPillars(pillars, this.solarTerm);
		calcDayPillars(pillars, year, month, dayOfMonth, hourOfDay, minute, second);
		calcHourPillars(pillars, hourOfDay);
	}

	private void initTimes(Calendar calendar) {
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
//		this.twoHour = calculateTwoHour(this.hourOfDay);
	}
	
	private void initSolarTerm(GregorianCalendar calendar) {
		this.solarTerm = SolarTermManager.getInstance().getSolarTermFromCalendar(calendar);
	}
	
	private void calcYearPillars(byte[] pillars, int fsYear) {
		pillars[0] = PillarUtil.getYearStem(fsYear);
		pillars[1] = PillarUtil.getYearBranch(fsYear);
	}
	
	private void calcMonthPillars(byte[] pillars, SolarTerm solarTerm) {
		pillars[3] = PillarUtil.getMonthBranch(solarTerm);
		pillars[2] = PillarUtil.getMonthStem(pillars[0], pillars[3]);
	}
	
	private void calcDayPillars(byte[] pillars, int year, int month,
			int dayOfMonth, int hourOfDay, int minute, int second) {
		byte[] result = PillarUtil.getDayStemBranch(year, month, dayOfMonth);
		pillars[4] = result[0];
		pillars[5] = result[1];
	}
	
	private void calcHourPillars(byte[] pillars, int twoHour) {
		// TODO Auto-generated method stub
		pillars[7] = PillarUtil.getHourBranch(twoHour);
		pillars[6] = PillarUtil.getHourStem(pillars[4], pillars[7]);
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
		return pillars[7];
	}
	
	public SolarTerm getSolarTerm() {
		return solarTerm;
	}
	
	public byte[] getPillars() {
		return this.pillars;
	}
	
	public String getDescription() {
		StringBuilder builder = new StringBuilder();
		builder.append("Date: ").append(this.year).append("-").append(this.month).append("-").append(this.dayOfMonth)
			.append(", Time: ").append(this.hourOfDay).append(":").append(this.minute).append("'").append(this.second)
			.append(", 時辰: ").append(this.pillars[7]);
		return builder.toString();
	}
}
