package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P06_New_Account {
    WebDriver driver;

    //TODO: 2- Define Constructor and set value of webdriver

    public P06_New_Account(WebDriver driver) {
        this.driver = driver;
    }

    private final By CustomerID=By.xpath("//input[@name='cusid']");

    public P06_New_Account fillcustomerid(String CustomerID){
        driver.findElement(this.CustomerID).sendKeys(CustomerID);
        return this;
    }

    private final By AccountType=By.xpath("//select[@name='selaccount']");

    public P06_New_Account selectaccount(){
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.AccountType));
            driver.findElement(this.AccountType).sendKeys(Keys.ARROW_DOWN);
            driver.findElement(this.AccountType).sendKeys(Keys.ENTER);
        }catch (TimeoutException ex){
            ex.printStackTrace();
        }

        return this;
    }

    private final By intialdeposit=By.xpath("//input[@name='inideposit']");
    public P06_New_Account filldeposit(String intialdeposit){
        driver.findElement(this.intialdeposit).sendKeys(intialdeposit);
        return this;
    }

    private final By Submitbutton=By.xpath("//input[@type=\"submit\"]");
    public P06_New_Account clicksubmitbutton(){
        driver.findElement(this.Submitbutton).click();
        return this;
    }

    private final By sucessmsg=By.xpath("//p[@class='heading3']");
    public boolean verfiysucessmsg(){
        return driver.findElement(this.sucessmsg).isDisplayed();
    }


}
