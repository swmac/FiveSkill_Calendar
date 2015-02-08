package idv.swmac.test;

import static org.junit.Assert.*;
import idv.swmac.calendar.FSCalendar;
import idv.swmac.solarterm.SolarTerm;

import java.util.Calendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestFSCalendar {

	private FSCalendar ca0;
	private FSCalendar ca1;
	private FSCalendar caSW;
	private FSCalendar caPega;
	private FSCalendar caGold;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		ca0 = new FSCalendar(2015, Calendar.JANUARY, 11, 1, 30, 0);
		ca1 = new FSCalendar(1944, Calendar.FEBRUARY, 10, 13, 0, 0);
//		caSW = new FSCalendar(1976, Calendar.JANUARY, 11, 0, 31, 0);
//		caPega = new FSCalendar(1982, Calendar.APRIL, 16, 20, 0, 0);
//		caGold = new FSCalendar(2013, Calendar.NOVEMBER, 20, 15, 43, 0);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFSCalendar() {
		assertFSCalendar(ca0, 2015, Calendar.JANUARY, 11, 1, 30, 0, SolarTerm.SMALL_COLD, new byte[]{0, 6, 3, 1, 3, 11, 7, 1});
	}

	private void assertFSCalendar(FSCalendar fsCa, int year, int month, int dayOfMonth, int hourOfDay,
			int minute, int second, SolarTerm solarTerm, byte[] pillars) {
		assertFSCalendarYear(fsCa, year);
		assertFSCalendarMonth(fsCa, month);
		assertFSCalendarDayOfMonth(fsCa, dayOfMonth);
		assertFSCalendarHourOfDay(fsCa, hourOfDay);
		assertFSCalendarMinute(fsCa, minute);
		assertFSCalendarSecond(fsCa, second);
		assertFSCalendarSolarTerm(fsCa, solarTerm);
		assertFSCalendarPillars(fsCa, pillars);
	}
	
	private void assertFSCalendarYear(FSCalendar fsCa, int expected) {
		assertEquals(expected, fsCa.getYear());
	}
	
	private void assertFSCalendarMonth(FSCalendar fsCa, int expected) {
		assertEquals(expected, fsCa.getMonth());
	}
	
	private void assertFSCalendarDayOfMonth(FSCalendar fsCa, int expected) {
		assertEquals(expected, fsCa.getDayOfMonth());
	}
	
	private void assertFSCalendarHourOfDay(FSCalendar fsCa, int expected) {
		assertEquals(expected, fsCa.getHourOfDay());
	}
	
	private void assertFSCalendarMinute(FSCalendar fsCa, int expected) {
		assertEquals(expected, fsCa.getMinite());
	}
	
	private void assertFSCalendarSecond(FSCalendar fsCa, int expected) {
		assertEquals(expected, fsCa.getSecond());
	}
	
	private void assertFSCalendarSolarTerm(FSCalendar fsCa, SolarTerm expected) {
		assertEquals(expected, fsCa.getSolarTerm());
	}
	
	private void assertFSCalendarPillars(FSCalendar fsCa, byte[] expected) {
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], fsCa.getPillars()[i]);
		}
//		assertEquals(expected[0], fsCa.getPillars()[0]);
//		assertEquals(expected[1], fsCa.getPillars()[1]);
//		assertEquals(expected[2], fsCa.getPillars()[2]);
//		assertEquals(expected[3], fsCa.getPillars()[3]);
//		assertEquals(expected[4], fsCa.getPillars()[4]);
//		assertEquals(expected[5], fsCa.getPillars()[5]);
//		assertEquals(expected[6], fsCa.getPillars()[6]);
//		assertEquals(expected[7], fsCa.getPillars()[7]);
	}
}
