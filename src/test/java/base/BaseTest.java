package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
     protected LoginPage loginPage;
  //  protected InventoryPage inventoryPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver(); //webdriver for chrome
        //driver.get("https://www.saucedemo.com//"); //launch a site
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //List<WebElement> links = driver.findElements(By.tagName("a"));
        //System.out.println(links.size());

       // driver.manage().window().maximize(); //maximize chrome window
       // WebElement inputs = driver.findElement(By.linkText("Inputs"));
        //inputs.click();

      //  homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);

       // inventoryPage = new InventoryPage(driver);

       // System.out.println(driver.getTitle()); //print page title
        //driver.quit(); //stop chrome driver.close();
       // System.out.println("Chrome Closed"); //print page title

    }

    @BeforeMethod
    public void goLogin(){
        driver.get("https://www.saucedemo.com/"); //launch a site
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void tearDown(){
       // driver.quit();
    }


    public static void main(String args[]){
        BaseTest test = new BaseTest();
        test.setUp();
    }
}
