package idv.swmac.test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import idv.swmac.solarterm.SolarTerm;
import idv.swmac.solarterm.SolarTermManager2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SolarTermTest {
	
	private SolarTermManager2 manager;
	private GregorianCalendar calendar;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		manager = SolarTermManager2.getInstance();
		calendar = new GregorianCalendar();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() { // getSolarTermFromCalendar
		calendar.set(2014, 2, 3, 0, 0, 0);
		assertEquals(SolarTerm.BIG_COLD, manager.getSolarTermFromCalendar(calendar));
	}
	
	@Test
	public void testTermCalendar() { // getCalendarOfSolarTerm
		GregorianCalendar calendar = manager.getCalendarOfSolarTerm(2014, SolarTerm.RAIN_WATER);
		GregorianCalendar objCalendar = new GregorianCalendar(2014, Calendar.FEBRUARY, 19, 1, 59);
		assertTrue(objCalendar.equals(calendar));
	}

}
