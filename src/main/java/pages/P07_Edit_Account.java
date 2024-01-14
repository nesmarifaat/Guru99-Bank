package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P07_Edit_Account {
    WebDriver driver;

    //TODO: 2- Define Constructor and set value of webdriver

    public P07_Edit_Account(WebDriver driver) {
        this.driver = driver;
    }

private final By AccountNo= By.xpath("//input[@name='accountno']");

    public P07_Edit_Account fillaccountnum(String AccountNo){
        driver.findElement(this.AccountNo).sendKeys(AccountNo);
        return this;
    }


    private final By Submitbutton= By.xpath("//input[@name='AccSubmit']");

    public P07_Edit_Account clicksubmitbutton(){
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.Submitbutton));
            driver.findElement(this.Submitbutton).click();

        }catch (TimeoutException ex){
            ex.printStackTrace();
        }

        return this;
    }
}
