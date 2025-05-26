package tests;

import common.CommonFunctions;
import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ContactDeleteTests extends TestBase {

    @Test
    public void deleteRandomContact() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("", "Name", "Lastname", "address", "8888888888", "Email", "", "", "", "", "", ""));
            app.contacts().returnToHomePage();
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
            app.hbm().createContact(new ContactData("", "Ann", "Semkina", "Bryansk", "88888", "fjhfhghg", "", "", "", "", "", ""));
        }
        app.contacts().removeAllContacts();
    }

    @Test
    void canRemoveContactInGroup() {
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().CreateGroup(new GroupData("", "Group1", "Group name", "Group footer"));
            app.contacts().returnToHomePage();
        }
        var rndGroup = new Random();
        var indexGroup = rndGroup.nextInt(app.hbm().getGroupList().size());
        var group = app.hbm().getGroupList().get(indexGroup);
        var oldRelated = app.hbm().getContactInGroup(group);
        if (oldRelated.isEmpty()) {
            var client = new ContactData()
                    .withFirstName(CommonFunctions.randomString(5))
                    .withLastName(CommonFunctions.randomString(10))
                    .withAddress(CommonFunctions.randomString(15));
            app.contacts().createContactInGroup(client, group);
            var rndContact = new Random();
            var indexContact = rndContact.nextInt(app.hbm().getContactInGroup(group).size());
            var contact = app.hbm().getContactInGroup(group).get(indexContact);
            app.contacts().removeContactInGroup(contact, group);
            var newRelated = app.hbm().getContactInGroup(group);
            var expectedList = new ArrayList<>(oldRelated);
            Assertions.assertEquals(expectedList, newRelated);
        } else {
            var rndContact = new Random();
            var indexContact = rndContact.nextInt(app.hbm().getContactInGroup(group).size());
            var contact = app.hbm().getContactInGroup(group).get(indexContact);
            app.contacts().removeContactInGroup(contact, group);
            var newRelated = app.hbm().getContactInGroup(group);
            Comparator<ContactData> compareById = getContactDataComparator();
            newRelated.sort(compareById);
            var expectedList = new ArrayList<>(oldRelated);
            expectedList.remove(indexContact);
            expectedList.sort(compareById);
            Assertions.assertEquals(expectedList, newRelated);
        }
    }
}