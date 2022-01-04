package helpers;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Element {

    public static List<MobileElement> findElementsByDescriptionContains(AndroidDriver<MobileElement> driver,
                                                                        String contentDescription){
        return  driver.findElementsByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().descriptionContains(\"" + contentDescription + "\"))");
    }

    public static MobileElement findElementByText(AndroidDriver<MobileElement> driver, String text){
        return driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().text(\"" + text + "\"))");
    }

    public static boolean isElementExist(AndroidDriver<MobileElement> driver, By by){
        try {
            driver.findElement(by);
        } catch (NoSuchElementException e){
            return false;
        }
        return true;
    }

    public static boolean isElementWithTextExist(AndroidDriver<MobileElement> driver, String text){
        try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            findElementByText(driver, text);
        } catch (NoSuchElementException e){
            driver.manage().timeouts().implicitlyWait(Waiter.Timeout.IMPLICIT_S.getValue(), TimeUnit.SECONDS);
            return false;
        }
        driver.manage().timeouts().implicitlyWait(Waiter.Timeout.IMPLICIT_S.getValue(), TimeUnit.SECONDS);
        return true;
    }
}
