package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P05_Delete_Customer {

    WebDriver driver;

    //TODO: 2- Define Constructor and set value of webdriver

    public P05_Delete_Customer(WebDriver driver) {
        this.driver = driver;
    }

    private final By CustomerID=By.xpath("//input[@name='cusid']");

    public P05_Delete_Customer fillcustomerid(String CustomerID){
        driver.findElement(this.CustomerID).sendKeys(CustomerID);
        return this;
    }

    private final By Submit=By.xpath("//input[@name='AccSubmit']");

    public P05_Delete_Customer clicksubmit(){
        try {
            shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.Submit));
            driver.findElement(this.Submit).click();
            driver.switchTo().alert().accept();
        }catch (TimeoutException ex){
            ex.printStackTrace();
        }

        return this;
    }
}
