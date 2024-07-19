package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class usersPage extends pageBase{

    By addUserButton = By.xpath("//span[contains(.,'Add User')]");

    public void addUser(WebDriver driver, Actions actions)
    {
        moveAndClick(driver.findElement(addUserButton), actions);
    }
}
