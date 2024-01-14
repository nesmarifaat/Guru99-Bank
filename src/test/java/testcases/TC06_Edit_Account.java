package testcases;

import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.P01_Login;
import pages.P02_Profile;
import pages.P07_Edit_Account;
import utilities.Utility;

import java.io.IOException;

public class TC06_Edit_Account extends TestBase{
    String UserId = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/logindata.json", "userid");
    String password = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/logindata.json", "password");
    String Account_Num = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/logindata.json", "accountnumber");

    public TC06_Edit_Account() throws IOException, ParseException {
    }
    @Feature("Edit Account")
    @Epic("Edit Account Epic")
    @Description("Check Edit Account Feature")
    @Severity(SeverityLevel.MINOR)
    @Test(priority = 1, description = "Edit Customer Account")
    public void opennewaccount_P() {
        new P01_Login(driver).fillUserID(UserId).fillPassword(password).clickLogin();
        new P02_Profile(driver).openeditaccount();
        new P07_Edit_Account(driver).fillaccountnum(Account_Num).clicksubmitbutton();
}}
