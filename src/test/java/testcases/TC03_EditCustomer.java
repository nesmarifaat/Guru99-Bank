package testcases;

import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_Login;
import pages.P02_Profile;
import pages.P03_EditCustomer;
import utilities.Utility;

import java.io.IOException;

public class TC03_EditCustomer extends TestBase{
    String UserId = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/logindata.json", "userid");
    String password = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/logindata.json", "password");
    String Customer_ID = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/logindata.json", "customerid");

    public TC03_EditCustomer() throws IOException, ParseException {
    }

    @Feature("Edit Cutomer")
    @Epic("Edit Epic")
    @Description("Check Edit Exsting Customer information")
    @Severity(SeverityLevel.MINOR)
    @Test(priority = 1, description = "Edit Customer Information", retryAnalyzer = retrytest.Retry.class)
    public void editcustomerinfo_P() {
        new P01_Login(driver).fillUserID(UserId).fillPassword(password).clickLogin();
        new P02_Profile(driver).openeditcustomer();
        new P03_EditCustomer(driver).fillcutomerid(Customer_ID).clicksubmit();
        new P03_EditCustomer(driver).editphonenum().clicksubmitbutton();
        Utility.captureScreenshot(driver, "Edit Customer");
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(new P03_EditCustomer(driver).validateeditform());
        softAssert.assertAll();

    }
}
