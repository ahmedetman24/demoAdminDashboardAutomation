package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class myEventsPage extends pageBase{
    By newEventButton = By.xpath("//p[@class='Text_root__M6tno'][contains(.,'New Event')]");
    By startFromScratchBtn = By.xpath("//p[contains(.,'Start From Scratch')]");
    By myCreatedEvent;

    public void startEventFromScratch(WebDriver driver, WebDriverWait wait, Actions actions)
    {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(newEventButton)));
        driver.findElement(newEventButton).click();

        //Start From Scratch
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(startFromScratchBtn)));
        driver.findElement(startFromScratchBtn).click();
    }
    public void openCreatedEvent(String eventName, WebDriver driver, WebDriverWait wait)
    {
        myCreatedEvent = By.xpath("(//div[contains(.,'"+eventName+"')])[7]");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(myCreatedEvent)));
        driver.findElement(myCreatedEvent).click();
    }
}
