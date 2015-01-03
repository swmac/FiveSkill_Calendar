package idv.swmac.entity;

import idv.swmac.util.CalendarUtil;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class SolarTermsOfYearEntity implements Serializable, GsonInitEntity {

	private static final long serialVersionUID = -6029539748598915885L;

	@SerializedName("Year")
	private int year;
	
	@SerializedName("Start")
	private String start;
	
	@SerializedName("End")
	private String end;
	
	@SerializedName("SolarTerms")
	private List<SolarTermDetail> solarTerms;
	
	private GregorianCalendar startCalendar;
	
	private GregorianCalendar endCalendar;
	
	public SolarTermsOfYearEntity() {
//		init();
	}

//	public void init() {
//		this.startCalendar = new GregorianCalendar();
//		this.endCalendar = new GregorianCalendar();
//		startCalendar.setTime(CalendarUtil.getDateFromString(start));
//		endCalendar.setTime(CalendarUtil.getDateFromString(end));
//	}
	
	@Override
	public void GsonEntityInit() {
		this.startCalendar = new GregorianCalendar();
		this.endCalendar = new GregorianCalendar();
		startCalendar.setTime(CalendarUtil.getDateFromString (start));
		endCalendar.setTime(CalendarUtil.getDateFromString(end));
	}	
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public List<SolarTermDetail> getSolarTerms() {
		return solarTerms;
	}

	public void setSolarTerms(List<SolarTermDetail> solarTerms) {
		this.solarTerms = solarTerms;
	}

	public GregorianCalendar getStartCalendar() {
		return startCalendar;
	}

	public GregorianCalendar getEndCalendar() {
		return endCalendar;
	}
}
