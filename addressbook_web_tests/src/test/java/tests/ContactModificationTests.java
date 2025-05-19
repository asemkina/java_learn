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
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
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
//        var contact = app.hbm().getContactList().get(0);
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().CreateGroup(new GroupData("", "Group1", "Group name", "Group footer"));
        }
        var group = app.hbm().getGroupList().get(0);
        var oldRelated = app.hbm().getContactInGroup(group);
//        var rnd = new Random();
//        var index = rnd.nextInt(oldRelated.size());
//        var contact = app.hbm().getContactList().get(index);
//        var testData = new ContactData().withFirstName(CommonFunctions.randomString(7)).withLastName(CommonFunctions.randomString(10));
//        app.contacts().ModifyContact(oldContacts.get(index), testData);
        var contact = app.hbm().getContactList().get(0);
        app.contacts().addContactInGroup(contact, group);
        var newRelated = app.hbm().getContactInGroup(group);
//        Comparator<ContactData> compareById = (o1, o2) -> {
//            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
//        };
//        newRelated.sort(compareById);
//        var expectedList = new ArrayList<>(oldRelated);
//        var testData = new ContactData();
//        expectedList.set(0, testData.withId(getCo.get(contact.id());
        //expectedList.set(index, testData.withId(oldRelated.get(0).id()));
//        expectedList.sort(compareById);
        Assertions.assertEquals(oldRelated.size()+1, newRelated.size());
    }
}