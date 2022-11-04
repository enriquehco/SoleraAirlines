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
		String name = "Esteban";
		String compro = "Welcome! Esteban";
		
		WebElement element = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/input[1]"));
		element.sendKeys(name);
		
		
		element = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
		element.click();
		
		element = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[6]/h4[1]"));
		System.out.println(element.getText().equals(compro));
		
		///
		
		element = driver.findElement(By.xpath("//button[contains(text(),'Search for a new Flight')]"));
		element.click();
		
		element = driver.findElement(By.xpath("//select[@id='departures']"));
		element.click();
		
		element = driver.findElement(By.xpath("//option[contains(text(),'sevilla')]"));
		element.click();
		
		element = driver.findElement(By.xpath("//select[@id='arrivals']"));
		element.click();
		
		element = driver.findElement(By.xpath("//option[contains(text(),'granada')]"));
		element.click();
		
		element = driver.findElement(By.xpath("//input[@id='checkbox']"));
		element.click();
		
		element = driver.findElement(By.xpath("//button[contains(text(),'Search for flights')]"));
		element.click();
		
		
		
	} 

}
