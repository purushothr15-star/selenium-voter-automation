import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utils.ConfigReader;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup(){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            String url = ConfigReader.get("url");
            driver.get(url);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
