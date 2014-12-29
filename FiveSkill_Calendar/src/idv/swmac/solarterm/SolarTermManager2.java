package idv.swmac.solarterm;

import idv.swmac.entity.SolarTermDetail;
import idv.swmac.entity.SolarTermsOfYearEntity_2;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

public class SolarTermManager2 {

	private static SolarTermManager2 instance;
	
	private Map<Integer, List<SolarTermDetail>> solarTermMap;
	
	private SolarTermManager2() {
		setSolarTermMap();
	}
	
	public static SolarTermManager2 getInstance() {
		if (instance == null) {
			instance = new SolarTermManager2();
		}
		return instance;
	}
	
	public Map<Integer, List<SolarTermDetail>> getSolarTermMap() {
		return this.solarTermMap;
	}
	
	public SolarTerm getSolarTermFromCalendar(Calendar calendar) {
		// TODO
		return null;
	}
	
	public GregorianCalendar getCalendarOfSolarTerm(int year, SolarTerm solarTerm) {
		// TODO
		return null;
	}
	
	private void setSolarTermMap() {
		// TODO Read JSON to Map
	}
	
	private String readSolarTermsDataStringFromFile (String fileName) {
		// TODO
		return null;
	}
	
	private List<SolarTermsOfYearEntity_2> getDataFromJsonString(String jsonString) {
		// TODO
		return null;
	}
	
	private int getFSYearNumberByCalendar(Calendar calendar) {
		// TODO
		return -1;
	}
}
