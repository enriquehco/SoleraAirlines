package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverChrome {
	
	public static void main(String[] args) {
		
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:3000");	//Nuestra url para pobrar 
		driver.manage().window().maximize();
		
		
		//Cosas
		
		WebElement element = driver.findElement(By.xpath("xpathAqui"));
		element.click();
		
		
		
	} 

}
