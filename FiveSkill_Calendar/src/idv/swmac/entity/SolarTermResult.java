package idv.swmac.entity;

import idv.swmac.solarterm.SolarTerm;

import java.io.Serializable;

public class SolarTermResult implements Serializable {

	private static final long serialVersionUID = -8081835815276511204L;

	public enum Result {
		OK("OK"),
		TERM_DATA_ERROR("Term data is null or broken."),
		OUT_OF_RANGE("The time is out of range!");
		
		
		private String description;
		
		private Result(String description) {
			this.description = description;
		}

		@Override
		public String toString() {
			return this.description;
		}
	}
	
	private Result result;
	
	private SolarTerm solarTerm;

	private SolarTermResult(Result result, SolarTerm solarTerm) {
		this.result = result;
		this.solarTerm = solarTerm;
	}
	
	public static SolarTermResult getInstance(Result result, SolarTerm solarTerm) {
		return new SolarTermResult(result, solarTerm);
	}
	
	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public SolarTerm getSolarTerm() {
		return solarTerm;
	}

	public void setSolarTerm(SolarTerm solarTerm) {
		this.solarTerm = solarTerm;
	}
}
