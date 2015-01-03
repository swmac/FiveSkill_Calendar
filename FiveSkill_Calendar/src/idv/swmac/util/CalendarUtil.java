package idv.swmac.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalendarUtil {

	public static Date getDateFromString(String timeString) {
		Date result = null;
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
		try {
			result = sdf.parse(timeString);
		} catch (ParseException e) {
			System.out.println("Exception: getDateFromString");
			e.printStackTrace();
		}
		return result;
	}
	
	public static String getStringForDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		return sdf.format(date);
	}
}
