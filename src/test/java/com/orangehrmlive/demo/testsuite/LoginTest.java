package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {

    AddUserPage addUserPage;
    AdminPage adminPage;
    DashboardPage dashboardPage;
    HomePage homePage;
    LoginPage loginPage;
    ViewSystemUsersPage viewSystemUsersPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        AddUserPage addUserPage;
        AdminPage adminPage;
        DashboardPage dashboardPage;
        HomePage homePage;
        LoginPage loginPage;
        ViewSystemUsersPage viewSystemUsersPage;
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldLoginSuccessFully() {
        homePage.setEnterUserName("Admin");
        homePage.setEnterPassword("admin123");
        //   Click on Login Button
        loginPage.setClickOnLogin();
        //   Verify "Dashboard" Message
        String actualMessage = dashboardPage.getVerifyTheTextDashboard();
        String expectedMessage = "WelCome";
        Assert.assertEquals(actualMessage,expectedMessage,"WelCome Text is displayed");

    }

    @Test(groups = {"Smoke", "Regression"})
    public void verifyThatTheLogoDisplayOnHomePage() {
        //Launch the application
        driver.getCurrentUrl();
        //   Verify Logo is Displayed
        homePage.setHrmLogo();


    }

    @Test(groups = {"Regression"})
    public void verifyUserShouldLogOutSuccessFully() throws InterruptedException {
        //Login To The application
        homePage.setEnterUserName("Admin");
        homePage.setEnterPassword("admin123");
        loginPage.setClickOnLogin();
        //   Click on User Profile logo
        adminPage.setClickOnUserProfileLogo();
        //   Mouse hover on "Logout" and click
        adminPage.setMouseHoverOnLogout();
        //   Verify the text "Login Panel" is displayed
        Thread.sleep(2000);
        String actualMessage = homePage.setVerifyLoginPanel();
        String expectedMessage = "Login";
        Assert.assertEquals(actualMessage,expectedMessage,"login message is not displayed");


    }

    @Test(groups = {"Regression"})
    public void verifyErrorMessageWithInvalidCredentials() {
//Enter username
        homePage.setEnterUserName("promo123@yahoo.com");
        //   Enter password
        homePage.setEnterPassword("promo");
        //   Click on Login Button
        loginPage.setClickOnLogin();
        //   Verify "Dashboard" Message
        String actualMessage = dashboardPage.getVerifyTheTextDashboard();
        String expectedMessage ="Welcome  Text is not displayed";
        Assert.assertEquals(actualMessage,expectedMessage,"Welcome  Text is not displayed");

    }
}
