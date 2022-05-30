package uiAutomationObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
	
	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//By addToCart = By.xpath("//*[@id=\'add-to-cart-sauce-labs-backpack\']");// 
	By addToCart = By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']");
	By bnt_Cart = By.xpath("//*[@id=\'shopping_cart_container\']/a");
	
	//Click add to cart
	public void clickAddToCart_Btn() {
		try {
			driver.findElement(addToCart).click();
			System.out.println("****************Add To Cart Button Clicked ****************");
		}catch(Exception e) {
			System.out.println("Add to cart click" + e.getMessage());
		}
	}
	
	//Click the cart button
	public void clickCart_Btn() {
		try {
			driver.findElement(bnt_Cart).click();
		}catch(Exception e) {
			System.out.println("Cart button click" + e.getMessage());
		}
	}
 
	//Verify the page
	public void verifyAddToCartCartPage() {
		try {
			driver.findElement(addToCart).click();
			String url = driver.getCurrentUrl();
			assertEquals(url, "https://www.saucedemo.com/inventory-item.html?id=4");
			System.out.println("Product test ok");
		}catch(Exception e) {
			System.out.println("Exception " + e.getMessage());
		}
	}
 
}
