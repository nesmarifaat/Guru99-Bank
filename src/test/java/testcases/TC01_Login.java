package testcases;

import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_Login;
import utilities.Utility;

import java.io.IOException;

@Feature("Login Feature")
@Epic("Login Epic")
public class TC01_Login extends TestBase {
    //TODO: define test data
    String  UserId = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/logindata.json", "userid");
  String password = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/logindata.json", "password");

    public TC01_Login() throws IOException, ParseException {
    }

    @Description("Check Login With Valid Data")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login")
    @Test(priority = 1, description = "Check Login With Valid Data", retryAnalyzer = retrytest.Retry.class)
    public void checkLogin_P() {
        new P01_Login(driver).fillUserID(UserId).fillPassword(password).clickLogin();
        // take screenshot
        Utility.captureScreenshot(driver, "P_Login");
        // assert if login successfully
        Assert.assertTrue(new P01_Login(driver).checksucessfullogin(), UserId);

    }

    String Invaliduser = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/logindata.json", "invaliduser");


    @Description("Check Login With Invalid User ID")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Negative Login with Invalid User ID")
    @Test(priority = 2, description = "Check Login With inValid User ID")
    public void checkLoginwithinvaliduser_N() {
        new P01_Login(driver).fillUserID(Invaliduser).fillPassword(password).clickLogin();
        // take screenshot
        Utility.captureScreenshot(driver, "N_Login");
        // assert if login successfully
        Assert.assertTrue(new P01_Login(driver).checkfailedlogin());

    }

    String passwordII = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/logindata.json", "passwordII");
    @Description("Check Login With Invalid Password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Negative Login with Invalid Password")
    @Test(priority = 3, description = "Check Login With inValid User ID")
    public void checkLoginwithinvalidpassword_N() {
        new P01_Login(driver).fillUserID(UserId).fillPassword(passwordII).clickLogin();
        // take screenshot
        Utility.captureScreenshot(driver, "N_Login");
        // assert if login successfully
        Assert.assertTrue(new P01_Login(driver).checkfailedlogin());

    }


    @Description("Check Login With Invalid Password & User ID")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Negative Login with Invalid Password")
    @Test(priority = 4, description = "Check Login With inValid UserID & Password")
    public void checkLoginwithinvaliddata_N() {
        new P01_Login(driver).fillUserID(Invaliduser).fillPassword(passwordII).clickLogin();
        // take screenshot
        Utility.captureScreenshot(driver, "N_Login");
        // assert if login successfully
        Assert.assertTrue(new P01_Login(driver).checkfailedlogin());

    }


}
