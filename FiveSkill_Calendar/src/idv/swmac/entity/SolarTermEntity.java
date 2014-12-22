package idv.swmac.entity;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class SolarTermEntity implements Serializable {

	private static final long serialVersionUID = -3866185335411980104L;

	@SerializedName("StartTime")
	private String startTime;
	
	@SerializedName("EndTime")
	private String endTime;
	
	@SerializedName("TermsEachYear")
	private List<SolarTermsOfYearEntity> termsEachYear;

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public List<SolarTermsOfYearEntity> getTermsEachYear() {
		return termsEachYear;
	}

	public void setTermsEachYear(List<SolarTermsOfYearEntity> termsEachYear) {
		this.termsEachYear = termsEachYear;
	}
}
