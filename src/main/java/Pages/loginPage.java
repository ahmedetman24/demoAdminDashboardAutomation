package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage extends pageBase{

    By userNameTextBox = By.id("username");
    By passwordTextBox = By.id("password");
    By loginButton = By.xpath("//button[@type='submit'][contains(.,'Login')]");
    By skipButton = By.xpath("//button[@type='button'][contains(.,'Skip (only for testing)')]");

    public void login(String url, String username, String password, WebDriver driver, Actions actions, WebDriverWait wait)
    {
        driver.get(url);

        driver.findElement(userNameTextBox).sendKeys(username);
        driver.findElement(passwordTextBox).sendKeys(password);

        moveAndClick(driver.findElement(loginButton), actions);

        //Skip
        wait.until(ExpectedConditions.elementToBeClickable(skipButton));
        driver.findElement(skipButton).click();
    }
}
