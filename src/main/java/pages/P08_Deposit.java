package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P08_Deposit {
    WebDriver driver;

    //TODO: 2- Define Constructor and set value of webdriver

    public P08_Deposit(WebDriver driver) {
        this.driver = driver;
    }

    private final By AccountNo= By.xpath("//input[@name='accountno']");

    public P08_Deposit fillaccountnum(String AccountNo){
        driver.findElement(this.AccountNo).sendKeys(AccountNo);
        return this;
    }

    private final By Amount= By.xpath("//input[@name='ammount']");

    public P08_Deposit fillamount(String Amount){
        try {
            shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.Amount));
            driver.findElement(this.Amount).sendKeys(Amount);

        }catch (TimeoutException ex){
            ex.printStackTrace();
        }

        return this;
    }
private final By Description=By.xpath("//input[@name='desc']");
    public P08_Deposit filldescription(String Description){
        try {
            shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.Description));
            driver.findElement(this.Description).sendKeys(Description);

        }catch (TimeoutException ex){
            ex.printStackTrace();
        }

        return this;
    }

    private final By Submitbutton=By.xpath("//input[@name='AccSubmit']");
    public P08_Deposit clicksubmit(){
        driver.findElement(this.Submitbutton).click();
        return this;
    }
}
