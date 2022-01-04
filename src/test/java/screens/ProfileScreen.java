package screens;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ProfileScreen {
    private AndroidDriver driver;

    private By settingsButtonBy = MobileBy.AccessibilityId("Settings");

    public ProfileScreen(AndroidDriver driver){
        this.driver = driver;
    }

    public SettingsScreen openSettings(){
        driver.findElement(settingsButtonBy).click();
        return new SettingsScreen(driver);
    }
}
