package idv.swmac.test;

import static org.junit.Assert.*;
import idv.swmac.calendar.PillarManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StemBranchTest {

	private PillarManager pManager;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		pManager = PillarManager.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testYearPillar() {
		// 列舉幾年
		assertEquals(0, pManager.getYearStem(2014));
		assertEquals(1, pManager.getYearStem(1975));
		assertEquals(8, pManager.getYearStem(1982));
	}
	
	@Test
	public void testMonthPillar() {
		// 列舉幾月
		assertEquals(6, pManager.getYearBranch(2014));
		assertEquals(3, pManager.getYearBranch(1975));
		assertEquals(10, pManager.getYearBranch(1982));
	}

	@Test
	public void testDayPillar() {
		fail("Not yet implemented: day pillar");
		// 1970 後
		// 1970 前
	}
	
	@Test
	public void testHourPillar() {
		fail("Not yet implemented: hour pillar");
		// 早子時
		// 晚子時
		// 平常時
	}
}
