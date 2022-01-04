package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.util.List;

public class Menu {
    private AndroidDriver driver;

    private By menuItemBy = By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.joom:id/main_bottom_bar']//android.view.ViewGroup");  ;

    public Menu(AndroidDriver driver){
        this.driver = driver;
    }

    public ProfileScreen openUserProfile(){
        List<AndroidElement> menuItems = driver.findElements(menuItemBy);
        menuItems.get(4).click();
        return new ProfileScreen(driver);
    }
}
