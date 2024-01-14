package testcases;

import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.P01_Login;
import pages.P02_Profile;
import pages.P05_Delete_Customer;
import utilities.Utility;

import java.io.IOException;

public class TC04_Delete_Customer extends TestBase{
    String UserId = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/logindata.json", "userid");
    String password = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/logindata.json", "password");
    String Customer_IDII = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/logindata.json", "customeridI");

    public TC04_Delete_Customer() throws IOException, ParseException {
    }

    @Feature("Delete Customer")
    @Epic("Delete Epic")
    @Description("Check Delete Account Feature")
    @Severity(SeverityLevel.MINOR)
    @Test(priority = 1, description = "Delete Customer Functionality")
    public void deletecustomer_P() {
        new P01_Login(driver).fillUserID(UserId).fillPassword(password).clickLogin();
        new P02_Profile(driver).opendeleteaccount();
        new P05_Delete_Customer(driver).fillcustomerid(Customer_IDII).clicksubmit();
        Utility.captureScreenshot(driver, "Delete Customer");
}}
