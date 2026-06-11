import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import utils.ExcelUtils;
import utils.ReportLogger;

import java.io.IOException;
import java.time.Duration;

public class ReUsableMethods {

    WebDriver driver;
    public ReUsableMethods(WebDriver driver){
        this.driver = driver;
    }

    public void waitUntilElementIsDiplayed(By element, int waitTime){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));


    }
    public boolean checkEleDisplayed(By element, int waitTime) {

        boolean displayed = false;
        try {
            if (driver.findElement(element).isDisplayed()) {
                displayed = true;
            }

        } catch (NoSuchElementException exception) {
            displayed = false;
        }
        return displayed;
    }
    public void selectFromDropDown(By element , String value){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Select select = new Select(driver.findElement(Locators.stateDrpDwn));
        String state = ConfigReader.get("state");
        select.selectByVisibleText(state);

        ReportLogger.log("SelectValueFromStateDropdown", "Value selected", state);
    }




    public void clickOnELement(By element){
        waitUntilElementIsDiplayed(element, 4);
        driver.findElement(element).click();
        ReportLogger.log("ClickOn"+element.toString(), "Clicked on"+element.toString(), "Clicking");
    }
    public void enterTextInputBox(By element, String value){

        driver.findElement(element).sendKeys(value);
        ReportLogger.log("EnterValue", "Entered value in"+element.toString(), value);
    }
    //test
    public void getVoterDetails() throws IOException {
        waitUntilElementIsDiplayed(Locators.epicID, 3);
        String epicID = ExcelUtils.getData("Voter ID");
        enterTextInputBox(Locators.epicID, epicID);
        //reUseMethods.clickOnELement(Locators.stateDrpDwn);
        selectFromDropDown(Locators.stateDrpDwn, ConfigReader.get("state"));
        do {
            String captcha = driver.findElement(Locators.captcha).getAttribute("value");
            if(captcha!=null && captcha.length()>5){
                clickOnELement(Locators.searchButton);
                waitUntilElementIsDiplayed(Locators.voterList, 3);
                boolean voterListDisplayed = checkEleDisplayed(Locators.voterList, 6);
                if(voterListDisplayed){
                    System.out.println("voter list displayed as expected");
                }
                else {
                    System.out.println("voter list not displayed as expected");
                }
                break;
            }
        }
        while(!checkEleDisplayed(Locators.voterList, 3));

    }


}

