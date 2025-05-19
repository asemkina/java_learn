package tests;

import manager.ApplicationManager;
import model.ContactData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    protected static ApplicationManager app;

    protected static ContactData getContactData(ContactData contact) {
        return new ContactData()
                .withId(contact.id())
                .withFirstName(contact.firstname())
                .withLastName(contact.lastname())
                .withAddress(contact.address())
                .withHomePhone(contact.home())
                .withMobilePhone(contact.mobile())
                .withWorkPhone(contact.work())
                .withPhone2Phone(contact.phone2())
                .withEmail(contact.email())
                .withEmail2(contact.email2())
                .withEmail3(contact.email3());
    }

    @BeforeEach
    public void setUp() throws IOException {
        if (app == null) {
            var properties = new Properties();
            properties.load(new FileReader(System.getProperty("target", "local.properties")));
            app = new ApplicationManager();
            app.init(System.getProperty("browser", "firefox"), properties);
        }
    }

    @AfterEach
void checkDataBaseConsistency(){
        app.jdbc().checkConsistency();
    }
}