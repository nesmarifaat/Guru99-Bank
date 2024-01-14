package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P01_Login {
    //TODO: 1- Define Webdriver
    WebDriver driver;

    //TODO: 2- Define Constructor and set value of webdriver

    public P01_Login(WebDriver driver) {
        this.driver = driver;
    }

    //TODO: 3- Define Locators using By

    private final By UserID=By.xpath("//input[@name='uid']");


    //TODO: 4- define action methods
    public P01_Login fillUserID(String UserID){
        try {
            shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.UserID));
            driver.findElement(this.UserID).sendKeys(UserID);
        }catch (TimeoutException ex){
            ex.printStackTrace();
        }
        return this;
    }

    //******************************************************************************************
    private final By Password=By.xpath("//input[@name='password']");
    public P01_Login fillPassword(String Password){
        try {
            shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.Password));
            driver.findElement(this.Password).sendKeys(Password);
        }catch (TimeoutException ex){
            ex.printStackTrace();
        }

        return this;
    }
    //*****************************************************************************************

    private final By Loginbutton=By.xpath("//input[@name='btnLogin']");
    public P01_Login clickLogin(){
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.Loginbutton));
            driver.findElement(this.Loginbutton).click();
        }catch (TimeoutException ex){
           ex.printStackTrace();
        }
        return this;
    }
//*********************************************************************************************

    private final By ManagerID=By.xpath("//td[normalize-space()='Manger Id : mngr546727']");

    public boolean checksucessfullogin(){
        try {
            shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.ManagerID));
            return driver.findElement(this.ManagerID).getText().equals("Manger Id : mngr546727");
        }catch (TimeoutException ex){
            driver.switchTo().alert().accept();
            //ex.printStackTrace();
        }
        return driver.findElement(this.ManagerID).getText().equals("Manger Id : mngr546727");
    }
    //******************************************************************************************

    public boolean checkfailedlogin(){
        return driver.findElement(this.UserID).isDisplayed();
    }
}
