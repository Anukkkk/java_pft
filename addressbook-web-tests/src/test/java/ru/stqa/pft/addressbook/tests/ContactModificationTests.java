package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{
    @Test
    public void testContactModification (){
        app.getNavigationHelper().goToHomePage();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("test1", null, null, "ann", "test1"));
        }
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillInContactForm(new ContactData("test1", "test2", "test3", "test4", null), false);
        app.getContactHelper().submitContactModification();
    }

}
