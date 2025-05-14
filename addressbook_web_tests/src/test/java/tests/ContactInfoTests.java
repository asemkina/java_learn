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
            app.hbm().сreateContact(new ContactData("", "Name", "Lastname", "Address", "99999999", "Email", "", "88919199", "", ""));
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
}
