package tests;

import org.testng.annotations.Test;
import user.UserFactory;

import java.util.List;

import static enums.TitleNaming.CART;
import static enums.TitleNaming.PRODUCTS;
import static org.testng.Assert.*;

public class CartTest extends BaseTest {
    List<String> goodsList =
            List.of("Sauce Labs Bolt T-Shirt",
                    "Sauce Labs Bike Light",
                    "Sauce Labs Fleece Jacket");
    @Test
    public void checkGoodAdded() {
        System.out.println("CartTest.checkGoodAdded running is thread: " + Thread.currentThread().getId());
        loginPage.open();
        loginPage.login(UserFactory.withAdminPermission());
        assertEquals(productsPage.getNamePage(), PRODUCTS.getDisplayName(),
                "Name of the page doesn't correspond to the expected");
        for (String goodName : goodsList){
            productsPage.addToCart(goodName);
        }
        productsPage.switchToCart();
        assertEquals(productsPage.getNamePage(), CART.getDisplayName(),
                "Name of the page doesn't correspond to the expected");
        assertFalse(cartPage.getProductsNames().isEmpty());
        assertEquals(cartPage.getProductsNames().size(), 3);
        assertTrue(cartPage.getProductsNames().contains("Sauce Labs Fleece Jacket"));
        assertEquals(cartPage.getProductsNames(), goodsList);
    }
}