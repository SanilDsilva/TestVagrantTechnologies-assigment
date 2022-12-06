package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.TestVagrantTechnologies.pages.BasePage;
import org.TestVagrantTechnologies.utils.propertieloader.ApplicationConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

/**
 * The type Base test.
 */
public class BaseTest {

    public BasePage homePage;
    public WebDriver driver;
    public static String BROWSER;
    private static final Logger Log = LoggerFactory.getLogger(BaseTest.class);

    /**
     * Gets driver.
     *
     * @return the driver
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Suit level setup.
     *
     * @throws IOException the io exception
     */
    @BeforeSuite(alwaysRun = true)
    public void suitLevelSetup() throws IOException {
        Log.info("*************************************");
        Log.info("******* T E S T *******");
        Log.info("*************************************");
        Log.info("Suit level loading");
        /*-----------------------------------------------------------------------------
         * BROWSER DETECTION
         * -----------------------------------------------------------------------------*/
        if (System.getenv("BROWSER") != null && !System.getenv("BROWSER").isEmpty())
            BROWSER = System.getenv("BROWSER");
        else BROWSER = ApplicationConfig.APPCONFIG.getProperty("browser");
        Log.info("Browser--> " + BROWSER);
        /*-----------------------------------------------------------------------------*/

        Log.info("*************************************");
    }

    /**
     * Class level setup.
     */
    @BeforeClass(alwaysRun = true)
    public void classLevelSetup() {
        try {
            if (ApplicationConfig.APPCONFIG.getProperty("browser").equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(BrowserOptionManager.getChromeOptions());
            } else {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(BrowserOptionManager.getFirefoxOptions());
            }
            driver.manage().deleteAllCookies();
        } catch (Exception e) {
            Log.info("Browser not loaded properly : " + e.getMessage());
        }
    }

    /**
     * Method level setup.
     */
    /* -----------------------------------------------------------------------------
     * BASE PAGE SETUP
     * -----------------------------------------------------------------------------*/
    @BeforeMethod(alwaysRun = true)
    public void methodLevelSetup() {
        try {
            homePage = new BasePage(driver);
        } catch (Exception e) {
            Log.info("Something went wrong while homepage driver innovation " + e.getMessage());
        }
    }

    /**
     * Tear down.
     */
    /* -----------------------------------------------------------------------------
     * BROWSER TEARDOWN
     * -----------------------------------------------------------------------------*/
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        Log.info("Tests are ending!");
        if (driver != null) driver.quit();
    }


}
