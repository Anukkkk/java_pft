package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class AddingNewContact extends TestBase {

    @Test
    public void testAddingNewContact() throws Exception {
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillInContactForm(new ContactData("Ann", "Sergeevna", "Porotikova", "ann"));
        app.goToHomePage();
    }

}
