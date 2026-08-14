package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private final By firstName = By.xpath(DATA_TEST_PATTERN.formatted("firstName"));
    private final By lastName = By.xpath(DATA_TEST_PATTERN.formatted("lastName"));
    private final By postalCode = By.xpath(DATA_TEST_PATTERN.formatted("postalCode"));
    private final By continueButton = By.xpath(DATA_TEST_PATTERN.formatted("continue"));
    private final By cancelButton = By.xpath(DATA_TEST_PATTERN.formatted("cancel"));

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Заполнение данных покупателя")
    public void fillCustomerInformation(
            String firstNameValue,
            String lastNameValue,
            String postalCodeValue) {

        driver.findElement(firstName).sendKeys(firstNameValue);
        driver.findElement(lastName).sendKeys(lastNameValue);
        driver.findElement(postalCode).sendKeys(postalCodeValue);
    }

    @Step("Переход к проверке заказа")
    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    @Step("Отмена оформления заказа")
    public void clickCancel() {
        driver.findElement(cancelButton).click();
    }
}