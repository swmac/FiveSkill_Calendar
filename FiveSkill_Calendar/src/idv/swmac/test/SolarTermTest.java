package idv.swmac.test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import idv.swmac.solarterm.SolarTerm;
import idv.swmac.solarterm.SolarTermManager;
import idv.swmac.solarterm.SolarTermManagerException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SolarTermTest {
	
	private SolarTermManager manager;
	private GregorianCalendar calendar;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		manager = SolarTermManager.getInstance();
		calendar = new GregorianCalendar();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() { // getSolarTermFromCalendar
		calendar.set(2015, 1, 3, 0, 0, 0);
		assertEquals(SolarTerm.BIG_COLD, manager.getSolarTermFromCalendar(calendar));
	}
	
	@Test
	public void testTermCalendar() { // getCalendarOfSolarTerm
		// Normal
		GregorianCalendar calendar = manager.getCalendarOfSolarTerm(2014, SolarTerm.RAIN_WATER);
		GregorianCalendar objCalendar = new GregorianCalendar(2014, Calendar.FEBRUARY, 19, 1, 59);
		assertTrue(objCalendar.equals(calendar));
		//
		try {
			calendar = manager.getCalendarOfSolarTerm(2016, SolarTerm.RAIN_WATER);
		} catch(SolarTermManagerException e) {
			System.out.println(e.getMessage());
		}
	}

}
