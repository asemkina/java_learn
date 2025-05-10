package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class ContactDeleteTests extends TestBase {

    @Test
    public void delete() {
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData("", "Имя", "Фамилия", "Адрес", "8888888888", "Email"));
        }
        var oldContacts = app.contacts().getListContact();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contacts().removeContact(oldContacts.get(index));
        var newContacts = app.contacts().getListContact();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts, expectedList);
    }

    @Test
    public void deleteAllContacts() {
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData("", "jh", "lknjnj", "ддтж", "ьлщьл", "отоо"));
        }
        app.contacts().removeAllContacts();
    }
}