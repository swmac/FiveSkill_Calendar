package idv.swmac.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {

	public static final int DAY_TIME_MILLIS = 3600 * 24 * 1000;
	
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
	
	public static int getDurationDaysBetween2Calendar(Calendar calendar1, Calendar calendar2) {
		int result = 0;
		int duration1 = getDiffDaysFrom19700101(calendar1);
		int duration2 = getDiffDaysFrom19700101(calendar2);
		if (calendar1.compareTo(calendar2) > 0) {
			result = duration1 - duration2;
		} else if (calendar1.compareTo(calendar2) < 0) {
			result = duration2 - duration1;
		}
		return result;
	}
	
	public static int getDiffDaysFrom19700101(Calendar calendar) {
		int result = 0;
		long time = calendar.getTimeInMillis() + calendar.getTimeZone().getRawOffset();
		if (time > 0) {
			result = (int) (time / DAY_TIME_MILLIS);
		} else {
			result = (int) (Math.abs(time) / DAY_TIME_MILLIS);
			if (Math.abs(time) % DAY_TIME_MILLIS > 0) {
				result += 1;
			}
			result = 0 - result;
		}
		return result;
	}
}
