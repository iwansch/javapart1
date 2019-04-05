package com.academy.rozetka;

import com.academy.framework.BaseTest;
import com.academy.rozetka.page.AuthFormPage;
import com.academy.rozetka.page.MainPage;
import com.academy.rozetka.page.UserPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthTests extends BaseTest {

    protected String baseUrl = "https://rozetka.com.ua/ua/";

    @Test
    public void testSuccessAuth() throws InterruptedException {
        System.out.println("***Rozetka test Auth start***");
        driver.get(baseUrl);

        // 1 СПОСОБ
        MainPage mainPage = new MainPage(driver);
        String oldMessage = mainPage.getEnterLinkText();
        AuthFormPage authFormPage = mainPage.clickEnterLink();

        authFormPage.enterLogin("oleg.kh81@gmail.com");
        authFormPage.enterPassword("Qwerty123");
        mainPage = (MainPage)authFormPage.submit(true);

        mainPage = mainPage.waitUntilLinkTextChanged(oldMessage);
        String userName = mainPage.getEnterLinkText();
        Assert.assertEquals(userName, "Oleg");

        /// Разлогиниться и выполнить проверку
        Thread.sleep(2000);

        String olderMessage = mainPage.getEnterLinkText();
        UserPage userPage = mainPage.moveToOutLink();
        mainPage = (MainPage)userPage.signout(true);

       mainPage = mainPage.waitUntilLinkTextChanged(olderMessage);

       String signinButtonName = mainPage.getEnterLinkText();
        //Thread.sleep(5000);
        //Assert.assertEquals(signinButtonName, " увійдіть в особистий кабінет ");
        Assert.assertEquals(signinButtonName, "войдите в личный кабинет");
        Thread.sleep(2000);

        ///

//        // 2 СПОСОБ
//        MainPage mainPage = new MainPage(driver);
//        String oldMessage = mainPage.getEnterLinkText();
//
//        String userName = mainPage
//                .clickEnterLink()
//                .enterLogin("oleg.kh81@gmail.com")
//                .enterPassword("Qwerty123")
//                .submit()
//                .waitUntilLinkTextChanged(oldMessage)
//                .getEnterLinkText();

        //Assert.assertEquals(userName, "Oleg");

    /*    WebElement loginField = driver.findElement(By.id("auth_email"));
        loginField.click();
        loginField.clear();
        loginField.sendKeys("oleg.kh81@gmail.com");
*/
    /*
        WebElement passwordField = driver.findElement(By.id("auth_pass"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("Qwerty123");
*/
        // driver.findElement(By.cssSelector("body > app-root > div > div:nth-child(2) > div.app-rz-common > auth-modal > modal-window > div > div > div > auth-content > div > form > div > button")).click();
        // Подождать, пока не закроется всплывающее окно
        // WebDriverWait webDriverWait = new WebDriverWait(driver, 5);

        //   webDriverWait.until(ExpectedConditions.not(
        //    ExpectedConditions.textToBe(By.cssSelector(linkEnterLocator), oldMessage)));
        // String userName = driver.findElement(By.cssSelector("body > app-root > div > div:nth-child(2) > div.app-rz-header > header > div > div.header-topline > div.header-topline__user.js-rz-auth > div.header-topline__user-wrapper > p > a")).getText().trim();
        // Assert.assertEquals(userName, "Oleg");
    }
}