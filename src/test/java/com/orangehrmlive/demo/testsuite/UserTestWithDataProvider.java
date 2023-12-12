package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTestWithDataProvider extends BaseTest {

    AddUserPage addUserPage;
    AdminPage adminPage;
    DashboardPage dashboardPage;
    HomePage homePage;
    LoginPage loginPage;
    ViewSystemUsersPage viewSystemUserPage;


    @Test(dataProvider = "data set" , dataProviderClass = Test.class)
    public void searchTheDeletedUserAndVerifyTheMessageRecordFound(String userName ,String userRole ,String employeeName, String status)
    {
        //Login to Application
        homePage.setEnterUserName("Admin");
        homePage.setEnterPassword("admin123");
        loginPage.setClickOnLogin();
        //	click On "Admin" Tab
        adminPage.setClickOnAdmin();
        //	Verify "System Users" Text
        String actualText = viewSystemUserPage.setVerifyTextSystemUser();
        String expectedText = "System Users";
        Assert.assertEquals(actualText, expectedText, "System User is not displayed");
        //	Enter Username
        viewSystemUserPage.setEnterUsername(userName);
        //	Select User Role
        addUserPage.setSelectAdmin();
        //	Select Status
        addUserPage.setSelectStatus();
        addUserPage.setSelectDisable();
        //	Click on "Search" Button
        viewSystemUserPage.setEnterSearch();
        //	verify message "Records Found"
    }
}
