package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

    @Test
    public void testCreatingContact() throws Exception {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        File photo = new File("src/test/resources/126.png");
        ContactData contact = new ContactData().withFirstName("Ann").withSurname("Porotikova10").withGroupIndex(10).withPhoto(photo);
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((o) -> o.getId()).max().getAsInt()))));
    }

    public void testBadCreatingContact() throws Exception {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withFirstName("Ann'").withSurname("Porotikova10").withGroupIndex(10);
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before));
    }

    @Test(enabled = false)
    public void testCurrentDir() {
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/126.png");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }
}
