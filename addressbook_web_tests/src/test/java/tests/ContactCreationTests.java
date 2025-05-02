import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateСontact() {
        app.openContactsPage();
        app.createContact(new ContactData("Анна", "Семкина", "ул.Богдана Хмельницкого, 3-62", "89191990515", "semkina.an@yandex.ru"));
        }

    @Test
    public void canCreateСontactWithFirstNameOnly() {
        app.openContactsPage();
        app.createContact(new ContactData().withName("Anna"));
    }

    @Test
    public void canCreateСontactWithLastNameOnly() {
        app.openContactsPage();
        app.createContact(new ContactData().withLastName("Semkina"));
    }

    @Test
    public void canCreateСontactWithAddressOnly() {
        app.openContactsPage();
        app.createContact(new ContactData().withAddress("Bryansk"));
    }

    @Test
    public void canCreateСontactWithPhoneOnly() {
        app.openContactsPage();
        app.createContact(new ContactData().withPhone("9999999999"));
    }

    @Test
    public void canCreateСontactWithEmailOnly() {
        app.openContactsPage();
        app.createContact(new ContactData().withEmail("Anna@yandex.ru"));
    }

}