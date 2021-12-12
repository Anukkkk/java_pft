package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

    @Test
    public void testCreatingContact() throws Exception {
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillInContactForm(new ContactData("Ann", "Sergeevna", "Porotikova", "ann", "test1"), true);
        app.goToHomePage();
    }

}
