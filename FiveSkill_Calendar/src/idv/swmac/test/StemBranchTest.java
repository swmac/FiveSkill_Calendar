package idv.swmac.test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import idv.swmac.calendar.PillarUtil;
import idv.swmac.util.CalendarUtil;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StemBranchTest {

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testYearPillar() {
		// 列舉幾年
		assertEquals(0, PillarUtil.getYearStem(2014));
		assertEquals(1, PillarUtil.getYearStem(1975));
		assertEquals(8, PillarUtil.getYearStem(1982));
		assertEquals(6, PillarUtil.getYearBranch(2014));
		assertEquals(3, PillarUtil.getYearBranch(1975));
		assertEquals(10, PillarUtil.getYearBranch(1982));
	}
	
	@Test
	public void testMonthPillar() {
		// 列舉幾月
//		assertEquals()
	}

	@Test
	public void testFormula() {
		Calendar ca0 = new GregorianCalendar(1970, Calendar.JANUARY, 1);
		Calendar ca1 = new GregorianCalendar(1969, Calendar.DECEMBER, 31, 22, 20);
//		Calendar ca19691231 = new GregorianCalendar(1969, Calendar.DECEMBER, 31, 0, 0);
//		Calendar ca1969123101 = new GregorianCalendar(1969, Calendar.DECEMBER, 31, 0, 1);
		Calendar ca2 = new GregorianCalendar(1969, Calendar.JANUARY, 1, 18, 30);
		Calendar ca3 = new GregorianCalendar(1970, Calendar.JANUARY, 2);
		Calendar ca4 = new GregorianCalendar(1971, Calendar.JANUARY, 1, 18, 30);
		Calendar ca1912 = new GregorianCalendar(1912, Calendar.FEBRUARY, 18);
//		System.out.println("timeMillis 1969/12/31 : " + (ca19691231.getTimeInMillis() + ca19691231.getTimeZone().getRawOffset()));
//		System.out.println("timeMillis 1969/12/31 00:01 : " + (ca1969123101.getTimeInMillis() + ca1969123101.getTimeZone().getRawOffset()));
		// CalendarUtil.getDiffDaysFrom19700101
		assertEquals(-1, CalendarUtil.getDiffDaysFrom19700101(new GregorianCalendar(1969, Calendar.DECEMBER, 31, 0, 1)));
		assertEquals(-365, CalendarUtil.getDiffDaysFrom19700101(new GregorianCalendar(1969, Calendar.JANUARY, 1, 22, 20)));
		assertEquals(0, CalendarUtil.getDiffDaysFrom19700101(new GregorianCalendar(1970, Calendar.JANUARY, 1, 22, 20)));
		assertEquals(1, CalendarUtil.getDiffDaysFrom19700101(new GregorianCalendar(1970, Calendar.JANUARY, 2, 22, 20)));
		assertEquals(366, CalendarUtil.getDiffDaysFrom19700101(new GregorianCalendar(1971, Calendar.JANUARY, 2, 22, 20)));
		assertEquals(-1, CalendarUtil.getDiffDaysFrom19700101(new GregorianCalendar(1969, Calendar.DECEMBER, 31)));
		assertEquals(-365, CalendarUtil.getDiffDaysFrom19700101(new GregorianCalendar(1969, Calendar.JANUARY, 1)));
		assertEquals(0, CalendarUtil.getDiffDaysFrom19700101(new GregorianCalendar(1970, Calendar.JANUARY, 1)));
		assertEquals(1, CalendarUtil.getDiffDaysFrom19700101(new GregorianCalendar(1970, Calendar.JANUARY, 2)));
		assertEquals(366, CalendarUtil.getDiffDaysFrom19700101(new GregorianCalendar(1971, Calendar.JANUARY, 2)));
		// CalendarUtil.getDurationDaysBetween2Calendar
		
		assertEquals(1, CalendarUtil.getDurationDaysBetween2Calendar(ca0, ca1));
		assertEquals(1, CalendarUtil.getDurationDaysBetween2Calendar(ca0, ca3));
		assertEquals(365, CalendarUtil.getDurationDaysBetween2Calendar(ca0, ca2));
		assertEquals(365, CalendarUtil.getDurationDaysBetween2Calendar(ca0, ca4));
		assertEquals(366, CalendarUtil.getDurationDaysBetween2Calendar(ca1, ca4));
		System.out.println("From 1912/2/18 to 1970/1/1 : "+ CalendarUtil.getDurationDaysBetween2Calendar(ca1912, ca0));
		System.out.println("From 1912/2/18 to 1970/1/2 : "+ CalendarUtil.getDurationDaysBetween2Calendar(ca1912, ca3));
	}
	
	@Test
	public void testDayPillar() {
		// 1970 前
		assertEquals(9, PillarUtil.getDayStemBranch(1912, Calendar.FEBRUARY, 17)[0]);
		assertEquals(11, PillarUtil.getDayStemBranch(1912, Calendar.FEBRUARY, 17)[1]);
		assertEquals(0, PillarUtil.getDayStemBranch(1912, Calendar.FEBRUARY, 18)[0]);
		assertEquals(0, PillarUtil.getDayStemBranch(1912, Calendar.FEBRUARY, 18)[1]);
		assertEquals(1, PillarUtil.getDayStemBranch(1912, Calendar.FEBRUARY, 19)[0]);
		assertEquals(1, PillarUtil.getDayStemBranch(1912, Calendar.FEBRUARY, 19)[1]);
		assertEquals(6, PillarUtil.getDayStemBranch(1969, Calendar.DECEMBER, 31)[0]);
		assertEquals(4, PillarUtil.getDayStemBranch(1969, Calendar.DECEMBER, 31)[1]);

		// 1970 後
		assertEquals(7, PillarUtil.getDayStemBranch(1970, Calendar.JANUARY, 1)[0]);
		assertEquals(5, PillarUtil.getDayStemBranch(1970, Calendar.JANUARY, 1)[1]);
		assertEquals(8, PillarUtil.getDayStemBranch(1970, Calendar.JANUARY, 2)[0]);
		assertEquals(6, PillarUtil.getDayStemBranch(1970, Calendar.JANUARY, 2)[1]);
		assertEquals(8, PillarUtil.getDayStemBranch(1976, Calendar.JANUARY, 11)[0]);
		assertEquals(10, PillarUtil.getDayStemBranch(1976, Calendar.JANUARY, 11)[1]);
		assertEquals(5, PillarUtil.getDayStemBranch(1982, Calendar.APRIL, 16)[0]);
		assertEquals(5, PillarUtil.getDayStemBranch(1982, Calendar.APRIL, 16)[1]);
	}
	
	@Test
	public void testHourPillar() {
		// 早子時
		assertEquals(0, PillarUtil.getHourBranch(0));
		// 晚子時
		assertEquals(0, PillarUtil.getHourBranch(23));
		// 平常時
		assertEquals(1, PillarUtil.getHourBranch(1));
		assertEquals(4, PillarUtil.getHourBranch(8));
		assertEquals(11, PillarUtil.getHourBranch(22));
		
		assertEquals(6, PillarUtil.getHourStem(3, 0));
	}
}
