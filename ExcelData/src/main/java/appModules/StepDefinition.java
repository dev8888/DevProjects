package appModules;

import ExcelOperations.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StepDefinition {

    Thread thread = new Thread();

    public  void enterScreenName(WebDriver driver, String screenName) throws InterruptedException{

        String winHandleBefore = driver.getWindowHandle();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        thread.sleep(20000);
        driver.findElement(By.id("ic-screen-search")).sendKeys(screenName);
        thread.sleep(2000);
        driver.findElement(By.cssSelector(".ic-screen-search-suggest-list li")).click();
    }

    public  void enterAWBNumberOnCaptureScreen(WebDriver driver, String awb) throws InterruptedException{
        thread.sleep(1000);
        driver.findElement(By.cssSelector("input[name=\"documentNumber\"]")).sendKeys(awb);
        thread.sleep(1000);
        driver.findElement(By.cssSelector("#CMP_Operations_Shipment_CaptureAWB_ListButton span")).click();
        thread.sleep(3000);
    }

    public void clickYesToAWBExistPopup(WebDriver driver) throws  InterruptedException{
        thread.sleep(2000);
        String winHandleBefore = driver.getWindowHandle();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        driver.findElements(By.cssSelector(".ui-dialog-buttonset button")).get(0).click();
    }

    public void enterGeneralDetailsOnCaptureScreen(WebDriver driver, int row) throws InterruptedException{
        thread.sleep(3000);
        try {
            driver.findElement(By.cssSelector("input[name='origin']")).sendKeys(ExcelUtils.getCellData(row, 3));
        } catch (Exception e) {
            //do nothing
        }
    }

}
