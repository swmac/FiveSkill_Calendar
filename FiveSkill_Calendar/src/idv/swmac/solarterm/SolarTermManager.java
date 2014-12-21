package idv.swmac.solarterm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.GregorianCalendar;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import idv.swmac.entity.SolarTermEntity;

public class SolarTermManager {

	private static SolarTermManager instance;
	
	private SolarTermEntity solarTermData;
	
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
	
	public SolarTerm calcSolarTerm(GregorianCalendar calendar) {
		// TODO
		if (solarTermData != null) {
			
		} else {
			return null;
		}
		return null;
	}
}
