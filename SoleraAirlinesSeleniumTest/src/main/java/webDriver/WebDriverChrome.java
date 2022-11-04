package webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverChrome {
	
	public static void main(String[] args) {
		
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");	//Nuestra url para pobrar 
		driver.manage().window().maximize();
		
		
		//Cosas
		
		
	} 

}
