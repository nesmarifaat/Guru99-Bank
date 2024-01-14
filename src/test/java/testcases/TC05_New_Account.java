package testcases;

import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_Login;
import pages.P02_Profile;
import pages.P06_New_Account;
import utilities.Utility;

import java.io.IOException;

public class TC05_New_Account extends TestBase {

    String UserId = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/logindata.json", "userid");
    String password = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/logindata.json", "password");
    String Customer_ID = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/logindata.json", "customerid");
    String Deposit = faker.number().digits(4);

    public TC05_New_Account() throws IOException, ParseException {
    }

    @Feature("New Account")
    @Epic("New Account Epic")
    @Description("Check Open New Account Feature")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1, description = "Open New Customer Account")
    public void opennewaccount_P() {
        new P01_Login(driver).fillUserID(UserId).fillPassword(password).clickLogin();
        new P02_Profile(driver).opennewaccount();
        new P06_New_Account(driver).fillcustomerid(Customer_ID).selectaccount().filldeposit(Deposit).clicksubmitbutton();
        Utility.captureScreenshot(driver, "New Account");
        Assert.assertTrue(new P06_New_Account(driver).verfiysucessmsg());

    }
}
