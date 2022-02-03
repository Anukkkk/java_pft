package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ResetPasswordTests extends TestBase {

    @BeforeMethod
    public void startMailSever() {
        app.mail().start();
    }

    @Test
    public void testResetPasswd() {
        app.registration().login(app.getProperty("web.adminLogin"), app.getProperty("web.adminPassword"));
        app.registration().manage();
    }

    @AfterMethod
    public void stopMail() {
        app.mail().stop();
    }
}
