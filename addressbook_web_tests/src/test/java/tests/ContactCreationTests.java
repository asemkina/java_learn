package tests;

import common.CommonFunctions;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var firstName : List.of("", "Anna")) {
            for (var lastName : List.of("", "Semkina")) {
                for (var address : List.of("", "Bryansk")) {
                    for (var home : List.of("", "9999999999")) {
                        for (var email : List.of("", "sdnf@ksf.ru")) {
                            result.add(new ContactData().withFirstName(firstName)
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
                    .withFirstName(CommonFunctions.randomString(i * 4))
                    .withLastName(CommonFunctions.randomString(i * 4))
                    .withAddress(CommonFunctions.randomString(i * 4))
                    .withPhone(CommonFunctions.randomString(i * 4))
                    .withEmail(CommonFunctions.randomString(i * 4)));
        }
        return result;
    }

    public static List<ContactData> negativeContactProvider() {
        var result = new ArrayList<ContactData>(List.of(
                new ContactData("", "Anna '", "", "", "", "", "")));
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void CanCreateMultipleContacts(ContactData contact) {
        var oldContacts = app.contacts().getListContact();
        app.contacts().createContact(contact);
        var newContacts = app.contacts().getListContact();
        Comparator<ContactData> compareById = (Comparator<ContactData>) (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(contact.withId(newContacts.get(newContacts.size()-1).id()).withFirstName("").withLastName("").withAddress("").withPhone("").withEmail(""));
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);
    }

    @ParameterizedTest
    @MethodSource("negativeContactProvider")
    public void CanNotCreateContact(ContactData contact) {
        var oldContacts = app.contacts().getListContact();
        app.contacts().createContact(contact);
        var newContacts = app.contacts().getListContact();
        Assertions.assertEquals(newContacts, oldContacts);
    }

    @Test
    void canCreateContactWithPhoto(){
        var contact = new ContactData()
                .withFirstName(CommonFunctions.randomString(5))
                .withLastName(CommonFunctions.randomString(10))
                .withPhoto(randomFile("src/test/resources/images"));
        app.contacts().createContact(contact);
    }

}