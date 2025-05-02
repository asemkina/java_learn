import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateСontact() {
        openContactsPage();
        createContact(new ContactData("Анна", "Семкина", "ул.Богдана Хмельницкого, 3-62", "89191990515", "semkina.an@yandex.ru"));
        }

    @Test
    public void canCreateСontactWithFirstNameOnly() {
        openContactsPage();
        createContact(new ContactData().withName("Anna"));
    }

    @Test
    public void canCreateСontactWithLastNameOnly() {
        openContactsPage();
        createContact(new ContactData().withLastName("Semkina"));
    }

    @Test
    public void canCreateСontactWithAddressOnly() {
        openContactsPage();
        createContact(new ContactData().withAddress("Bryansk"));
    }

    @Test
    public void canCreateСontactWithPhoneOnly() {
        openContactsPage();
        createContact(new ContactData().withPhone("9999999999"));
    }

    @Test
    public void canCreateСontactWithEmailOnly() {
        openContactsPage();
        createContact(new ContactData().withEmail("Anna@yandex.ru"));
    }

}