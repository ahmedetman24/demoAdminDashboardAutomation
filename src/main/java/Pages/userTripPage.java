package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class userTripPage extends pageBase{
    By packagesDropdownList = By.id("entity");
    By createButton = By.xpath("//button[@type='button'][contains(.,'Create')]");

    public void completeTrip(String packageName, WebDriver driver, WebDriverWait wait) throws InterruptedException {
        selectFromDropDownList(driver.findElement(packagesDropdownList), packageName);

        //Create Event
        scrollToTop(driver);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(createButton)));
        Thread.sleep(3000);
        driver.findElement(createButton).click();
    }
}
