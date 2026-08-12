package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;

@Epic("Интернет-магазин")
@Feature("Checkout")
@Owner("Fatikhov Dinar Din@com.com")
public class OverviewTest extends BaseTest {

    private void openOverview() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.switchToCart();
        cartPage.clickCheckout();
        checkoutPage.fillCustomerInformation(
                "Ivan",
                "Ivanov",
                "12345");
        checkoutPage.clickContinue();
    }

    @Test(priority = 1)
    @Story("Проверка страницы Overview")
    public void checkOverview() {
        openOverview();assertEquals(overviewPage.getNamePage(), "Checkout: Overview");
        assertEquals(overviewPage.getTotal(), "Total: $82.05");
    }

    @Test(priority = 2)
    @Story("Успешное завершение заказа")
    public void checkFinish() {
        openOverview();
        overviewPage.clickFinish();
        assertTrue(completePage.isOrderCompleted());
    }

    @Test(priority = 3)
    @Story("Отмена заказа")
    public void checkCancel() {
        openOverview();
        overviewPage.clickCancel();
        assertEquals(productsPage.getNamePage(), "Products");
    }
}