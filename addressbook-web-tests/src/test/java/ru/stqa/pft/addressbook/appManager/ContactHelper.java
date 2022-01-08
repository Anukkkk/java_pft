package ru.stqa.pft.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillInContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getSecondName());
        type(By.name("lastname"), contactData.getSurname());
        type(By.name("nickname"), contactData.getNickName());
        attach(By.name("photo"), contactData.getPhoto());

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

    public void modify(ContactData contact) {
        selectContactById(contact.getId());
        initContactModification(contact.getId());
        fillInContactForm(contact, false);
        submitContactModification();
        contactCashe = null;
        goToHomePage();
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void selectContactById(int id) {
        wd.findElement(By.xpath("//input[@value='" + id + "']")).click();
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
        contactCashe = null;
        goToHomePage();
    }


    public void deleteById(ContactData contact) throws InterruptedException {
        selectContactById(contact.getId());
        deleteSelectedContacts();
        alertClose();
        contactCashe = null;
    }

    public void goToHomePage() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        click(By.linkText("home"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    private Contacts contactCashe = null;

    public Contacts all() {
        if (contactCashe != null) {
            return new Contacts(contactCashe);
        }
        contactCashe = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            List<WebElement> cells = element.findElements(By.tagName("td"));
            String firstname = cells.get(2).getText();
            String surname = cells.get(1).getText();
            String postAddress = cells.get(3).getText();
            String allPhones = cells.get(5).getText();
            String allEmails = cells.get(4).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            contactCashe.add(new ContactData().withId(id).withFirstName(firstname).withSurname(surname)
                    .withAllPhones(allPhones).withAllEmails(allEmails).withPostAddress(postAddress));
        }
        return contactCashe;
    }

 /**   private String[] getPhones(String[] phones) {
        String[] result = new String[3];

        System.arraycopy(phones, 0, result, 0, phones.length);
        if (phones.length < result.length) {
            for (int i = phones.length - 1; i < result.length; i++) {
                result[i] = "";
            }
        }
        return result;
    }**/

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String phone2 = wd.findElement(By.name("phone2")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        String postAddress = wd.findElement(By.name("address")).getAttribute("value");

        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstName(firstname).withSurname(lastname)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withPhone2(phone2).withEmail(email).withEmail2(email2)
                .withEmail3(email3).withPostAddress(postAddress);
    }

    private void initContactModificationById(int id) {
        WebElement checkbox = wd.findElement(By.id(String.format("%d", id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();
    }
}
