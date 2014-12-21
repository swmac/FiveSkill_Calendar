package idv.swmac.test;

import static org.junit.Assert.*;
import idv.swmac.calendar.FSCalendar;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

public class TestCalendar {
	
	private FSCalendar ca;
	
	@Before
	public void setUp() {
		ca = new FSCalendar();
	}
	
	@Test
	public void test() {
		//Normal
		ca.setTime(2014, Calendar.DECEMBER, 19, 0, 4, 0);
		assertEquals(2014, ca.getYear());
		assertEquals(Calendar.DECEMBER, ca.getMonth());
		assertEquals(19, ca.getDayOfMonth());
		assertEquals(0, ca.getHourOfDay());
		assertEquals(4, ca.getMinite());
		assertEquals(0, ca.getSecond());
		assertEquals(0, ca.getTwoHour());
		//End of year
		ca.setTime(2014, Calendar.DECEMBER, 31, 23, 30, 30);
		assertEquals(2015, ca.getYear());
		assertEquals(Calendar.JANUARY, ca.getMonth());
		assertEquals(1, ca.getDayOfMonth());
		assertEquals(23, ca.getHourOfDay());
		assertEquals(30, ca.getMinite());
		assertEquals(30, ca.getSecond());
		assertEquals(0, ca.getTwoHour());
		//Leap
		ca.setTime(2012, Calendar.FEBRUARY, 28, 23, 30, 30);
		assertEquals(2012, ca.getYear());
		assertEquals(Calendar.FEBRUARY, ca.getMonth());
		assertEquals(29, ca.getDayOfMonth());
		assertEquals(23, ca.getHourOfDay());
		assertEquals(30, ca.getMinite());
		assertEquals(30, ca.getSecond());
		assertEquals(0, ca.getTwoHour());
	}

	@Test
	public void testSolarTerm() {
		fail("Not Yet...SolarTerm");
	}
}
