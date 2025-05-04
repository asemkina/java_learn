package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ContactCreationTests extends TestBase {

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var firstName : List.of("", "Anna")) {
            for (var lastName : List.of("", "Semkina")) {
                for (var address : List.of("", "Bryansk")) {
                    for (var home : List.of("", "9999999999")) {
                        for (var email : List.of("", "sdnf@ksf.ru")) {
                            result.add(new ContactData(firstName, lastName, address, home, email));
                        }
                    }
                }
            }
        }
        for (int i=0; i<5; i++) { ///переменная i является счетчиком, на каждой итерации к i прибавляется 1(инкремент)
            result.add(new ContactData(randomString(i * 4), randomString(i * 4), randomString(i * 4), randomString(i * 4), randomString(i * 4)));
        }
        return result;
    }

    @ParameterizedTest
    @ValueSource(strings = {"Anna", "Anna '"})
    public void canCreateСontact(String firstName) {
        int contactCount = app.contacts().getCount();
        app.contacts().createContact(new ContactData(firstName, "Семкина", "ул.Богдана Хмельницкого, 3-62", "89191990515", "semkina.an@yandex.ru"));
        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount + 1, newContactCount);
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void CanCreateMultipleContacts(ContactData contact) {
        int contactCount = app.contacts().getCount();
        app.contacts().createContact(contact);
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