package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class SettingsScreen {
    private AndroidDriver driver;

    private By currencyButtonBy = By.xpath("//android.widget.TextView[@text='Currency']");

    public SettingsScreen(AndroidDriver driver){
        this.driver = driver;
    }

    public CurrencyListPopup openCurrencyList(){
        driver.findElement(currencyButtonBy).click();
        return new CurrencyListPopup(driver);
    }
}
