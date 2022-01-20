package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Collection;
import java.util.HashSet;

import static org.hamcrest.core.IsEqual.equalTo;

public class AddContactToGroupTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().homePage();
            app.contact().create(new ContactData().withFirstName("test1")
                    .withSecondName("test2").withSurname("test3"));
        }
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void AddContactToGroup() {
        app.goTo().homePage();
        ContactData contact = selectedContact();
        Groups before = contact.getGroups();
        GroupData groupForAdd = selectedGroup(contact);
        app.contact().addToGroup(contact, groupForAdd);
        Groups after = app.db().getContactFromDb(contact.getId()).getGroups();
        equalTo(before.withAdded(groupForAdd));
    }

    public GroupData selectedGroup(ContactData contact) {
        Groups all = app.db().groups();
        Collection<GroupData> freeGroups = new HashSet<GroupData>(all);
        freeGroups.removeAll(contact.getGroups());
        return freeGroups.iterator().next();
    }

    public ContactData selectedContact() {
        Contacts contacts = app.db().contacts();
        Groups groups = app.db().groups();
        for (ContactData contact : contacts) {
            if (contact.getGroups().size() < groups.size()) {
                return contact;
            }
        }
        app.goTo().groupPage();
        app.group().create(new GroupData().withName("test1"));
        app.goTo().homePage();
        return contacts.iterator().next();
    }


}
