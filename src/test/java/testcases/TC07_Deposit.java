package testcases;

import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.P01_Login;
import pages.P02_Profile;
import pages.P07_Edit_Account;
import pages.P08_Deposit;
import utilities.Utility;

import java.io.IOException;

public class TC07_Deposit extends TestBase{
    String UserId = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/logindata.json", "userid");
    String password = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/logindata.json", "password");
    String Account_Num = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/logindata.json", "accountnumber");
    String Amount=faker.number().digits(4);
    String Description=faker.name().name();
    public TC07_Deposit() throws IOException, ParseException {
    }
    @Feature("Deposit")
    @Epic("Deposit Epic")
    @Description("Check deposit Feature")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1, description = "Edit Customer Account")
    public void deposit_P() {
        new P01_Login(driver).fillUserID(UserId).fillPassword(password).clickLogin();
        new P02_Profile(driver).opendeposit();
        new P08_Deposit(driver).fillaccountnum(Account_Num).fillamount(Amount).filldescription(Description).clicksubmit();

        Utility.captureScreenshot(driver, "Deposit");
    }}


