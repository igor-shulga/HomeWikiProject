import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class HomeSeleniumTest extends BaseTest {
 //   private static WebDriver driver ;

   private By wikiSearchInput = By.id("searchInput"); //wiki Search field
    private By firstHeadingOnPage = By.id("firstHeading"); //wiki first Heading on every page
    private By chuckNorrisLinks = By.linkText("Chuck Norris filmography"); //link make sure we find Chuck's page
    private By qaXpathPageLink = By.xpath(".//*[@id='mw-content-text']/ul[1]/li[2]/a"); // xpath to open Quality assurance page

    @Test

    public void testSeleniumSearchWikipedia () throws Exception{
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
    public void testChuckNorrisSearchWikipedia () throws Exception{
        // looking for Chuck Norris! o_O
        System.out.println("testChuckNorrisSearch started");
        driver.findElement(wikiSearchInput).sendKeys("Chuck Norris \n");
        driver.findElement(chuckNorrisLinks);
        System.out.println("Wiki page opened "+driver.getTitle());
        assertTrue("This not Chuck!", driver.getTitle().contains("Chuck"));
        Thread.sleep(2000);
    }

    @Test
    public void testQASearchWikipedia () throws Exception{
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



}
