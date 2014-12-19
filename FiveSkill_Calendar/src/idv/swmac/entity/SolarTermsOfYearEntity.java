package idv.swmac.entity;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class SolarTermsOfYearEntity implements Serializable {

	private static final long serialVersionUID = -2723361446948579945L;

	@SerializedName("Year")
	private int year;
	
	@SerializedName("SolarTerms")
	private List<SolarTermDetail> solarTerms;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<SolarTermDetail> getSolarTerms() {
		return solarTerms;
	}

	public void setSolarTerms(List<SolarTermDetail> solarTerms) {
		this.solarTerms = solarTerms;
	}
}
