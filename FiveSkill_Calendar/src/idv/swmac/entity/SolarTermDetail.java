package idv.swmac.entity;

import java.io.Serializable;

public class SolarTermDetail implements Serializable {

	private static final long serialVersionUID = -6907140451873412619L;

	private String name;
	
	private String time;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
