package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogIn_Page {
    public static WebElement txtbx_UserName(WebDriver driver) {
        return (WebElement) driver.findElement(By.name("UserID"));
    }

    public static WebElement txtbx_Password(WebDriver driver) {
        return (WebElement) driver.findElement(By.name("Password"));
    }

    public static WebElement btn_LogIn(WebDriver driver) {
        return (WebElement) driver.findElement(By.name("B12"));
    }
}
