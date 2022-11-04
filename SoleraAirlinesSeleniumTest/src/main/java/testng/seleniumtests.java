package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class seleniumtests {

	WebDriver _driver;

	@BeforeMethod
	void setUp() {
		_driver = new ChromeDriver();
		_driver.get("http://localhost:3000");
	}

	@AfterMethod
	void tearDown() {
		_driver.close();
	}


	@Test(dataProvider = "calc-data", dataProviderClass = testDataLoader.class)
	void loginTest(String input, String expected) {

		WebElement element = _driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/input[1]"));
		element.sendKeys(input);


		element = _driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
		element.click();

		WebElement result = _driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[6]/h4[1]"));


		Assert.assertEquals(result.getText(), expected);
	}

	@Test(dataProvider = "nameflight", dataProviderClass = testDataLoader.class)
	void showFlightTest(String input, String name1, String nam2) {
		WebElement element = _driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/input[1]"));
		element.sendKeys(input);


		element = _driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
		element.click();

		element = _driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[6]/h4[1]"));

		///

		element = _driver.findElement(By.xpath("//button[contains(text(),'Search for a new Flight')]"));
		element.click();

		element = _driver.findElement(By.xpath("//select[@id='departures']"));
		element.click();

		element = _driver.findElement(By.xpath("//option[contains(text(),'sevilla')]"));
		element.click();

		element = _driver.findElement(By.xpath("//select[@id='arrivals']"));
		element.click();

		element = _driver.findElement(By.xpath("//option[contains(text(),'granada')]"));
		element.click();

		element = _driver.findElement(By.xpath("//input[@id='checkbox']"));
		element.click();

		element = _driver.findElement(By.xpath("//button[contains(text(),'Search for flights')]"));
		element.click();

		element = _driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/ul[1]/div[1]/li[1]/div[1]/div[2]/h2[2]"));
		Assert.assertEquals(element.getText(), name1);

		element = _driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/ul[1]/div[1]/li[1]/div[1]/div[2]/h2[3]\r\n"));
		Assert.assertEquals(element.getText(), nam2);


	}
	@Test(dataProvider = "makereservation", dataProviderClass = testDataLoader.class)
	void purchaseFlight(String input, String numpass, String nombre, String apellido, String nation, String id, String age) {
		WebElement element = _driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/input[1]"));
		element.sendKeys(input);


		element = _driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
		element.click();

		element = _driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[6]/h4[1]"));

		///

		element = _driver.findElement(By.xpath("//button[contains(text(),'Search for a new Flight')]"));
		element.click();

		element = _driver.findElement(By.xpath("//select[@id='departures']"));
		element.click();

		element = _driver.findElement(By.xpath("//option[contains(text(),'sevilla')]"));
		element.click();

		element = _driver.findElement(By.xpath("//select[@id='arrivals']"));
		element.click();

		element = _driver.findElement(By.xpath("//option[contains(text(),'granada')]"));
		element.click();

		element = _driver.findElement(By.xpath("//input[@id='checkbox']"));
		element.click();

		element = _driver.findElement(By.xpath("//button[contains(text(),'Search for flights')]"));
		element.click();

		element = _driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[3]/div[1]/div[1]/ul[1]/div[1]/li[1]/div[1]/div[2]"));
		element.click();

		element = _driver.findElement(By.xpath("//input[@id='npass']"));
		element.sendKeys(numpass);

		element = _driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
		element.click();

		element = _driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]"));
		element.sendKeys(nombre);

		element = _driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/form[1]/div[2]/input[1]"));
		element.sendKeys(apellido);

		element = _driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/form[1]/div[3]/input[1]"));
		element.sendKeys(nation);

		element = _driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/form[1]/div[4]/input[1]"));
		element.sendKeys(id);

		element = _driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/form[1]/div[5]/input[1]"));
		element.sendKeys(age);

		element = _driver.findElement(By.xpath("//button[contains(text(),'Save user data')]"));
		element.click();

		WebElement confirm = _driver.findElement(By.xpath("//button[contains(text(),'Confirm purchase')]"));
		WebElement reject = _driver.findElement(By.xpath("//button[contains(text(),'Reject purchase')]"));

		Assert.assertTrue(confirm.isDisplayed() && reject.isDisplayed());

	}


}