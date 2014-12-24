package idv.swmac.solarterm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import idv.swmac.entity.SolarTermDetail;
import idv.swmac.entity.SolarTermEntity;
import idv.swmac.entity.SolarTermResult;
import idv.swmac.entity.SolarTermsOfYearEntity;
import idv.swmac.util.CalendarUtil;

public class SolarTermManager {

	private static SolarTermManager instance;
	
	private SolarTermEntity solarTermData;
	//資料直接改成Calendar，不要再用字串去轉換
	private Map<Integer, List<SolarTermDetail>> solarTermMap;
	
	private Date timeMin;
	
	private Date timeMax;
	
	private SolarTermManager() {
		if (solarTermData == null) {
			initSolarTermEntity();
		}
	}
	
	public static SolarTermManager getInstance() {
		if (instance == null) {
			instance = new SolarTermManager();
		}
		return instance;
	}
	
	private void initSolarTermEntity() {
		String termDataString = null;
		try {
			termDataString = getSolarTermStringFromAssets();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (termDataString != null) {
			this.solarTermData = retrieveDataByGson(termDataString);
			timeMin = CalendarUtil.getDateFromString(solarTermData.getStartTime());
			timeMax = CalendarUtil.getDateFromString(solarTermData.getEndTime());
			
			if (solarTermMap != null) {
				solarTermMap.clear();
				solarTermMap = null;
			}
			solarTermMap = new HashMap<Integer, List<SolarTermDetail>>();
			for (SolarTermsOfYearEntity termsOneYear : solarTermData.getTermsEachYear()) {
				solarTermMap.put(termsOneYear.getYear(), termsOneYear.getSolarTerms());
			}
		}
	}

	private String getSolarTermStringFromAssets() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("./assets/solar_terms.json"));
		String readString;
		StringBuilder sb = new StringBuilder();
		while((readString = in.readLine()) != null) {
			sb.append(readString);
		}
		in.close();
		String result = sb.toString();
		result = result.replace("\t", "");
		result = result.replace("\n", "");
		return result;
	}
	
	private SolarTermEntity retrieveDataByGson(String termDataString) {
		Gson gson = new Gson();
		Type type = new TypeToken<SolarTermEntity>(){}.getType();
		SolarTermEntity result = gson.fromJson(termDataString, type);
		return result;
	}
	
	public SolarTermEntity getSolarTermEntity() {
		return this.solarTermData;
	}
	
	public Date getTimeMax() {
		return this.timeMax;
	}
	
	public Date getTimeMin() {
		return this.timeMin;
	}
	
	public SolarTermResult getSolarTermByTime(GregorianCalendar calendar) {
		if (timeMin == null || timeMax == null) {
			return SolarTermResult.getInstance(SolarTermResult.Result.TERM_DATA_ERROR, null);
		} else {
			if (calendar.before(timeMin) || calendar.after(timeMax)) {
				return SolarTermResult.getInstance(SolarTermResult.Result.OUT_OF_RANGE, null);
			} else {
				SolarTerm term = calcSolarTerm(calendar, this.solarTermData);
				if (term == null) {
					return SolarTermResult.getInstance(SolarTermResult.Result.TERM_DATA_ERROR, null);
				} else {
					return SolarTermResult.getInstance(SolarTermResult.Result.OK, term);
				}
			}
		}
	}
	
	private SolarTerm calcSolarTerm(GregorianCalendar calendar, SolarTermEntity solarTermData) {
		if (solarTermData == null || solarTermData.getTermsEachYear() == null) {
			return null;
		} else {
			List<SolarTermDetail> termsOfYear = null;
			// 比立春早，則屬於前一年度
			if (calendar.before(getSolarTermCalendar(calendar.get(Calendar.YEAR), SolarTerm.LI_SPRINT))) {
				termsOfYear = solarTermMap.get(calendar.get(Calendar.YEAR) - 1);
			} else {
				termsOfYear = solarTermMap.get(calendar.get(Calendar.YEAR));
			}
			for (int i = 0; i < termsOfYear.size(); i++) {
//				if (calendar.after(when))
			}
		}
		return null;
	}
	
//	private GregorianCalendar getSolarTermCalendar(int year, SolarTerm term, SolarTermEntity solarTermData) {
//		SolarTermsOfYearEntity termOfYear = null;
//		for (SolarTermsOfYearEntity termEachYear: solarTermData.getTermsEachYear()) {
//			if (termEachYear.getYear() == year) {
//				termOfYear = termEachYear;
//			}
//		}
//		// if null, must be the last year of the legal range.
//		if (termOfYear == null) {
//			termOfYear = solarTermData.getTermsEachYear().get(solarTermData.getTermsEachYear().size() - 1);
//		}
//		GregorianCalendar result = new GregorianCalendar();
//		result.setTime(CalendarUtil.getDateFromString(termOfYear.getSolarTerms().get(term.value()).getTime()));
//		return result;
//	}
	
	private GregorianCalendar getSolarTermCalendar(int year, SolarTerm solarTerm) {
		GregorianCalendar result = null;
		List<SolarTermDetail> termsOneYear = solarTermMap.get(year);
		if (termsOneYear != null) {
			result = new GregorianCalendar();
			result.setTime(CalendarUtil.getDateFromString(termsOneYear.get(solarTerm.value()).getTime()));
		}
		return result;
	}
}
