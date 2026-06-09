import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.ExcelUtils;

import java.io.IOException;

public class LogInElectorRole extends BaseTest {

        ReUsableMethods reUseMethods;
       @BeforeMethod()
        public void init(){
            reUseMethods = new ReUsableMethods(driver);
        }



    @Test
    public void fetchDetails() throws IOException {
        reUseMethods.getVoterDetails();
        String name = driver.findElement(Locators.voterName).getText();
        String partNo = driver.findElement(Locators.voterPartNo).getText();
        String serialNo = driver.findElement(Locators.voterSerialNo).getText();
        ExcelUtils.writeData(name, partNo, serialNo);

    }

    @Test
    public void enterDetails() throws IOException {
        reUseMethods.waitUntilElementIsDiplayed(Locators.epicID, 3);
        String epicID = ExcelUtils.getData("Voter ID");
        reUseMethods.enterTextInputBox(Locators.epicID, epicID);
        //reUseMethods.clickOnELement(Locators.stateDrpDwn);
        reUseMethods.selectFromDropDown(Locators.stateDrpDwn, ConfigReader.get("state"));
        System.out.println("Values entered as expected");
    }


}
