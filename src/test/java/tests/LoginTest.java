package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Test(description = "Проверка верной авторизации", priority = 3)
    public void login() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        boolean titleDisplayed = productsPage.pagesIsOpen();

        assertTrue(titleDisplayed);
        assertEquals(productsPage.getNamePage(), "Products",
                "Name of the page doesn't correspond to the expected");

    }

    @Test(priority = 2, invocationCount = 5)
    public void incorrectLogin() {
        loginPage.open();
        loginPage.login("Standard_user", "secret_sauce");

        assertTrue(loginPage.isErrorDisplayed());
        assertEquals(loginPage.getErrorText(),
                "Epic sadface: Username and password do not match any user in this service");
    }

    @Test(priority = 1)
    public void lockedUserLogin() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");

        assertTrue(loginPage.isErrorDisplayed());
        assertEquals(loginPage.getErrorText(),
                "Epic sadface: Sorry, this user has been locked out.");

    }

    @Test(priority = 4)
    public void emptyUserLogin() {
        loginPage.open();
        loginPage.login("", "secret_sauce");

        assertTrue(loginPage.isErrorDisplayed());
        assertEquals(loginPage.getErrorText(),
                "Epic sadface: Username is required");
    }

    @Test(priority = 5)
    public void emptyPasswordLogin() {
        loginPage.open();
        loginPage.login("standard_user", "");


        assertTrue(loginPage.isErrorDisplayed());
        assertEquals(loginPage.getErrorText(),
                "Epic sadface: Password is required");
    }
}

