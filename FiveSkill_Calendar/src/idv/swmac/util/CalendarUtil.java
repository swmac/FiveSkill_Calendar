package idv.swmac.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalendarUtil {

	public static Date getDateFromString(String timeString) throws ParseException {
		Date result;
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
		result = sdf.parse(timeString);
		return result;
	}
}
