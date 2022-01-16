package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RemoveContactFromGroupTest extends TestBase{
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
    public void DeleteContactFromGroup(){
        app.goTo().homePage();
        ContactData contact = selectContact();
        GroupData groupForDeletion = selectedGroup(contact);
        Groups before = contact.getGroups();
        app.goTo().homePage();
        app.contact().selGroupForDel(groupForDeletion.getId());
        app.contact().removeContactFromGroup(contact, groupForDeletion.getId());
        ContactData contactsAfter = selectContactById(contact);
        Groups after = contactsAfter.getGroups();
        assertThat(after, equalTo(before.without(groupForDeletion)));
    }

    private ContactData selectContactById(ContactData contact) {
        Contacts contactById = app.db().contacts();
        return contactById.iterator().next().withId(contact.getId());
    }

    private GroupData selectedGroup(ContactData contactForDel) {
        ContactData con = app.contact().selectContactById(contactForDel.getId());
        Groups deletedContact = con.getGroups();
        return deletedContact.iterator().next();
    }

    private ContactData selectContact() {
        Contacts contacts = app.db().contacts();
        for (ContactData contact : contacts){
            if (contact.getGroups().size()>0){
                return contact;
            }
        }
        ContactData addContact = app.db().contacts().iterator().next();
        app.contact().addToGroup(addContact, app.db().groups().iterator().next());
        return addContact;
    }


}
