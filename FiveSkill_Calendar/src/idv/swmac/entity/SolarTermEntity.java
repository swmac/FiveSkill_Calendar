package idv.swmac.entity;

import java.io.Serializable;
import java.util.List;

public class SolarTermEntity implements Serializable {

	private static final long serialVersionUID = -3866185335411980104L;

	private int startYear;
	
	private int endYear;
	
	private List<SolarTermsOfYearEntity> termsEachYear;

	public int getStartYear() {
		return startYear;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	public int getEndYear() {
		return endYear;
	}

	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}

	public List<SolarTermsOfYearEntity> getTermsEachYear() {
		return termsEachYear;
	}

	public void setTermsEachYear(List<SolarTermsOfYearEntity> termsEachYear) {
		this.termsEachYear = termsEachYear;
	}
}
