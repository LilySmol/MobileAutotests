package tests;

import helpers.Click;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.*;

import java.util.List;

public class ProductsTests extends BaseTestSetUp {

    @Test(description = "Выбор валюты")
    public void chooseCurrency() throws InterruptedException {
        Popup popup = new Popup(driver);
        popup.closeAd();
        ProfileScreen profileScreen = new Menu(driver).openUserProfile();
        SettingsScreen settingsScreen = profileScreen.openSettings();
        settingsScreen.openCurrencyList()
                .currencyClick("US Dollar");
        popup.waitPopupUntilClose();
        Click.goBack(driver);
        Click.goBack(driver);
        List<MobileElement> prices = new ProductsScreen(driver).getPrices();

        Assert.assertTrue(prices.size() > 0, "Количество товаров больше 0");
        Assert.assertTrue(prices.stream().allMatch(i -> i.getText().contains("$")),
                "Поле цены содержит $");
    }
}
