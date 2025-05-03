package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactDeleteTests extends TestBase {

    @Test
    public void delete() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData("jh", "lknjnj", "ддтж", "ьлщьл", "отоо"));
        }
        app.contacts().removeContact();
    }
}