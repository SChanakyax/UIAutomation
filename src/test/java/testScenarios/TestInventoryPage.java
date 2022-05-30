package testScenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import uiAutomationObjects.InventoryPage;
 import uiAutomationObjects.ProductPage;

public class TestInventoryPage {

WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		//driver.get("https://www.saucedemo.com/");
	}
	
	@Test
	public void enterUsername() {
		InventoryPage inventory = new InventoryPage(driver);	 
		inventory.verifyProductPage();  //Verify the inventory Page
		
	}
	
	 
	
	@AfterTest
	public void afterTest() {
		//driver.quit();
	}
}
