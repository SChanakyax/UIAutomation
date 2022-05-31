package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

   // private WebDriver driver;
    WebDriver driver = null;
    private By loginButton = By.id("login-button");
    private By productPage = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    private By x = By.linkText("Products");

    public InventoryPage(WebDriver driver){
        this.driver = driver;
    }


    public InventoryPage confirmInventoryPage() {
        //boolean ppage = driver.findElement(productPage).isEnabled();
        driver.findElement(x).click();
        return new InventoryPage(driver);

    }

}
