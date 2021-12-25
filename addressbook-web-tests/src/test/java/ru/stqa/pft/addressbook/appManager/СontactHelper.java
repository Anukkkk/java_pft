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
            if (select.getOptions().size()>0 && select.getOptions().size() > contactData.getGroupIndex()) {
                select.selectByIndex(contactData.getGroupIndex());
            } else {
                select.selectByIndex(select.getOptions().size()-1);
            }
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
        //click(By.xpath("//tr[2]//input"));
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void alertClose() {
        wd.switchTo().alert().accept();
    }

    public void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void submitContactModification() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void createContact(ContactData contact) {
        initContactCreation();
        fillInContactForm(contact, true);
        goToHomePage();
    }

    public void goToHomePage() {
        if (isElementPresent(By.id("maintable"))){
            return;
        }
        click(By.linkText("home"));
    }

    public int getContactCount(){
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
       for (WebElement element : elements){
           List<WebElement> cells = element.findElements(By.tagName("td"));
           String firstname = cells.get(2).getText();
           String surname = cells.get(1).getText();
           int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
           ContactData contactData = new ContactData(id, firstname, surname);
           contacts.add(contactData);
       }
        return contacts;
    }
}
