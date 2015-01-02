package idv.swmac.solarterm;

import idv.swmac.entity.SolarTermDetail;
import idv.swmac.entity.SolarTermsOfYearEntity_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SolarTermManager2 {
	
	private static final String SOLAR_TERM_FILE_NAME = "./assets/solar_terms_2.json";
	
	private static SolarTermManager2 instance;
	
	private Map<Integer, List<SolarTermDetail>> solarTermMap;
	
	private SolarTermManager2() {
		try {
			setSolarTermMap(SOLAR_TERM_FILE_NAME);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	
	public GregorianCalendar getCalendarOfSolarTerm(int year, SolarTerm solarTerm) throws SolarTermManagerException {
		// TODO
		if (solarTermMap != null && solarTermMap.size() > 0) {
			throw new SolarTermManagerException(SolarTermManagerException.CODE_MAP_EMPTY);
		} else if (!this.solarTermMap.containsKey(year)) {
			throw new SolarTermManagerException(SolarTermManagerException.CODE_NO_MATCHED_YEAR);
		}
		
		return null;
	}
	
	private void setSolarTermMap(String dataFileName) throws IOException {
		if (solarTermMap == null) {
			solarTermMap = new HashMap<Integer, List<SolarTermDetail>>();
		} else if (solarTermMap.size() > 0) {
			solarTermMap.clear();
		}
		List<SolarTermsOfYearEntity_2> yearTermList = getDataFromJsonString(readSolarTermsDataStringFromFile(dataFileName));
		if (yearTermList != null && yearTermList.size() > 0) {
			for (SolarTermsOfYearEntity_2 yearTerms : yearTermList) {
				int year = yearTerms.getYear();
				List<SolarTermDetail> termsList = yearTerms.getSolarTerms();
				for (SolarTermDetail termDetail : termsList) {
					termDetail.initCalendar();
				}
				solarTermMap.put(year, termsList);
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
	
	private List<SolarTermsOfYearEntity_2> getDataFromJsonString(String jsonString) {
		System.out.print("jsonString: " + jsonString);
		Gson gson = new Gson();
		Type type = new TypeToken<List<SolarTermsOfYearEntity_2>>(){}.getType();
		List<SolarTermsOfYearEntity_2> result = gson.fromJson(jsonString, type);
		if (result != null && result.size() > 0) {
			for (SolarTermsOfYearEntity_2 eachData : result) {
				eachData.GsonEntityInit();
			}
		}
		return result;
	}
	
	private int getFSYearNumberByCalendar(Calendar calendar) {
		// TODO
		return -1;
	}
}
