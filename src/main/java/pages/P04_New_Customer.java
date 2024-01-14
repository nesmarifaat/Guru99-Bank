package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P04_New_Customer {
    WebDriver driver;

    //TODO: 2- Define Constructor and set value of webdriver

    public P04_New_Customer(WebDriver driver) {
        this.driver = driver;
    }


    private final By Customername= By.xpath("//input[@name='name']");
    public P04_New_Customer fillcustomername(String Customername){
        driver.findElement(this.Customername).sendKeys(Customername);
        return this;
    }

    //*********************************************************************

    private final By DOF=By.xpath("//input[@type=\"date\"]");

    public P04_New_Customer fillDOF(String DOF){
        try {
            shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.DOF));
            driver.findElement(this.DOF).sendKeys(DOF);
        }catch (TimeoutException ex){
            ex.printStackTrace();
        }

        return this;
    }

    //***************************************************************************************
    private final By Address=By.xpath("//textarea[@name='addr']");
    public P04_New_Customer filladdress(String Address){
        driver.findElement(this.Address).sendKeys(Address);
        return this;
    }

    //*****************************************************************************************
    private final By City=By.xpath("//input[@name='city']");
    public P04_New_Customer fillcity(String City){
        driver.findElement(this.City).sendKeys(City);
        return this;
    }

    //*****************************************************************************************
    private final By State=By.xpath("//input[@name='state']");
    public P04_New_Customer fillstate(String State){
        driver.findElement(this.State).sendKeys(State);
        return this;
    }


    //*****************************************************************************************
    private final By PIN=By.xpath("//input[@name='pinno']");
    public P04_New_Customer fillPIN(String PIN){
        driver.findElement(this.PIN).sendKeys(PIN);
        return this;
    }

    //*****************************************************************************************
    private final By Phone=By.xpath("//input[@name='telephoneno']");
    public P04_New_Customer fillphone(String phone){
        try {
            shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.Phone));
            driver.findElement(this.Phone).sendKeys(phone);
        }catch (TimeoutException ex){
            ex.printStackTrace();
        }

        return this;
    }

    //*****************************************************************************************
    private final By Email=By.xpath("//input[@name='emailid']");
    public P04_New_Customer fillemail(String Email){
        try {
            shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.Email));
            driver.findElement(this.Email).sendKeys(Email);
        }catch (TimeoutException ex){
            ex.printStackTrace();
        }
        return this;
    }

    //*****************************************************************************************
    private final By Password=By.xpath("//input[@name='password']");
    public P04_New_Customer fillpassword(String Password){
        try {
            shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.Password));
            driver.findElement(this.Password).sendKeys(Password);
        }catch (TimeoutException ex){
            ex.printStackTrace();
        }
        return this;
    }

    //*****************************************************************************************
    private final By Submit=By.xpath("//input[@name='sub']");
    public P04_New_Customer clicksubmit(){
        try {
            shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.Submit));
            driver.findElement(this.Submit).click();
        }catch (TimeoutException ex){
            ex.printStackTrace();
        }
        return this;
    }

    //************************************************************************************
    //TODO: Validate that new customer is successfully created

    private final By Sucessmsg=By.xpath("//p[@class='heading3']");

    public boolean validatemsg(){
        return driver.findElement(this.Sucessmsg).isDisplayed();
    }

    private final By Continue=By.xpath("//a[normalize-space()='Continue']");

    public P04_New_Customer clickcontinue(){
        driver.findElement(this.Continue).click();
        return this;
    }
}
