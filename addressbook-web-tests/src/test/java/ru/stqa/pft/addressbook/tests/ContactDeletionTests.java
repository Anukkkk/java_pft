package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {

        if (app.db().contacts().size() == 0) {
            app.goTo().homePage();
            app.contact().create(new ContactData().withFirstName("test1").withSecondName("test2").withSurname("test3").withGroupIndex(1));
        }
    }

    @Test
    public void testContactDeletion() throws Exception {

        Contacts before = app.db().contacts();;
        ContactData deletedContact = before.iterator().next();
        app.contact().deleteById(deletedContact);
        assertThat(app.contact().count(), equalTo(before.size()-1));
        Contacts after = app.db().contacts();;
        assertThat(after, equalTo(before.without(deletedContact)));
    }


}
