package testScenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import uiAutomationObjects.InventoryPage;
import uiAutomationObjects.LoginPage;
import uiAutomationObjects.ProductPage;

public class TestLoginPage {

	WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	
		driver.get("https://www.saucedemo.com/");
	}
	
 	@Test
	public void enterUsername() {
		LoginPage login = new LoginPage(driver);
		login.enterUsername();
		login.enterPassword();
		System.out.println("****************************All The Product Page loading****************************");

		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
	 
		login.verifyInventoryPage(); //Verify the inventory Page
		System.out.println("****************************Product Page loading****************************");
 
	
	} 
	
	@Test
	public void testProduct() {
		
		InventoryPage inventory = new InventoryPage(driver);
		inventory.clickProduct();
		inventory.verifyProductPage();
		
		ProductPage productpage = new ProductPage(driver);
		productpage.clickAddToCart_Btn(); 
	}
/*	
	@Test
	public void clickAddToCart() {
	
	
	}
	

	@Test
	public void clicBtnCart() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ProductPage productpage = new ProductPage(driver);
		productpage.clickCart_Btn();
	}
	*/
	
	
	@AfterTest
	public void afterTest() {
	
	}
	
}
