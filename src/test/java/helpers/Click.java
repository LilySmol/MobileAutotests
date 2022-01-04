package helpers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Click {

    public static void goBack(AndroidDriver driver){
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
    }
}
