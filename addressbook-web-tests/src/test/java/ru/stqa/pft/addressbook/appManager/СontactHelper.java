package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class СontactHelper extends HelperBase {

    public СontactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillInContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getSecondName());
        type(By.name("lastname"), contactData.getSurname());
        type(By.name("nickname"), contactData.getNickName());

        if (creation) {
            Select select = new Select(wd.findElement(By.name("new_group")));
            if (select.getOptions().size() > 0 && select.getOptions().size() > contactData.getGroupIndex()) {
                select.selectByIndex(contactData.getGroupIndex());
            } else {
                select.selectByIndex(select.getOptions().size() - 1);
            }
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void modify(List<ContactData> before, int index, ContactData contact) {
        initContactModification(before.get(index).getId());
        fillInContactForm(contact, false);
        submitContactModification();
        goToHomePage();
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void alertClose() throws InterruptedException {
        wd.switchTo().alert().accept();
        Thread.sleep(5000);
    }

    public void initContactModification(int id) {
        wd.findElement(By.xpath(String.format("//a[@href='edit.php?id=%s']", id))).click();
    }

    public void submitContactModification() {
        click(By.xpath("//input[@value='Update']"));
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void create(ContactData contact) {
        initContactCreation();
        fillInContactForm(contact, true);
        goToHomePage();
    }

    public void delete(int index) throws InterruptedException {
        selectContact(index);
        deleteSelectedContacts();
        alertClose();
    }

    public void goToHomePage() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        click(By.linkText("home"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            List<WebElement> cells = element.findElements(By.tagName("td"));
            String firstname = cells.get(2).getText();
            String surname = cells.get(1).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            contacts.add(new ContactData().withId(id).withFirstName(firstname).withSurname(surname));
        }
        return contacts;
    }
}
