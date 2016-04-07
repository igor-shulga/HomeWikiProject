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

    private By wikiSearchInput = By.id("searchInput"); //wiki Search field
    private By firstHeadingOnPage = By.id("firstHeading"); //wiki first Heading on every page
    private By chuckNorrisLinks = By.linkText("Chuck Norris filmography"); //link make sure we find Chuck's page
    private By qaXpathPageLink = By.xpath(".//*[@id='mw-content-text']/ul[1]/li[2]/a"); // xpath to open Quality assurance page



    @BeforeClass
    public void setUp() throws Exception{
        this.driver.get("https://www.wikipedia.org/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void testSeleniumSearch () throws Exception{

        // looking ror Selenium IDE
        System.out.println("testSeleniumSearch started");
        WebElement searchInput = driver.findElement(wikiSearchInput);
        searchInput.sendKeys("Selenium IDE \n");
        WebElement seleniumLabel = driver.findElement(firstHeadingOnPage);
        String label = seleniumLabel.getText();
        System.out.println("Wikipedia page " + label + " opened.Test Finished.");
        assertTrue("Wrong page", label.contains("Selenium"));
        Thread.sleep(2000);
    }

   @Test
    public void testChuckNorrisSearch() throws Exception{
        // looking for Chuck Norris! o_O
        System.out.println("testChuckNorrisSearch started");
        driver.findElement(wikiSearchInput).sendKeys("Chuck Norris \n");
        driver.findElement(chuckNorrisLinks);
        System.out.println("Wiki page opened "+driver.getTitle());
        assertTrue("This not Chuck!", driver.getTitle().contains("Chuck"));
        Thread.sleep(2000);
    }

    @Test
    public void testQASearch() throws Exception{
        // looking for QA
        System.out.println("testQASearch started");
        driver.findElement(wikiSearchInput).sendKeys("QA \n");
        WebElement element = driver.findElement(qaXpathPageLink);
        element.click();
        String title = driver.getTitle();
        System.out.println(title + " page opened");
        assertTrue("Unexpected page opened instead QA", driver.getTitle().contains("Quality"));
        Thread.sleep(2000);
    }

    @AfterClass
    public void tearDown(){
        this.driver.quit();
    }

}
