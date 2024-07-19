package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class tripInfoPage extends pageBase{

    By tripInfoButton = By.xpath("//p[@class='Text_root__M6tno'][contains(.,'Trip Info')]");
    By addTripButton = By.xpath("//div[@class='flex items-center space-x-s15'][contains(.,'Add Trip')]");

    public void addTrip(WebDriver driver, WebDriverWait wait, Actions actions) throws InterruptedException {
        scrollToTop(driver);
        Thread.sleep(5000);
        driver.findElement(tripInfoButton).click();

        // Add a trip
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(addTripButton)));
        moveAndClick(driver.findElement(addTripButton), actions);
    }
}
