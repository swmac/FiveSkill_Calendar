package idv.swmac.calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;

import idv.swmac.solarterm.SolarTerm;
import idv.swmac.util.CalendarUtil;

public class PillarUtil {

	private static PillarUtil instance;
	
	private PillarUtil() {
		
	}
	
	public static PillarUtil getInstance() {
		if (instance == null) {
			instance = new PillarUtil();
		}
		return instance;
	}
	
	public static byte getYearStem(int fsYear) {
		byte result = (byte)((fsYear + 6) % 10);
		return result;
	}
	
	public static byte getYearBranch(int fsYear) {
		byte result = (byte)((fsYear + 8) % 12);
		return result;
	}
	
	public static byte getMonthBranch(SolarTerm solarTerm) {
		byte result = (byte)((solarTerm.value() / 2 + 2) % 12);
		return result;
	}
	
	public static byte getMonthStem(byte yearStem, byte monthBranch) {
		int startStem = ((yearStem % 5) * 2 + 2) % 10;
		int delta = (monthBranch + 10) % 12;
		return (byte) ((startStem + delta) % 10);
	}
	
	public static byte[] getDayStemBranch(int fsYear, int fsMonth, int fsDay) {
		byte[] result = new byte[2];
		Calendar ca0 = new GregorianCalendar(1912, Calendar.FEBRUARY, 18);
		Calendar ca1 = new GregorianCalendar(fsYear, fsMonth, fsDay);
		int delta = CalendarUtil.getDurationDaysBetween2Calendar(ca0, ca1);
		if (ca0.compareTo(ca1) < 0) {
			System.out.println("delta = " + delta);
			result[0] = (byte) (delta % 10);
			result[1] = (byte) (delta % 12);
		} else {
			result[0] = (byte) (10 - (delta % 10));
			result[1] = (byte) (12 - (delta % 12));
		}
		return result;
	}
		
	public static byte getHourBranch(int hourOfDay) {
		return (byte)(((hourOfDay + 1) % 24) / 2);
	}
	
	public static byte getHourStem(int dayStem, int hourBranch) {
		int startStem = (dayStem % 5) * 2;
		return (byte) ((startStem + hourBranch) % 10);
	}
}
