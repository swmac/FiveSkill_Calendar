package idv.swmac.test;

import java.io.File;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class SystemDemo {

	public static void main(String[] args) {
		File file = new File("./assets/solar_terms.json");
		System.out.println("Exist the file? Ans." + file.isFile());
		GregorianCalendar ca1 = new GregorianCalendar(1969, 11, 31, 23, 59, 59);
		GregorianCalendar ca2 = new GregorianCalendar(1970, 0, 1, 0, 0, 0);
		GregorianCalendar ca3 = new GregorianCalendar(1970, 0, 1, 0, 0, 1);
		System.out.println("ca1:" + (ca1.getTimeInMillis() + ca1.getTimeZone().getRawOffset()));
		System.out.println("ca2:" + (ca2.getTimeInMillis() + ca2.getTimeZone().getRawOffset()));
		System.out.println("ca3:" + (ca3.getTimeInMillis() + ca3.getTimeZone().getRawOffset()));
		TimeZone tz1 = ca1.getTimeZone();
		System.out.println("tz1 millis:" + tz1.getRawOffset());
	}
}
