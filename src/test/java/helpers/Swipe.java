package helpers;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

public class Swipe {

    public static void swipeUp(AndroidDriver<MobileElement> driver) {
        Dimension windowSize = driver.manage().window().getSize();
        int width = (int) (windowSize.width * 0.95);
        int startPoint = (int) (windowSize.getHeight() * 0.05);
        int endPoint = (int) (windowSize.getHeight() * 0.75);
        new TouchAction(driver)
                .longPress(PointOption.point(width, startPoint))
                .moveTo(PointOption.point(width, endPoint))
                .release().perform();
    }

    public static MobileElement scrollIntoView(AndroidDriver<MobileElement> driver, String text) {
        MobileElement element = driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector())" +
                        ".setAsVerticalList().scrollIntoView(new UiSelector().text(\"" + text + "\"))");
        return element;
    }

    public static void swipeDownToElement(AndroidDriver<MobileElement> driver, String text){
        long timeoutExpired = System.currentTimeMillis() + Waiter.Timeout.WAIT_ELEMENT_MS.getValue();
        while (!Element.isElementWithTextExist(driver, text)) {
            long wait = timeoutExpired - System.currentTimeMillis();
            if (wait <= 0) {
                throw new RuntimeException("Could not swipe to element with text '" + text + "'");
            }
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector())" +
                            ".scrollForward()");
        }
    }
}
