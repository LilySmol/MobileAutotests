package screens;

import helpers.Element;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.List;

public class ProductsScreen {
    private AndroidDriver driver;

    public ProductsScreen(AndroidDriver driver){
        this.driver = driver;
    }

    public List<MobileElement> getPrices(){
        return Element.findElementsByDescriptionContains(driver, "Current price:");
    }
}
