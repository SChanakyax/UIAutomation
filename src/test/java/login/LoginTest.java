package login;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.InventoryPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {


    private WebDriver driver;
    protected InventoryPage inventoryPage;

  
    //Product page load after successfull login with valid username and password
    @Test
    public void testSuccessfullLogin() {

        loginPage.setUserName("standard_user");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        loginPage.setPassword("secret_sauce");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        InventoryPage inventoryPage = loginPage.clickLoginButton();
    }
/*
    @Test
    public void testBtn() {
     }
  */

}
