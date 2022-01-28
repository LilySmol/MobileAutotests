package tests;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppiumDemoTests extends BaseTestSetUp {

    @Test(description = "Демонстрация свайпа вниз")
    public void swipeDownTest(){
        driver.findElement(MobileBy.AccessibilityId("Graphics")).click();

        Dimension screenSize = driver.manage().window().getSize();
        int middleOfScreen = screenSize.width / 2;
        int startPoint = (int) (screenSize.getHeight() * 0.95);
        int endPoint = (int) (screenSize.getHeight() * 0.05);
        new TouchAction(driver)
                .longPress(PointOption.point(middleOfScreen, startPoint))
                .moveTo(PointOption.point(middleOfScreen, endPoint))
                .release().perform();
    }

    @Test(description = "Демонстрация свайпа до элемента с текстом")
    public void swipeToText(){
        driver.findElement(MobileBy.AccessibilityId("Views")).click();

        MobileElement element = driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector())" +
                        ".scrollIntoView(new UiSelector().text(\"Visibility\"))");
        element.click();
    }

    @Test(description = "Демонстрация горизонтального свайпа в рамках определенного элемента")
    public void swipeToText1(){
        driver.findElement(MobileBy.AccessibilityId("Views")).click();
        driver.findElement(MobileBy.AccessibilityId("Gallery")).click();
        driver.findElement(MobileBy.AccessibilityId("1. Photos")).click();

        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).resourceId(\"io.appium.android.apis:id/gallery\"))" +
                        ".setAsHorizontalList()" +
                        ".scrollForward(1)");
    }

    @Test(description = "Тест на проверку текста")
    public void test(){
        driver.findElement(MobileBy.AccessibilityId("Text")).click();
        driver.findElement(MobileBy.AccessibilityId("Marquee")).click();
        String buttonText = driver.findElementsByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.widget.Button\"))").get(0).getText();

        Assert.assertEquals(buttonText, "This use the default marquee animation limit of 3");
    }
}
