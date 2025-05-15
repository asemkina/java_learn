package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactInfoTests extends TestBase {
    @Test
    void testPhones() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("", "Name", "Lastname", "Address", "99999999", "Email", "", "88919199", "", "", "", ""));
            app.contacts().returnToHomePage();
        }
        var contacts = app.hbm().getContactList();
        var expected = contacts.stream().collect(Collectors.toMap(ContactData::id, contact ->
                Stream.of(contact.home(), contact.mobile(), contact.work(), contact.phone2()) /// забираем все телефоны из контакта
                        .filter(s -> s != null && !s.isEmpty()) /// пропускаем пустые номера: строка не null и не пустая строка
                        .collect(Collectors.joining("\n")) ///склеиваем строки, разделитель - перенос строки
        ));
        var phones = app.contacts().getPhones();
        Assertions.assertEquals(expected, phones);
    }

    @Test
    void testContactsInfo() {
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData("", "Name", "Lastname", "Address", "99999999", "Email", "", "88888888", "77777777", "", "Email2", "Email3"));
        }
        var contacts = app.hbm().getContactList();
        var contact = contacts.get(0);
        var phones = app.contacts().getPhones(contact);
        var address = app.contacts().getAddress(contact);
        var emails = app.contacts().getEmails(contact);
        var expectedPhones = Stream.of(contact.home(), contact.mobile(), contact.work(), contact.phone2()) /// забираем все телефоны из контакта
                .filter(s -> s != null && !s.isEmpty()) /// пропускаем пустые номера: строка не null и не пустая строка
                .collect(Collectors.joining("\n")); ///склеиваем строки, разделитель - перенос строки
        var expectedAddress = Stream.of(contact.address()) /// забираем адрес из контакта
                .collect(Collectors.joining());
        var expectedEmails = Stream.of(contact.email(), contact.email2(), contact.email3()) /// забираем все email из контакта
                .filter(s -> s != null && !s.isEmpty()) /// пропускаем пустые номера: строка не null и не пустая строка
                .collect(Collectors.joining("\n")); ///склеиваем строки, разделитель - перенос строки
        Assertions.assertEquals(expectedPhones, phones);
        Assertions.assertEquals(expectedAddress, address);
        Assertions.assertEquals(expectedEmails, emails);
    }
}
