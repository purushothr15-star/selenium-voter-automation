import base.BaseTest;
import org.testng.annotations.Test;
import utils.ExcelUtils;

public class VoterListExtract extends BaseTest {

    LogInElectorRole ler = new LogInElectorRole();
    @Test
    public void extractVoterDataInToExcel(){
        //List<String> voterDatas = new ArrayList<>();
        //List<WebElement> voterLocators = new ArrayList<>();
        //ler.fetchDetails();
        String name = driver.findElement(Locators.voterName).getText();
        String partNo = driver.findElement(Locators.voterPartNo).getText();
        String serialNo = driver.findElement(Locators.voterSerialNo).getText();
        ExcelUtils.writeData(name, partNo, serialNo);

    }


}
