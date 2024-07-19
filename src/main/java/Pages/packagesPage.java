package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class packagesPage extends pageBase{
    By planningButton = By.xpath("//span[@class='Text_root__M6tno'][contains(.,'Planning')]");
    By packagesButton = By.xpath("//p[@class='Text_root__M6tno'][contains(.,'Packages')]");
    By newPackageButton = By.xpath("//span[contains(.,'New Package')]");

    public void openNewPackagePage(WebDriver driver, Actions actions)
    {
        moveAndClick(driver.findElement(planningButton), actions);
        moveAndClick(driver.findElement(packagesButton), actions);
        moveAndClick(driver.findElement(newPackageButton), actions);
    }
}
