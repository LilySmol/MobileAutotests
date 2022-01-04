package screens;

import helpers.Element;
import helpers.Swipe;
import helpers.Waiter;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class Popup {
    private AndroidDriver driver;

    private By adPopupBy = By.id("bottom_sheet_content");

    public Popup(AndroidDriver driver) {
        this.driver = driver;
    }

    public void closeAd() throws InterruptedException {
        if (Element.isElementExist(driver, adPopupBy)) {
            Waiter.waitUntilElementNotMove((MobileElement) driver.findElement(adPopupBy));
            Swipe.swipeUp(driver);
            waitPopupUntilClose();
        }
    }

    public void waitPopupUntilClose(){
        Waiter.waitInvisibilityOfElementLocated(driver, adPopupBy);
    }
}
