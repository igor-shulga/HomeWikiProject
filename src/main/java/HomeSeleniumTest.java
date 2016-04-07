import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

//test

public class HomeSeleniumTest extends TestCase {
    private WebDriver driver = new FirefoxDriver();

    private By wikiSearchInput = By.id("searchInput");

    @BeforeClass
    public void setUp() throws Exception{
        this.driver.get("https://www.wikipedia.org/");
    }
    @Test
    public void testWiki () throws Exception{
        WebElement searchInput = driver.findElement(wikiSearchInput);
        searchInput.sendKeys("Selenium IDE \n");

    }

    @AfterClass
    public void tearDown(){
        this.driver.quit();
    }

}