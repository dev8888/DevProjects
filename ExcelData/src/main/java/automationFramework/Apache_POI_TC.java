package automationFramework;

import java.io.File;
import java.util.concurrent.TimeUnit;

import appModules.ExecuteSteps;
import appModules.LoginDialog;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import ExcelOperations.Constant;

import ExcelOperations.ExcelUtils;

import javax.swing.*;

public class Apache_POI_TC {

    private static WebDriver driver = null;

    public static String urlGiven = null;

    public static String bsafeUsername = null;

    public static String bsafePassword = null;

    public static void main(String[] args) throws Exception {

        //This is to open the Excel file. Excel path, file name and the sheet name are parameters to this method

        ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"testData");

        LoginDialog loginDlg = new LoginDialog(new JFrame("JDialog Demo"));

        loginDlg.setVisible(true);

        urlGiven = loginDlg.getUrl();

        bsafeUsername = loginDlg.getUsername();

        bsafePassword = loginDlg.getPassword();

        System.out.print(bsafeUsername+"  "+bsafePassword);

        //System.setProperty("webdriver.ie.driver", new File("").getAbsolutePath().split("ExcelData")[0]+"IEDriverServer.exe");

        System.setProperty("webdriver.chrome.driver",new File("").getAbsolutePath().split("ExcelData")[0]+"chromedriver.exe");

        int i = 1;

        int noOfRows = ExcelUtils.getNumberOfRows(Constant.Path_TestData + Constant.File_TestData,"Sheet1");

        while( noOfRows > 0 && i <= noOfRows){

//            driver = new InternetExplorerDriver();

            driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.get(urlGiven);

            ExecuteSteps.execute(driver, i, bsafeUsername, bsafePassword);

            driver.quit();

            //This is to send the PASS value to the Excel sheet in the result column.

            ExcelUtils.setCellData("Pass", i, 5);

            i++;

        }

        System.exit(0);

    }



}