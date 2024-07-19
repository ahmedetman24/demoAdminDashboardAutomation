package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class newEventPage extends pageBase{

    By eventNameTxtBox = By.xpath("(//input[@class='Input_root__fi0ZK'])[1]");
    By eventTypeDropdownList = By.xpath("(//select[@class='Input_root__fi0ZK Input_selectInput__aHlvF'])[1]");
    By eventSlugTxtBox = By.xpath("(//input[@class='Input_root__fi0ZK'])[2]");
    By startDateSelector = By.xpath("(//input[contains(@type,'date')])[1]");
    By startTimeTxtBox = By.xpath("(//input[@type='time'])[1]");
    By endDateSelector = By.xpath("(//input[@type='date'])[2]");
    By endTimeTxtBox = By.xpath("(//input[@type='time'])[2]");
    By timezoneDropdownList = By.xpath("(//select[@class='Input_root__fi0ZK Input_selectInput__aHlvF'])[2]");
    By createButton = By.xpath("//button[@type='button'][contains(.,'Create')]");


    public String createNewEvent(WebDriverWait wait, WebDriver driver, int futureHours, Actions actions) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(eventNameTxtBox)));
        String eventName = generateFakeData("Automation Event ");
        driver.findElement(eventNameTxtBox).sendKeys(eventName);
        selectFromDropDownList(driver.findElement(eventTypeDropdownList), "Meeting");
        driver.findElement(eventSlugTxtBox).sendKeys(generateFakeData("eventslug"));
        //Start Date
        driver.findElement(startDateSelector).click();
        driver.findElement(startDateSelector).sendKeys(getTodayDate());

        //Start Time
        driver.findElement(startTimeTxtBox).sendKeys(getCurrentTime());
        Thread.sleep(1000);
        driver.findElement(startTimeTxtBox).sendKeys(Keys.ENTER);

        //End Date
        driver.findElement(endDateSelector).click();
        driver.findElement(endDateSelector).sendKeys(getTodayDate());

        //End Time
        driver.findElement(endTimeTxtBox).sendKeys(getFutureTime(futureHours));
        Thread.sleep(3000);
        // Go 2 Arrows left
        repeatKeyboardKeysAction(Keys.ARROW_LEFT, 2, endTimeTxtBox, driver);
        // Go 3 Arrows down
        repeatKeyboardKeysAction(Keys.ARROW_DOWN, futureHours, endTimeTxtBox, driver);
        driver.findElement(endTimeTxtBox).sendKeys(Keys.ENTER);

        //Timezone
        selectFromDropDownList(driver.findElement(timezoneDropdownList), "(UTC+02:00) Cairo");

        //Create Event
        scrollToTop(driver);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(createButton)));
        Thread.sleep(3000);
        driver.findElement(createButton).click();

        return eventName;
    }
}
