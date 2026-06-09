import base.BaseTest;
import org.openqa.selenium.By;

public class Locators extends BaseTest {

    public static By epicID = By.id("epicID");
    public static By stateDrpDwn = By.xpath("//select[@aria-label='Select State']");
    public static By searchButton = By.cssSelector("button[aria-label='Search']");
    public static By captcha = By.xpath("//input[@aria-label='Enter Captcha']");
    public static By voterList = By.tagName("table");
    public static By voterName = By.xpath("(//table//tr)[2]//td[3]");
    public static By votersFatName = By.xpath("(//table//tr)[2]//td[5]");
    public static By voterConstituency = By.xpath("(//table//tr)[2]//td[8]");
    public static By voterPartNo = By.xpath("(//table//tr)[2]//td[9]");
    public static By voterPollingStation = By.xpath("(//table//tr)[2]//td[10]");
    public static By voterSerialNo = By.xpath("(//table//tr)[2]//td[11]");
    //public static By voterConstituency = By.xpath("(//table//tr)[2]//td[8]");
}
