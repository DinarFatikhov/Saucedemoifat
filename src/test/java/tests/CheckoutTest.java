package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

@Epic("Интернет-магазин")
@Feature("Оформление заказа")
@Owner("Fatikhov Dinar Din@com.com")
public class CheckoutTest extends BaseTest {
    List<String> goodsList = List.of(
                    "Sauce Labs Bolt T-Shirt",
                    "Sauce Labs Bike Light",
                    "Sauce Labs Fleece Jacket");

    @Story("Успешное оформление заказа")
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка оформления заказа с тремя товарами")
    public void checkout() {

        loginPage.open();
        loginPage.login(withAdminPermission());
        assertEquals(
                productsPage.getNamePage(),
                "Products",
                "Name of the page doesn't correspond to the expected");

        for (String goodName : goodsList) {
            productsPage.addToCart(goodName);
        }

        productsPage.switchToCart();
        assertEquals(cartPage.getProductsNames().size(), 3,
                "Количество товаров в корзине не соответствует ожидаемому");

        cartPage.clickCheckout();checkoutPage.fillCustomerInformation(
                "Ivan",
                "Ivanov",
                "12345");

        checkoutPage.clickContinue();
        assertEquals(overviewPage.getTotal(),
                "Total: $82.05",
                "Total doesn't correspond to the expected");

        overviewPage.clickFinish();
        assertTrue(completePage.isOrderCompleted());
    }
}