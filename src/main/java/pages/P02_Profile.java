package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P02_Profile {
    WebDriver driver;

    //TODO: 2- Define Constructor and set value of webdriver

    public P02_Profile(WebDriver driver) {
        this.driver = driver;
    }

    private final By NewCustomer = By.xpath("//a[normalize-space()='New Customer']");

    private final By ADVI = By.xpath(" //span[@dir=\"auto\"]");

    public P02_Profile opennewcustomer() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.NewCustomer));
            driver.findElement(this.NewCustomer).click();
        } catch (TimeoutException ex) {
            driver.findElement(this.ADVI).click();
            ex.printStackTrace();
        }
        driver.findElement(this.NewCustomer).click();

        return this;
    }

    //****************************************************************************

    private final By EditCustomer = By.xpath("//a[normalize-space()='Edit Customer']");

    public P02_Profile openeditcustomer() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.EditCustomer));
            driver.findElement(this.EditCustomer).click();
        } catch (TimeoutException ex) {
            driver.switchTo().alert().accept();
            ex.printStackTrace();
        }

        return this;

    }

    //***************************************************************************************
    //TODO: Open Delete Customer Tap
    private final By DeleteCustomer=By.xpath("//a[normalize-space()='Delete Customer']");

    public P02_Profile opendeleteaccount(){
        driver.findElement(this.DeleteCustomer).click();
        return this;
    }

    //********************************************************************************************
    //TODO: Open New Account
    private final By NewAccount=By.xpath("//a[normalize-space()='New Account']");

    public P02_Profile opennewaccount()
    {
        driver.findElement(this.NewAccount).click();
        return this;
    }


    //********************************************************************************************
    //TODO: Open Edit Account
    private final By EditAccount=By.xpath("//a[normalize-space()='Edit Account']");

    public P02_Profile openeditaccount()
    {
        driver.findElement(this.EditAccount).click();
        return this;
    }


}
