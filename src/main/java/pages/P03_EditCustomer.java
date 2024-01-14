package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P03_EditCustomer {
    WebDriver driver;

    //TODO: 2- Define Constructor and set value of webdriver

    public P03_EditCustomer(WebDriver driver) {
        this.driver = driver;
    }

    private final By CustomerID= By.xpath("//input[@name='cusid']");

    public P03_EditCustomer fillcutomerid(String CutomerID){
        try {
            shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.CustomerID));
            driver.findElement(this.CustomerID).sendKeys(CutomerID);
        }catch (TimeoutException ex){
            ex.printStackTrace();
        }
        return this;
    }

    private final By Submit=By.xpath("//input[@name='AccSubmit']");
    public P03_EditCustomer clicksubmit(){
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.Submit));
            driver.findElement(this.Submit).click();

        }catch (TimeoutException ex){
            ex.printStackTrace();
        }
        return this;
    }

    //***************************************************************************************

    private final By editaddress=By.xpath("//textarea[@name='addr']");
    public  P03_EditCustomer editaddress(){
        driver.findElement(this.editaddress).getText().replace("Alex","Sohag");

        return this;
    }
    private final By editphone=By.xpath("//input[@name='telephoneno']");
    public P03_EditCustomer editphonenum(){
        driver.findElement(this.editphone).sendKeys(Keys.DELETE);
        driver.findElement(this.editphone).sendKeys("01225963741");
        return this;
    }

    private final By Submitbutton=By.xpath("//input[@type=\"submit\"]");

    public P03_EditCustomer clicksubmitbutton(){
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.Submitbutton));
            driver.findElement(this.Submitbutton).click();
           driver.switchTo().alert().accept();

        }catch (TimeoutException ex){
            ex.printStackTrace();
        }

        return this;
    }
    private final By editform=By.xpath("//p[@align=\"center\"]");
    public boolean validateeditform(){
        return driver.findElement(this.editform).isDisplayed();
    }


}
