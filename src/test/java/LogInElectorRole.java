import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.ExcelUtils;

import java.io.IOException;

public class LogInElectorRole extends BaseTest{

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


}
