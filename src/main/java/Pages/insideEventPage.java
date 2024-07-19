package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class insideEventPage extends pageBase{
    By registrationButton = By.xpath("//span[@class='Text_root__M6tno'][contains(.,'Registration')]");
    By attendeesButton = By.xpath("//p[@class='Text_root__M6tno'][contains(.,'Attendees')]");
    By allUsersButton = By.xpath("(//div[contains(.,'All Users')])[7]");
    By createdUser;

    public void openAttendeePage(WebDriver driver, Actions actions)
    {
        moveAndClick(driver.findElement(registrationButton), actions);
        moveAndClick(driver.findElement(attendeesButton), actions);

        //All Users
        moveAndClick(driver.findElement(allUsersButton), actions);
    }

    public String checkAttendeeExistence(WebDriverWait wait, WebDriver driver, Actions actions, String userName)
    {
        wait.until(ExpectedConditions.elementToBeClickable(allUsersButton));
        moveAndClick(driver.findElement(allUsersButton), actions);
        createdUser = By.xpath("//span[@class='Text_root__M6tno'][contains(.,'"+userName+"')]");
        return driver.findElement(createdUser).getText();
    }
}
