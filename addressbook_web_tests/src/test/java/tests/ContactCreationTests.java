package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class ContactCreationTests extends TestBase {

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var firstName : List.of("", "Anna")) {
            for (var lastName : List.of("", "Semkina")) {
                for (var address : List.of("", "Bryansk")) {
                    for (var home : List.of("", "9999999999")) {
                        for (var email : List.of("", "sdnf@ksf.ru")) {
                            result.add(new ContactData().FirstName(firstName)
                                    .withLastName(lastName)
                                    .withAddress(address)
                                    .withPhone(home)
                                    .withEmail(email));
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            result.add(new ContactData()
                    .FirstName(randomString(i * 4))
                    .withLastName(randomString(i * 4))
                    .withAddress(randomString(i * 4))
                    .withPhone(randomString(i * 4))
                    .withEmail(randomString(i * 4)));
        }
        return result;
    }

    public static List<ContactData> negativeContactProvider() {
        var result = new ArrayList<ContactData>(List.of(
                new ContactData("", "Anna '", "", "", "", "")));
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void CanCreateMultipleContacts(ContactData contact) {
        int contactCount = app.contacts().getCount();
        app.contacts().createContact(contact);
        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount + 1, newContactCount);
    }

    @ParameterizedTest
    @MethodSource("negativeContactProvider")
    public void CanNotCreateContact(ContactData contact) {
        int contactCount = app.contacts().getCount();
        app.contacts().createContact(contact);
        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount, newContactCount);
    }

}