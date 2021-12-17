package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

    @Test
    public void testCreatingContact() throws Exception {
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().createContact(new ContactData("Ann", "Sergeevna", "Porotikova", "ann", "[none]"));
    }

}
