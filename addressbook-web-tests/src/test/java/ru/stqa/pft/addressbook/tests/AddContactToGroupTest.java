package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactToGroupTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().homePage();
            app.contact().create(new ContactData().withFirstName("test1")
                    .withSecondName("test2").withSurname("test3"));
        }
        if (app.db().groups().size()==0){
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void AddContactToGroup() {
        app.goTo().homePage();
        Contacts contacts = app.db().contacts();
        Groups groups = app.db().groups();
        GroupData groupAdding = groups.iterator().next();
        ContactData addingContact = contacts.iterator().next();
        Groups before = addingContact.getGroups();
        app.contact().addToGroup(addingContact, groupAdding);
        Groups after = app.db().getContactFromDb(addingContact.getId()).getGroups();
        assertThat(after, equalTo(before.withAdded(groupAdding)));
    }

}
