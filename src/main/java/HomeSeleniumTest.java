import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class HomeSeleniumTest extends TestCase {
    private WebDriver driver = new FirefoxDriver();

    private By wikiSearchInput = By.id("searchInput");
    private By firstHeadingOnPage = By.id("firstHeading");




    @BeforeClass
    public void setUp() throws Exception{
        this.driver.get("https://www.wikipedia.org/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void testSeleniumSearch () throws Exception{

        // looking ror Selenium IDE

        WebElement searchInput = driver.findElement(wikiSearchInput);
        searchInput.sendKeys("Selenium IDE \n");
        WebElement seleniumLabel = driver.findElement(firstHeadingOnPage);
        String label = seleniumLabel.getText();
        System.out.println("Wikipedia page " + label + " opened");
        assertTrue("Wrong page", label.contains("Selenium"));
        Thread.sleep(2000);
    }

   @Test
    public void testChuckNorrisSearch() throws Exception{
        // looking for Chuck Norris! o_O
        driver.findElement(wikiSearchInput).sendKeys("Chuck Norris \n");
        driver.findElement(By.linkText("Chuck Norris filmography"));
        Thread.sleep(2000);
    }
    @Test
    public void testQASearch() throws Exception{
        // looking for QA
        driver.findElement(wikiSearchInput).sendKeys("QA \n");
        WebElement element = driver.findElement(By.xpath(".//*[@id='mw-content-text']/ul[1]/li[2]/a"));
        element.click();
        String title = driver.getTitle();
        System.out.println(title + " page opened");
        
    }





    @AfterClass
    public void tearDown(){
        this.driver.quit();
    }

}
