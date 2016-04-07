import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;


public class HomeSeleniumTest extends TestCase {
    private WebDriver driver = new FirefoxDriver();

    private By wikiSearchInput = By.id("searchInput");
    private By firstHeadingOnPage = By.id("firstHeading");




    @BeforeClass
    public void setUp() throws Exception{
        this.driver.get("https://www.wikipedia.org/");
    }
    @Test
    public void testWiki () throws Exception{

        // looking ror Selenium IDE

        WebElement searchInput = driver.findElement(wikiSearchInput);
        searchInput.sendKeys("Selenium IDE \n");
        WebElement seleniumLabel = driver.findElement(firstHeadingOnPage);
        String label = seleniumLabel.getText();
        System.out.println("Wikipedia page " + label + " opened");
        assertTrue("Wrong page", label.contains("Selenium"));


        // looking for Chuck Norris! o_O
        driver.findElement(wikiSearchInput).sendKeys("Chuck Norris \n");

        Thread.sleep(5000);

         //driver.findElement(By.id("Selenium_IDE"));




        //Selenium (software)


    }

    @AfterClass
    public void tearDown(){
        this.driver.quit();
    }

}