package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public WebDriver wd;
    private contactHelper contactHelper;
    private SessionHelper sessionHelper;
    private NavigationBaseHelper navigationHelper;
    private GroupBaseHelper groupHelper;

    public void init() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("http://localhost:3307/addressbook/addressbook/");
        contactHelper = new contactHelper(wd);
        groupHelper = new GroupBaseHelper(wd);
        navigationHelper = new NavigationBaseHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        wd.quit();
    }

    public void logout() {
        wd.findElement(By.linkText("Logout")).click();
    }

    public void goToHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    public GroupBaseHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationBaseHelper getNavigationHelper() {
        return navigationHelper;
    }

    public ru.stqa.pft.addressbook.appManager.contactHelper getContactHelper() {
        return contactHelper;
    }
}
