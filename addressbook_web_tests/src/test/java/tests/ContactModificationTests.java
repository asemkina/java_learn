package tests;

import common.CommonFunctions;
import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

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
        var rndContact = new Random();
        var indexContact = rndContact.nextInt(app.hbm().getContactList().size());
        var rndGroup = new Random();
        var indexGroup = rndGroup.nextInt(app.hbm().getGroupList().size());
        var group = app.hbm().getGroupList().get(indexGroup);
        var contact = app.hbm().getContactList().get(indexContact);
        var oldRelated = app.hbm().getContactInGroup(group);
        if (oldRelated.contains(contact)) {
            System.out.println(String.format("Контакт id = %s уже есть в группе id = %s", contact.id(), group.id()));
        } else {
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
