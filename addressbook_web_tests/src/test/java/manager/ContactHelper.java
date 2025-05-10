package manager;

import model.ContactData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase{

    public ContactHelper (ApplicationManager manager){
        super(manager);
    }

    public void createContact(ContactData contact) {
        openContactsPage();
        click(By.linkText("add new"));
        fillContactForm(contact);
        click(By.xpath("(//input[@name=\'submit\'])[2]"));
        returnToHomePage();
    }

    public void removeContact(ContactData contact) {
        selectContact(contact);
        click(By.xpath("//input[@value=\'Delete\']"));
        returnToHomePage();
        ///homePageRemoveContact();
    }


    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));
    }

    public void ModifyContact(ContactData ModifiedContact) {
        initModifyContact();
        fillContactForm(ModifiedContact);
        submitContactModification();
        returnToHomePage();
    }

    public void openContactsPage() {
        if (!manager.isElementPresent(By.xpath("(//input[@name=\'submit\'])[2]"))) {
            click(By.linkText("add new"));
        }
    }

    public void returnToHomePage() {
        click(By.linkText("home"));
    }

    private void submitContactModification() {
        click(By.name("update"));
    }

    private void fillContactForm(ContactData contact) {
        click(By.name("firstname"));
        type(By.name("firstname"),contact.firstname());
        click(By.name("lastname"));
        type(By.name("lastname"),contact.lastname());
        click(By.name("address"));
        type(By.name("address"),contact.address());
        click(By.name("home"));
        type(By.name("home"),contact.home());
        click(By.name("email"));
        type(By.name("email"),contact.email());
        attach(By.name("photo"),contact.photo());
    }

    private void initModifyContact() {
        click(By.xpath("//img[@alt=\'Edit\']"));
    }

    public int getCount() {
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public void removeAllContacts() {
        selectAllContacts();
        click(By.xpath("//input[@value=\'Delete\']"));
    }

    private void selectAllContacts() {
        click(By.id("MassCB"));
    }

    public List<ContactData> getListContact() {
        var contacts = new ArrayList<ContactData>();
        var trs = manager.driver.findElements(By.name("entry"));
        for (var tr : trs){
            ///var firstName = tr.getText();
            var checkbox = tr.findElement(By.name("selected[]"));
            var id = checkbox.getDomAttribute("value");
            contacts.add(new ContactData().withId(id).withFirstName("").withLastName("").withAddress("").withPhone("").withEmail(""));//.withFirstName(firstName));
        }
        return contacts;
    }
}
