package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Objects;

public class CommonMethods {

    WebDriver driver;
    public CommonMethods (WebDriver driver) { this.driver = driver; }

    public String getTitle () {
        return driver.getTitle();
    }

    public void clickOnButton (By btn) {
        driver.findElement(btn).click();
    }

    public String getText(By element) {
        return driver.findElement(element).getText();
    }
    public void setText(By element, String string) {
        driver.findElement(element).sendKeys(string);
    }
    
    public void setTextWithClick(By element, String string) {
    	WebElement wb = driver.findElement(element);
    	Actions action = new Actions(driver);
    	action.moveToElement(wb).click().sendKeys(string).build().perform();
    }
    
    
    
//    public void select(By element, String string) throws InterruptedException {
//    	Select state = new Select(driver.findElement(element));
//		state.selectByVisibleText(string);
//    	
//    	WebElement items = driver.findElement(element);
//		Select item_s = new Select(items);
//		Thread.sleep(3000);
//		item_s.selectByVisibleText(string);
//    }

    public void back () {
        if (!Objects.equals(driver.getCurrentUrl(), Locators.homePageUrl))
        {
            driver.navigate().back();
        }
    }
}
