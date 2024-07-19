package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class tripDetailsPage extends pageBase{
    By addCompanion = By.xpath("//*[@id=\"root\"]/div[1]/div[5]/main/div[2]/div/div[2]/div/div[1]/div[2]/div/div[1]/div[1]/div[2]/button");
    By firstNameTxtBox = By.id("first_name");
    By lastNameTxtBox = By.id("last_name");
    By relationshipTxtBox = By.id("relationship");
    By saveButton = By.xpath("//button[@label='Save'][contains(.,'Save')]");
    public void addTripDetails(WebDriver driver, WebDriverWait wait, Actions actions) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(addCompanion)));
        moveAndClick(driver.findElement(addCompanion), actions);

        //Add Companion
        writeText(driver.findElement(firstNameTxtBox), wait, "Companion");
        writeText(driver.findElement(lastNameTxtBox), wait, generateFakeString());
        writeText(driver.findElement(relationshipTxtBox), wait, generateFakeString());

        moveAndClick(driver.findElement(saveButton), actions);
    }
}
