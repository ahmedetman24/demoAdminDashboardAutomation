package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class addUserPage extends pageBase{

    By firstNameTextBox = By.id("firstName");
    By lastNameTextBox = By.id("lastName");
    By emailTextBox = By.id("email");
    By createButton = By.xpath("//button[contains(.,'Create')]");

    public String registerNewUser(WebDriver driver, WebDriverWait wait)
    {
        String firstName = generateFakeString();
        String lastName = generateFakeString();
        writeText(driver.findElement(firstNameTextBox), wait, firstName);
        writeText(driver.findElement(lastNameTextBox), wait, lastName);
        writeText(driver.findElement(emailTextBox), wait, generateFakeData("test.email")+"@test.com");

        //Create user
        scrollToTop(driver);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(createButton)));
        driver.findElement(createButton).click();

        return firstName+" "+lastName;
    }
}
