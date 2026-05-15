import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import utils.ConfigReader;

public class BaseTest {
    protected WebDriver driver;


    @BeforeMethod
    public void setup() {

        ChromeOptions options = new ChromeOptions();

        // Read headless value from Maven command
        boolean isHeadless =
                Boolean.parseBoolean(System.getProperty("headless", "false"));

        // Enable headless only in CI/CD
        if (isHeadless) {
            options.addArguments("--headless=new");
            /*options.addArguments("--window-size=1920,1080");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--no-sandbox");*/
        }

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        String url = ConfigReader.get("url");
        driver.get(url);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
