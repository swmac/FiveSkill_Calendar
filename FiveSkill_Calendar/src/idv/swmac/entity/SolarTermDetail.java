package idv.swmac.entity;

import idv.swmac.util.CalendarUtil;

import java.io.Serializable;
import java.util.GregorianCalendar;

import com.google.gson.annotations.SerializedName;

public class SolarTermDetail implements Serializable {

	private static final long serialVersionUID = -6907140451873412619L;

	@SerializedName("Name")
	private String name;
	
	@SerializedName("Time")
	private String time;

	private GregorianCalendar calendar;
	
	public void initCalendar() {
		if (calendar == null) {
			calendar = new GregorianCalendar();
		}
		calendar.setTime(CalendarUtil.getDateFromString(time));
	}
	
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
	
	public GregorianCalendar getCalendar() {
		return this.calendar;
	}
}
