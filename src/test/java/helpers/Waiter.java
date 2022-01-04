package helpers;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Waiter {

    public enum Timeout{
        INVISIBILITY_S(5),
        IMPLICIT_S(15),
        WAIT_ELEMENT_S(10),
        WAIT_ELEMENT_MS(10000);

        private int timeout;

        Timeout(int timeout){
            this.timeout = timeout;
        }

        public int getValue(){
            return timeout;
        }
    }

    public static void waitInvisibilityOfElementLocated(AndroidDriver<MobileElement> driver, By by){
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Timeout.INVISIBILITY_S.getValue());
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        driver.manage().timeouts().implicitlyWait(Waiter.Timeout.IMPLICIT_S.getValue(), TimeUnit.SECONDS);
    }

    public static void waitInvisibilityOfElement(AndroidDriver<MobileElement> driver, MobileElement element){
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Timeout.INVISIBILITY_S.getValue());
        wait.until(ExpectedConditions.invisibilityOf(element));
        driver.manage().timeouts().implicitlyWait(Waiter.Timeout.IMPLICIT_S.getValue(), TimeUnit.SECONDS);
    }

    public static void waitUntilElementNotMove(MobileElement element) throws InterruptedException {
        long timeoutExpired = System.currentTimeMillis() + Timeout.WAIT_ELEMENT_S.getValue();
        int x = element.getLocation().x;
        int y = element.getLocation().y;
        Thread.sleep(400);
        while (element.getLocation().x != x || element.getLocation().y != y){
            long wait = timeoutExpired - System.currentTimeMillis();
            if (wait <= 0) {
                throw new RuntimeException("Element " + element + " still moving");
            }
            x = element.getLocation().x;
            y = element.getLocation().y;
            Thread.sleep(400);
        }
    }
}
