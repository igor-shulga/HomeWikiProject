import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by skillsup on 12.04.16.
 */
public class BaseTest extends TestCase {

    protected static WebDriver driver ;

    private String basePage = "https://www.wikipedia.org/"; // base url page

    @BeforeClass
    public void setUp() throws Exception{
        driver = new FirefoxDriver();
        // driver.get(basePage);

        driver.navigate().to(basePage);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
