package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class addPackagePage extends pageBase{

    By titleTxtBox = By.id("package_title");
    By priorityTxtBox = By.id("package_priority");
    By featureName = By.id("feature_name");
    By saveButton = By.xpath("//button[@type='button'][contains(.,'Save')]");

    public String addPackage(WebDriver driver, WebDriverWait wait, Actions actions)
    {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(titleTxtBox)));
        String packageName = generateFakeData("Package ");
        writeText(driver.findElement(titleTxtBox), wait, packageName);
        scrollToElement(driver.findElement(priorityTxtBox), driver);
        writeText(driver.findElement(priorityTxtBox), wait, "1");
        writeText(driver.findElement(featureName), wait, "Travel");

        moveAndClick(driver.findElement(saveButton), actions);
        return  packageName;

    }
}
