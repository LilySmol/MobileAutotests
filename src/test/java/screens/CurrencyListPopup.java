package screens;

import helpers.Element;
import helpers.Swipe;
import helpers.Waiter;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CurrencyListPopup {
    private AndroidDriver driver;

    public CurrencyListPopup(AndroidDriver driver){
        this.driver = driver;
    }

    public void currencyClick(String currency){
        Swipe.swipeDownToElement(driver, currency);
        MobileElement currencyRadioButton = Element.findElementByText(driver, currency);
        try {
            Waiter.waitUntilElementNotMove(currencyRadioButton);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        currencyRadioButton.click();
    }
}
