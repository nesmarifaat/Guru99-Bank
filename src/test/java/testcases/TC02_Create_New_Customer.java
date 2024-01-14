package testcases;

import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_Login;
import pages.P02_Profile;
import pages.P04_New_Customer;
import utilities.Utility;

import java.io.IOException;

public class TC02_Create_New_Customer extends TestBase {
    String UserId = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/logindata.json", "userid");
    String password = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/logindata.json", "password");
    String Customer_Name = faker.name().firstName();
    String DOF = "09252013";
    String Address = faker.address().streetAddress();
    String City = faker.address().city();
    String State = faker.address().state();
    String PIN = faker.number().digits(6);
    String Phone = faker.phoneNumber().subscriberNumber(11);
    String Email = faker.internet().emailAddress();
    static String Password=faker.internet().password();

    public TC02_Create_New_Customer() throws IOException, ParseException {
    }

    @Feature("New Cutomer")
    @Epic("New Epic")
    @Description("Check Create New Customer Function")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1, description = "New Customer Creation")
    public void createnewcustomer_P() {
        new P01_Login(driver).fillUserID(UserId).fillPassword(password).clickLogin();
        new P02_Profile(driver).opennewcustomer();
        new P04_New_Customer(driver).fillcustomername(Customer_Name).fillDOF(DOF).filladdress(Address);
        new P04_New_Customer(driver).fillcity(City).fillstate(State).fillPIN(PIN).fillphone(Phone).fillemail(Email).fillpassword(Password).clicksubmit();
        Utility.captureScreenshot(driver, "Create New Customer");
        Assert.assertTrue(new P04_New_Customer(driver).validatemsg());
        new P04_New_Customer(driver).clickcontinue();
    }
}
