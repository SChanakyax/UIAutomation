package uiAutomationObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

WebDriver driver;
	
	public InventoryPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Click on product image
	By productImage = By.xpath("//*[@id=\'item_4_img_link\']/img");
	
	
	//By fieldPassword = By.id("password");
	//By login_Btn = By.id("login-button");
/*	
	public void enterUsername()  {
		try {
			driver.findElement(fieldUsername).clear();
			driver.findElement(fieldUsername).sendKeys("standard_user");
		}catch(Exception e) {
			System.out.println("Exception " + e.getMessage());
		}
	}
*/	
	public void clickProduct() {
		try {
			driver.findElement(productImage).click();
		}catch(Exception e) {
			
		}
	}
 
	public void verifyProductPage() {
		try {
			driver.findElement(productImage).click();
			String url = driver.getCurrentUrl();
			assertEquals(url, "https://www.saucedemo.com/inventory-item.html?id=4");
			System.out.println("Product test ok");
		}catch(Exception e) {
			System.out.println("Exception " + e.getMessage());
		}
	}
}
