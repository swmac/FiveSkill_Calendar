package idv.swmac.solarterm;

import idv.swmac.entity.SolarTermDetail;
import idv.swmac.entity.SolarTermsOfYearEntity;
import idv.swmac.util.CalendarUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SolarTermManager {

	public static final String KEY_TIME_RANGE_START = "timeRangeKey_START";
	public static final String KEY_TIME_RANGE_END = "timeRangeKey_END";
	
	private static final String SOLAR_TERM_FILE_NAME = "./assets/solar_terms_2.json";
	
	private static SolarTermManager instance;
	
	private Map<Integer, List<SolarTermDetail>> solarTermMap;
	
	private List<Map<String, Calendar>> availableTimeRangeList;
	
	private SolarTermManager() {
		try {
			setSolarTermData(SOLAR_TERM_FILE_NAME);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SolarTermManager getInstance() {
		if (instance == null) {
			instance = new SolarTermManager();
		}
		return instance;
	}
	
	public Map<Integer, List<SolarTermDetail>> getSolarTermMap() {
		return this.solarTermMap;
	}
	
	public SolarTerm getSolarTermFromCalendar(Calendar calendar) throws SolarTermManagerException {
		if (availableTimeRangeList == null || availableTimeRangeList.size() <= 0) {
			throw new SolarTermManagerException(SolarTermManagerException.CODE_AVAILABLETIMERANGE_EMPTY);
		}
		int year = -1;
		for (Map<String, Calendar> rangeMap : availableTimeRangeList) {
			if (calendar.compareTo(rangeMap.get(KEY_TIME_RANGE_START)) >= 0 && calendar.compareTo(rangeMap.get(KEY_TIME_RANGE_END)) < 0) {
				year = rangeMap.get(KEY_TIME_RANGE_START).get(Calendar.YEAR);
			}
		}
		if (year < 0) {
			throw new SolarTermManagerException(SolarTermManagerException.CODE_OUTOFAVAILABLETIMERANGE, calendar.get(Calendar.YEAR));
		}
		List<SolarTermDetail> termList = getTermListByYear(year);
		int termIndex = 23;
		for (int i = 0; i < termList.size() - 1; i++) {
			Calendar termStart = termList.get(i).getCalendar();
			Calendar termEnd = termList.get(i + 1).getCalendar();
			if (calendar.compareTo(termStart) >= 0 && calendar.compareTo(termEnd) < 0) {
				termIndex = i;
			}
		}
		return SolarTerm.values()[termIndex];
	}
	
	public GregorianCalendar getCalendarOfSolarTerm(int year, SolarTerm solarTerm) throws SolarTermManagerException {
		List<SolarTermDetail> termList = getTermListByYear(year);
		GregorianCalendar result = termList.get(solarTerm.ordinal()).getCalendar();
		if (result == null) {
			throw new SolarTermManagerException(SolarTermManagerException.CODE_NO_MATCHED_TERM, year);
		}
		return result;
	}
	
	public List<SolarTermDetail> getTermListByYear(int fsYear)  throws SolarTermManagerException {
		if (solarTermMap == null || solarTermMap.size() <= 0) {
			throw new SolarTermManagerException(SolarTermManagerException.CODE_SOLARTERMMAP_EMPTY);
		}
		List<SolarTermDetail> termList = solarTermMap.get(fsYear);
		if (termList == null || termList.size() <= 0) {
			throw new SolarTermManagerException(SolarTermManagerException.CODE_NO_MATCHED_YEAR, fsYear);
		}
		return termList;
	}
	
	public void setSolarTermData(String dataFileName) throws IOException {
		// Reset solarTimeMap
		if (solarTermMap == null) {
			solarTermMap = new HashMap<Integer, List<SolarTermDetail>>();
		} else if (solarTermMap.size() > 0) {
			solarTermMap.clear();
		}
		// Reset availableTimeRanges
		if (availableTimeRangeList == null) {
			availableTimeRangeList = new ArrayList<Map<String, Calendar>>();
		} else if (availableTimeRangeList.size() > 0) {
			availableTimeRangeList.clear();
		}
		// Set Data
		List<SolarTermsOfYearEntity> yearTermList = getDataFromJsonString(readSolarTermsDataStringFromFile(dataFileName));
		if (yearTermList != null && yearTermList.size() > 0) {
			for (SolarTermsOfYearEntity yearTerms : yearTermList) {
				addSolarTermMap(solarTermMap, yearTerms);
				addAvailableTimeRanges(availableTimeRangeList, yearTerms);
			}
		}
	}
	
	private String readSolarTermsDataStringFromFile (String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String bufferString;
		StringBuilder sb = new StringBuilder();
		while((bufferString = reader.readLine()) != null) {
			sb.append(bufferString);
		}
		reader.close();
		String result = sb.toString();
		result.replace("\t", "");
		result.replace("\n", "");
		return result;
	}
	
	private List<SolarTermsOfYearEntity> getDataFromJsonString(String jsonString) {
		Gson gson = new Gson();
		Type type = new TypeToken<List<SolarTermsOfYearEntity>>(){}.getType();
		List<SolarTermsOfYearEntity> result = gson.fromJson(jsonString, type);
		if (result != null && result.size() > 0) {
			for (SolarTermsOfYearEntity eachData : result) {
				eachData.GsonEntityInit();
			}
		}
		return result;
	}
	
	private void addSolarTermMap(Map<Integer, List<SolarTermDetail>> solarTermMap, SolarTermsOfYearEntity yearTermsData) {
		int year = yearTermsData.getYear();
		List<SolarTermDetail> termsList = yearTermsData.getSolarTerms();
		for (SolarTermDetail termDetail : termsList) {
			termDetail.initCalendar();
		}
		solarTermMap.put(year, termsList);
	}
	
	private void addAvailableTimeRanges(List<Map<String, Calendar>> availableTimeRangeList, SolarTermsOfYearEntity yearTermsData) {
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		start.setTime(CalendarUtil.getDateFromString(yearTermsData.getStart()));
		end.setTime(CalendarUtil.getDateFromString(yearTermsData.getEnd()));
		Map<String, Calendar> rangeMap = new HashMap<String, Calendar>();
		rangeMap.put(KEY_TIME_RANGE_START, start);
		rangeMap.put(KEY_TIME_RANGE_END, end);
		availableTimeRangeList.add(rangeMap);
	}
}
