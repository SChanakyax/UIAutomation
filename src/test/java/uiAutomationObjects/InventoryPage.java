package uiAutomationObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

WebDriver driver;
	
	public InventoryPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By selectedProductImage = By.xpath("//*[@id=\'inventory_item_container\']/div/div/div[1]/img");

	
	//Click on product image
	//By productImage = By.xpath("//*[@id=\'item_4_img_link\']/img");
	By productImage = By.xpath("//*[@id=\'item_4_img_link\']");
 
	//Click a single product
	public void clickProduct() {
		try {
			driver.findElement(productImage).click();
			System.out.println("Product CLicked");
		}catch(Exception e) {
			System.out.println("Exception " + e.getMessage());
		}
	}
	
	//Check weather the next page is inventory page
			public void verifyProductPage() {
				try {
					driver.findElement(selectedProductImage).click();
					String url = driver.getCurrentUrl();
					assertEquals(url, "https://www.saucedemo.com/inventory-item.html?id=4");
					System.out.println("Product test ok");
				}catch(Exception e) {
					System.out.println("Exception " + e.getMessage());
				}
			}
		
}
