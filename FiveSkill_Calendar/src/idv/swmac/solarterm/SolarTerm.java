package idv.swmac.solarterm;

public enum SolarTerm {

	LI_SPRINT(0, "立春"),
	RAIN_WATER(1, "雨水"),
	WAKE_INSECTS(2, "驚蟄"),
	SPRINT_FEN(3, "春分"),
	CHING_MING(4, "清明"),
	GU_RAIN(5, "穀雨"),
	LI_SUMMER(6, "立夏"),
	SMALL_FULL(7, "小滿"),
	MON_ZHUNG(8, "芒種"),
	SUMMER_ZU(9, "夏至"),
	SMALL_HEAT(10, "小暑"),
	BIG_HEAT(11, "大暑"),
	LI_AUTUMN(12, "立秋"),
	CHU_HEAT(13, "處暑"),
	WHITE_LU(14, "白露"),
	AUTUMN_FEN(15, "秋分"),
	COOL_LU(16, "寒露"),
	FALL_SHOWN(17, "霜降"),
	LI_WINTER(18, "立冬"),
	SMALL_SNOW(19, "小雪"),
	BIG_SNOW(20,  "大雪"),
	WINTER_ZU(21, "冬至"),
	SMALL_COLD(22, "小寒"),
	BIG_COLD(23, "大寒");
	
	private int value;
	
	private String description;
	
	private SolarTerm(int value, String description) {
		this.value = value;
		this.description = description;
	}
	
	public int value() {
		return this.value;
	}
	
	public String getDescription() {
		return this.description;
	}
}
