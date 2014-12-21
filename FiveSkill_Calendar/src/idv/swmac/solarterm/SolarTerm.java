package idv.swmac.solarterm;

public enum SolarTerm {

	LI_SPRINT(0),
	RAIN_WATER(1),
	WAKE_INSECTS(2),
	SPRINT_FEN(3),
	CHING_MING(4),
	GU_RAIN(5),
	LI_SUMMER(6),
	SMALL_FULL(7),
	MON_ZHUNG(8),
	SUMMER_ZU(9),
	SMALL_HEAT(10),
	BIG_HEAT(11),
	LI_AUTUMN(12),
	CHU_HEAT(13),
	WHITE_LU(14),
	AUTUMN_FEN(15),
	COOL_LU(16),
	FALL_SHOWN(17),
	LI_WINTER(18),
	SMALL_SNOW(19),
	BIG_SNOW(20),
	WINTER_ZU(21),
	SMALL_COLD(22),
	BIG_COLD(23);
	
	private int value;
	
	private SolarTerm(int value) {
		this.value = value;
	}
	
	public int value() {
		return this.value;
	}
}
