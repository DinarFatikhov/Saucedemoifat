import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest {
    //1. открыть нужный браузер
    //2. зайти на сайт saucedemo.com

    @Test
    public void login(){
        WebDriver browser  = new ChromeDriver();
        browser.get("https://www.saucedemo.com/");
        browser.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user");
        browser.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce");
        browser.findElement(By.xpath("//*[@value='Login']")).click();
        assertTrue(browser.findElement(By.xpath("//span[@data-test='title']")).isDisplayed());
        assertEquals(browser.findElement(By.xpath("//span[@data-test='title']")).getText(),
                "Products");
        //browser.quit();
    }

    @Test
    public void incorrectLogin(){
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.saucedemo.com/");
        browser.findElement(By.xpath("//*[@id='user-name']")).sendKeys("Standard_user");
        browser.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce");
        browser.findElement(By.xpath("//*[@value='Login']")).click();
        boolean isErrorDisplayed = browser.findElement(By.xpath("//button[@data-test='error-button']")).isDisplayed();
        assertTrue(isErrorDisplayed);

    }
}

