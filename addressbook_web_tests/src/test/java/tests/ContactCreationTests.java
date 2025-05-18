package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import common.CommonFunctions;
import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    public static List<ContactData> contactProvider() throws IOException {
        var result = new ArrayList<ContactData>();
        //ObjectMapper mapper = new ObjectMapper();
        var mapper = new XmlMapper();
        var value = mapper.readValue(new File("contacts.xml"), new TypeReference<List<ContactData>>() {
        });
        result.addAll(value);
        return result;
    }

    public static List<ContactData> negativeContactProvider() {
        var result = new ArrayList<ContactData>(List.of(
                new ContactData("", "Anna '", "", "", "", "", "", "", "", "", "", "")));
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void CanCreateMultipleContacts(ContactData contact) {
        var oldContacts = app.hbm().getContactList();
        app.contacts().createContact(contact);
        var newContacts = app.hbm().getContactList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(contact.withId(newContacts.get(newContacts.size() - 1).id()));
        expectedList.sort(compareById);
        Assertions.assertEquals(expectedList, newContacts);
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
    void canCreateContactWithPhoto() {
        var contact = new ContactData()
                .withFirstName(CommonFunctions.randomString(5))
                .withLastName(CommonFunctions.randomString(10))
                .withPhoto(CommonFunctions.randomFile("src/test/resources/images"));
        app.contacts().createContact(contact);
    }

    @Test
    void canCreateContactInGroup() {
        var contact = new ContactData()
                .withFirstName(CommonFunctions.randomString(5))
                .withLastName(CommonFunctions.randomString(10))
                .withPhoto(CommonFunctions.randomFile("src/test/resources/images"));
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().CreateGroup(new GroupData("", "Group1", "Group name", "Group footer"));
        }
        var group = app.hbm().getGroupList().get(0);

        var oldRelated = app.hbm().getContactInGroup(group);
        app.contacts().createContactInGroup(contact, group);
        var newRelated = app.hbm().getContactInGroup(group);
        Assertions.assertEquals(oldRelated.size() + 1, newRelated.size());
    }


    public static List<ContactData> contactProviderList() {
        var result = new ArrayList<ContactData>();
        for (var firstName : List.of("", "Anna")) {
            for (var lastName : List.of("", "Semkina")) {
                for (var address : List.of("", "Bryansk")) {
                    for (var home : List.of("", "9999999999")) {
                        for (var email : List.of("", "sdnf@ksf.ru")) {
                            result.add(new ContactData()
                                    .withFirstName(firstName)
                                    .withLastName(lastName)
                                    .withAddress(address)
                                    .withHomePhone(home)
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
                    .withHomePhone(CommonFunctions.randomString(i * 4))
                    .withEmail(CommonFunctions.randomString(i * 4)));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProviderList")
    public void CanCreateMultipleContactsList(ContactData contact) {
        var oldContacts = app.hbm().getContactList();
        app.contacts().createContact(contact);
        var newContacts = app.hbm().getContactList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        var maxId = (newContacts.get(newContacts.size() - 1).id());
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(contact.withId(maxId));
        expectedList.sort(compareById);
        Assertions.assertEquals(expectedList, newContacts);
    }
}