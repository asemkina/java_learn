package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateСontact() {
        int contactCount = app.contacts().getCount();
        app.contacts().createContact(new ContactData("Анна", "Семкина", "ул.Богдана Хмельницкого, 3-62", "89191990515", "semkina.an@yandex.ru"));
        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount + 1, newContactCount);
        }

    @Test
    public void canCreateСontactWithFirstNameOnly() {
        app.contacts().createContact(new ContactData().withName("Anna"));
    }

    @Test
    public void canCreateСontactWithLastNameOnly() {
        app.contacts().createContact(new ContactData().withLastName("Semkina"));
    }

    @Test
    public void canCreateСontactWithAddressOnly() {
        app.contacts().createContact(new ContactData().withAddress("Bryansk"));
    }

    @Test
    public void canCreateСontactWithPhoneOnly() {
        app.contacts().createContact(new ContactData().withPhone("9999999999"));
    }

    @Test
    public void canCreateСontactWithEmailOnly() {
        app.contacts().createContact(new ContactData().withEmail("Anna@yandex.ru"));
    }

}