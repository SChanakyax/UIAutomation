package uiAutomationObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//By fieldUsername = By.id("user-name"); 
	By fieldUsername = By.xpath("//*[@id=\'user-name\']");
	By fieldPassword = By.id("password");
	By login_Btn = By.id("login-button");
	By productImage = By.xpath("//*[@id=\'item_4_img_link\']/img");
	
	public void enterUsername()  {
		try {
			driver.findElement(fieldUsername).clear();
			driver.findElement(fieldUsername).sendKeys("standard_user");
		}catch(Exception e) {
			System.out.println("Exception " + e.getMessage());
		}
	}
	
	public void enterPassword()  {
		try {
			driver.findElement(fieldPassword).clear();
			driver.findElement(fieldPassword).sendKeys("secret_sauce");
		}catch(Exception e) {
			System.out.println("Exception " + e.getMessage());
		}
	}
	
	//Use to verify the inventory page
	public void verifyInventoryPage() {
		try {
			driver.findElement(login_Btn).click();
			String url = driver.getCurrentUrl();
			assertEquals(url, "https://www.saucedemo.com/inventory.html");
		}catch(Exception e) {
			System.out.println("Exception " + e.getMessage());
		}
	}
	
	public void clickProduct() {
		try {
			driver.findElement(productImage).click();
		}catch(Exception e) {
			
		}
	}
}
