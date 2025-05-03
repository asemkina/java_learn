package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactModificationTests extends TestBase {

    @Test
    void canModifyContact() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData("jh", "lknjnj", "ддтж", "ьлщьл", "отоо"));
        }
        app.contacts().ModifyContact(new ContactData().withName("Варвара"));
    }
}