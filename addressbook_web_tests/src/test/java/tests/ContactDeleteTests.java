package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class ContactDeleteTests extends TestBase {

    @Test
    public void deleteRandomContact() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().СreateContact(new ContactData("", "Имя", "Фамилия", "Адрес", "8888888888", "Email", ""));
        }
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contacts().removeContact(oldContacts.get(index));
        var newContacts = app.hbm().getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts, expectedList);
    }

    @Test
    public void deleteAllContacts() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().СreateContact(new ContactData("", "jh", "lknjnj", "ддтж", "ьлщьл", "отоо", ""));
        }
        app.contacts().removeAllContacts();
    }
}