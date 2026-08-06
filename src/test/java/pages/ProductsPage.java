package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    private static final String ADD_TO_CART = "//*[text()='%s']//ancestor::div[@class='inventory_item']//child::*[text()='Add to cart']";
    private final By pageName = By.xpath(DATA_TEST_PATTERN.formatted("title"));
    private final By counter = By.xpath(DATA_TEST_PATTERN.formatted("shopping-cart-badge"));
    private final By cartLink = By.xpath(DATA_TEST_PATTERN.formatted("shopping-cart-link"));
    private final By addToCartBnt = By.xpath(TEXT_LOCATOR_PATTERN.formatted("Add to cart"));

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart(final String goodsName) {
        //By goods = By.xpath(String.format(ADD_TO_CART, goodsName));
        By goods = By.xpath(ADD_TO_CART.formatted(goodsName));
        driver.findElement(goods).click();
    }

    public void addToCart(int goodsIndex) {
        driver.findElements(addToCartBnt).get(goodsIndex).click();
    }

    @Step("Получение значения счетчика товаров в корзине")
    public String checkCounterValue() {
        return driver.findElement(counter).getText();
    }

    @Step("Получение цвета счетчика корзины")
    public String checkCounterColor() {
        return driver.findElement(counter).getCssValue("background-color");
    }

    @Step("Переход на страницу корзины")
    public void switchToCart() {
         driver.findElement(cartLink).click();
    }
 }