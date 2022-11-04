package testng;

import org.testng.annotations.DataProvider;

public class testDataLoader {
		@DataProvider(name = "calc-data")
		Object[][] testData(){
			return new Object[][] {
				{"Esteban", "Welcome! Esteban"}
			};
		}
		@DataProvider(name= "nameflight")
		Object[][] testData2(){
			return new Object[][] {
				{"Esteban", "sevilla", "granada" }
			};
		}
		@DataProvider(name= "makereservation")
		Object[][] testData3(){
			return new Object[][] {
				{"Esteban", "1", "Jorge", "Montoya", "Español", "777555784", "26"}
			};
		}
}
