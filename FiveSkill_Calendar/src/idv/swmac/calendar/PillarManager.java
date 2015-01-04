package idv.swmac.calendar;

import idv.swmac.solarterm.SolarTerm;

public class PillarManager {

	private static PillarManager instance;
	
	private PillarManager() {
		
	}
	
	public static PillarManager getInstance() {
		if (instance == null) {
			instance = new PillarManager();
		}
		return instance;
	}
	
	public byte getYearStem(int fsYear) {
		byte result = (byte)((fsYear + 6) % 10);
		return result;
	}
	
	public byte getYearBranch(int fsYear) {
		byte result = (byte)((fsYear + 8) % 12);
		return result;
	}
	
	public byte getMonthBranch(SolarTerm solarTerm) {
		// TODO
		return -1;
	}
	
	public byte getMonthStem(byte yearStem, byte monthBranch) {
		// TODO 五虎遁
		return -1;
	}
	
	public byte getDayStem(int fsYear, int fsMonth, int fsDay) {
		// TODO
		return -1;
	}
	
	public byte getDayBranch(int fsYear, int fsMonth, int fsDay) {
		// TODO
		return -1;
	}
	
	public byte getHourBranch(int twoHour) {
		// TODO
		return -1;
	}
	
	public byte getHourStem(int dayStem, int hourBranch) {
		// TODO 五鼠遁
		return -1;
	}
}
