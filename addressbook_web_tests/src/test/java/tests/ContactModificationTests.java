package tests;

import common.CommonFunctions;
import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Stream;

public class ContactModificationTests extends TestBase {

    @Test
    void canModifyContact() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("", "Name", "Lastname", "Address", "Phone", "Email", "", "", "", "", "", ""));
            app.contacts().returnToHomePage();
        }
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        var testData = new ContactData().withFirstName(CommonFunctions.randomString(7)).withLastName(CommonFunctions.randomString(10));
        app.contacts().ModifyContact(oldContacts.get(index), testData);
        var newContacts = app.hbm().getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.set(index, testData.withId(oldContacts.get(index).id()));
        Comparator<ContactData> compareById = getContactDataComparator();
        newContacts.sort(compareById);
        expectedList.sort((compareById));
        Assertions.assertEquals(expectedList, newContacts);
    }

    @Test
    void canAddContactInGroup() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("", "Name", "Lastname", "Address", "Phone", "Email", "", "", "", "", "", ""));
            app.contacts().returnToHomePage();
        }
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().CreateGroup(new GroupData("", "Group1", "Group name", "Group footer"));
            app.contacts().returnToHomePage();
        }
        var rndGroup = new Random();
        var indexGroup = rndGroup.nextInt(app.hbm().getGroupList().size());
        var group = app.hbm().getGroupList().get(indexGroup);

        var oldRelated = app.hbm().getContactInGroup(group);
        var contactList = app.hbm().getContactList();
        var contactToAdd = contactList.stream()
                .filter(contact -> !oldRelated.contains(contact))
                .findFirst();
        if (contactToAdd.isPresent()) {
            var contact = contactToAdd.get();
            app.contacts().addContactInGroup(contact, group);
            var newRelated = app.hbm().getContactInGroup(group);
            Comparator<ContactData> compareById = getContactDataComparator();
            newRelated.sort(compareById);
            var expectedList = new ArrayList<>(oldRelated);
            expectedList.add(getContactData(contact));
            expectedList.sort(compareById);
            Assertions.assertEquals(expectedList, newRelated);
        } else {
            System.out.println(String.format("Все контакты уже состоят в группе id = %s, создаем новый контакт", group.id()));
            var newContact = new ContactData()
                    .withFirstName(CommonFunctions.randomString(5))
                    .withLastName(CommonFunctions.randomString(5));
            app.contacts().createContact(newContact);
            var contactLists = app.hbm().getContactList();
            var contactToAd = contactLists.stream()
                    .filter(contact -> !oldRelated.contains(contact))
                    .findFirst();
            if (contactToAd.isPresent()) {
                var contact = contactToAd.get();
                app.contacts().addContactInGroup(contact, group);
                var newRelated = app.hbm().getContactInGroup(group);
                Comparator<ContactData> compareById = getContactDataComparator();
                newRelated.sort(compareById);
                var expectedList = new ArrayList<>(oldRelated);
                expectedList.add(getContactData(contact));
                expectedList.sort(compareById);
                Assertions.assertEquals(expectedList, newRelated);
            }
        }
    }
}

