package idv.swmac.test;

import idv.swmac.solarterm.SolarTermManager;

import java.io.File;

public class SystemDemo {

	public static void main(String[] args) {
		File file = new File("./assets/solar_terms.json");
		System.out.println("Exist the file? Ans." + file.isFile());
		SolarTermManager solarTerm = SolarTermManager.getInstance();
	}
}
