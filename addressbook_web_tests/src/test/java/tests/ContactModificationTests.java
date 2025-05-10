package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class ContactModificationTests extends TestBase {

    @Test
    void canModifyContact() {
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData("", "Name", "Lastname", "Address", "Phone", "Email", ""));
        }
        var oldContacts = app.contacts().getListContact();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        var testData = new ContactData().withFirstName("Татьяна");
        app.contacts().ModifyContact(testData);
        var newContacts = app.contacts().getListContact();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.set(index,testData.withId(oldContacts.get(index).id()).withFirstName(""));
        Assertions.assertEquals(newContacts, expectedList);
    }
}