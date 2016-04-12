import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class BaseTest extends TestCase {

    protected static WebDriver driver ;
    private String basePage = "https://www.wikipedia.org/"; // base url page

    @BeforeClass
    public void setUp() throws Exception{
        driver = new FirefoxDriver();
        driver.navigate().to(basePage);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
