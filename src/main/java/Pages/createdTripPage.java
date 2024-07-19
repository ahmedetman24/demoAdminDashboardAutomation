package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class createdTripPage extends pageBase{

    By saveButton = By.xpath("//button[@type='button'][contains(.,'Save')]");
    By successfulSaveMessage = By.xpath("//div[@role='status'][contains(.,'User updated successfully')]");
    By attendeesButton = By.xpath("//p[@class='Text_root__M6tno'][contains(.,'Attendees')]");

    public void saveTrip(WebDriver driver, WebDriverWait wait, Actions actions) throws InterruptedException {
        //Save Trip
        Thread.sleep(5000);
        scrollToTop(driver);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(saveButton)));
        driver.findElement(saveButton).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(successfulSaveMessage)));

        //Load attendees
        moveAndClick(driver.findElement(attendeesButton), actions);
    }
}
