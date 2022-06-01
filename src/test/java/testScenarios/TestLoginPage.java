package testScenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
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
	
	//Check for credentials
 	@Test(priority=1)
	public void enterUsernamePassword() {
		LoginPage login = new LoginPage(driver);
		login.enterUsername();
		login.enterPassword();
		System.out.println("****************************All The Product Page loading****************************");

		//driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		login.verifyInventoryPage(); //Verify the inventory Page
		System.out.println("****************************Single Product Page loading****************************");
 
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Reporter.log("User credentials successfull");

	} 
	
 	//check for the product clicked and product item loaded
	@Test(priority=2)
	public void testProduct() throws InterruptedException {
		
		InventoryPage inventory = new InventoryPage(driver);		
		inventory.clickProduct();
		System.out.println("****************************Click Product****************************");	 
		ProductPage product = new ProductPage(driver);
		product.verifyAddToCartCartPage();
		System.out.println("***************************Checked Single Product page****************************");	
		Reporter.log("Product Page loaded successfully");


	}
	
	@Test(priority=3)
	public void testSingleProductPage() throws InterruptedException {		
		ProductPage productpage = new ProductPage(driver);
	
		System.out.println("****************************Click***************************");

		productpage.clickAddToCart_Btn(); 
		System.out.println("****************************Click Add to cart btn***************************");
		Reporter.log("item click button Add To Cart");

	}
	
	@Test(priority=5)
	public void click_btn_Cart() throws InterruptedException {
		//Thread.sleep(2000);
		ProductPage productpage = new ProductPage(driver);
		productpage.clickCart_Btn();
		System.out.println("****************************Cart Button clicked***************************");
		Reporter.log("Cart Page loaded");

	}
	

	@Test(priority=6)
	public void verifyCartItem() throws InterruptedException {
		Thread.sleep(5000);
		ProductPage productpage = new ProductPage(driver);
		productpage.verifyCartItem();
		System.out.println("****************************Cart Button clicked***************************");
		Reporter.log("CartItem Verified");
	}
 
	

	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
}
