package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactModificationTests extends TestBase{
    @Test
    public void testContactModification (){
        app.getNavigationHelper().goToHomePage();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("test1", null, null, "ann", 1));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillInContactForm(new ContactData("test1", "test2", "test3", "test4", 1), false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();

        Assert.assertEquals(after.size(), before.size());

        //before.remove(before.size()-1);
       // Assert.assertEquals(before, after);
    }

}
