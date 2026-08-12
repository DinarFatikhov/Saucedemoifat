package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletePage extends BasePage {
    private final By completeMessage = By.xpath(DATA_TEST_PATTERN.formatted("complete-header"));

    public CompletePage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка успешного завершения заказа")
    public boolean isOrderCompleted() {
        return driver.findElement(completeMessage).isDisplayed();
    }
}