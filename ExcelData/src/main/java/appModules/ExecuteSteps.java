package appModules;

import ExcelOperations.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExecuteSteps {

    public static void execute(WebDriver driver, int i ,String username, String password) throws Exception{

        StepDefinition stepDefs = new StepDefinition();
        Thread thread = new Thread();
        WebDriver mainDriver = null;

        //AWB Number for the current scenario
        String awbNumber = ExcelUtils.getCellData(i, 2);

        //steps for the BA Safe Login
        driver.findElement(By.id("password_username")).sendKeys(username);
        driver.findElement(By.id("password_password")).sendKeys(password);
        driver.findElement(By.id("login_button")).click();

        // Capture AWB screen steps
        stepDefs.enterScreenName(driver, ExcelUtils.getCellData(i, 1));
        thread.sleep(5000);
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[name=\"iCargoContentFrameOPR026\"]")));
        stepDefs.enterAWBNumberOnCaptureScreen(driver, awbNumber);
        mainDriver = driver;
        stepDefs.clickYesToAWBExistPopup(driver);
        driver = mainDriver;

        //Enter General Details On Capture Screen
        stepDefs.enterGeneralDetailsOnCaptureScreen(driver, i);

        String sUserName = ExcelUtils.getCellData(i, 1);
        String sPassword = ExcelUtils.getCellData(i, 2);

    }
}