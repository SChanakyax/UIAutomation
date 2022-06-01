package uiAutomationObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
	
	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		System.out.println("Productpage Constructor");
	}
	
	//
	////*[@id="shopping_cart_container"]/a //*[@id="shopping_cart_container"]
	//By addToCart = By.xpath("//*[@id=\'add-to-cart-sauce-labs-backpack\']");////*[@id="add-to-cart-sauce-labs-backpack"] 
	By addToCart = By.id("add-to-cart-sauce-labs-backpack");//Add to cart
	////*[@id="add-to-cart-sauce-labs-backpack"]
	//By addToCart = By.linkText("Add to cart");
	By bnt_Cart = By.xpath("//*[@id=\'shopping_cart_container\']");////*[@id="shopping_cart_container"]/a
	By bnt_CartCss =By.cssSelector("shopping_cart_link");
	
	//By cartItem = By.xpath("//*[@id=\'item_4_title_link\']/div");
	By cartItem = By.cssSelector("inventory_item_name");
	
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
			System.out.println("BTNclicked");
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
 
	//Verify the addToCart item at cartPage
	public boolean verifyCartItem() {
		try {
			WebElement name = driver.findElement(cartItem);
			assertEquals(name, "Sauce Labs Backpack");
			System.out.println("ok");
		}catch(Exception e) {
			System.out.println("Exception " + e.getMessage());
		}
		return true;
	}
	
}
