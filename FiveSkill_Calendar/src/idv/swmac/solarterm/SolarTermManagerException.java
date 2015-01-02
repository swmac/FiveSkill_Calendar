package idv.swmac.solarterm;

public class SolarTermManagerException extends RuntimeException {

	private static final long serialVersionUID = -1486012705561807004L;

	public static final int CODE_DEFAULT = 0;
	public static final int CODE_MAP_EMPTY = 1;
	public static final int CODE_NO_MATCHED_YEAR = 2;
	public static final int CODE_NO_MATCHED_TERM = 3;
	
	private int code;
	
	public SolarTermManagerException() {
		super();
	}
	
	public SolarTermManagerException(String detailMessage) {
		super(detailMessage);
	}
	
	public SolarTermManagerException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}
	
	public SolarTermManagerException(Throwable throwable) {
		super(throwable);
	}
	
	public SolarTermManagerException(int code) {
		this(getDescription(code));
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}
	
	private static String getDescription(int code) {
		String result = "";
		switch(code) {
		case CODE_MAP_EMPTY:
			result = "solarTermMap is null or empty.";
		case CODE_NO_MATCHED_YEAR:
			result = "solarTerMap has no data matceh the input year.";
		case CODE_NO_MATCHED_TERM:
			result = "No matched term for the input data.";
		}
		return result;
	}
}
