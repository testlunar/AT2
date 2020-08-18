import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseTest {
    protected static WebDriver driver;
    protected static String baseUrl= "http://www.sberbank.ru/ru/person";

    public static Properties properties = TestProperties.getInstance().getProperties();


    @Before
    public void beforeTest() {

        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }


    @After
    public void afterTest() {        driver.quit();    }


    protected void fillField(By locator, String value) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }


    protected void checkFillField(String value, By locator) {
        assertEquals(value, driver.findElement(locator).getAttribute("value"));
    }

}
