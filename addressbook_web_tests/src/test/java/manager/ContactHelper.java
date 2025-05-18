package manager;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(ContactData contact) {
        openContactsPage();
        click(By.linkText("add new"));
        fillContactFormWithoutPhoto(contact);
        click(By.xpath("(//input[@name=\'submit\'])[2]"));
        returnToHomePage();
    }

    public void createContactInGroup(ContactData contact, GroupData group) {
        openContactsPage();
        click(By.linkText("add new"));
        fillContactFormWithPhoto(contact);
        selectGroup(group);
        click(By.xpath("(//input[@name=\'submit\'])[2]"));
        returnToHomePage();
    }

    private void selectGroup(GroupData group) {
        new Select(manager.driver.findElement(By.name("new_group"))).selectByValue(group.id());
    }

    public void removeContact(ContactData contact) {
        selectContact(contact);
        click(By.xpath("//input[@value=\'Delete\']"));
        returnToHomePage();
    }


    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));
    }

    public void ModifyContact(ContactData contact, ContactData ModifiedContact) {
        initModifyContact(contact);
        fillContactFormWithoutPhoto(ModifiedContact);
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

    private void fillContactFormWithoutPhoto(ContactData contact) {
        click(By.name("firstname"));
        type(By.name("firstname"), contact.firstname());
        click(By.name("lastname"));
        type(By.name("lastname"), contact.lastname());
        click(By.name("address"));
        type(By.name("address"), contact.address());
        click(By.name("home"));
        type(By.name("home"), contact.home());
        click(By.name("email"));
        type(By.name("email"), contact.email());
        click(By.name("mobile"));
        type(By.name("mobile"), contact.mobile());
        click(By.name("work"));
        type(By.name("work"), contact.work());
        click(By.name("email2"));
        type(By.name("email2"), contact.email2());
        click(By.name("email3"));
        type(By.name("email3"), contact.email3());
    }

    private void fillContactFormWithPhoto(ContactData contact) {
        click(By.name("firstname"));
        type(By.name("firstname"), contact.firstname());
        click(By.name("lastname"));
        type(By.name("lastname"), contact.lastname());
        click(By.name("address"));
        type(By.name("address"), contact.address());
        click(By.name("home"));
        type(By.name("home"), contact.home());
        click(By.name("email"));
        type(By.name("email"), contact.email());
        attach(By.name("photo"), contact.photo());
    }

    private void initModifyContact(ContactData contact) {
        click(By.cssSelector(String.format("a[href^='edit.php?id=%s']", contact.id())));
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
        var trs = manager.driver.findElements(By.cssSelector("[name=entry]"));
        for (var tr : trs) {
            var name1 = tr.findElement(By.cssSelector("td:nth-child(2)"));
            var lastname = name1.getText();
            var name2 = tr.findElement(By.cssSelector("td:nth-child(3)"));
            var firstname = name2.getText();
            var phone = tr.findElement(By.cssSelector("td:nth-child(6)"));
            var home = phone.getText();
            var checkbox = tr.findElement(By.name("selected[]"));
            var id = checkbox.getDomAttribute("value");
            contacts.add(new ContactData().withId(id).withLastName(lastname).withFirstName(firstname).withHomePhone(home));
        }
        return contacts;
    }

    public String getPhones(ContactData contact) {
        return manager.driver.findElement(By.xpath(
                String.format("//input[@id='%s']/../../td[6]", contact.id()))).getText();
    }

    public Map<String, String> getPhones() {/// словарь
        var result = new HashMap<String, String>();
        List<WebElement> rows = manager.driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            var id = row.findElement(By.tagName("input")).getDomAttribute("id");
            var phones = row.findElements(By.tagName("td")).get(5).getText();
            result.put(id, phones);
        }
        return result;
    }

    public String getAddress(ContactData contact) {
        return manager.driver.findElement(By.xpath(
                String.format("//input[@id='%s']/../../td[4]", contact.id()))).getText();
    }

    public String getEmails(ContactData contact) {
        return manager.driver.findElement(By.xpath(
                String.format("//input[@id='%s']/../../td[5]", contact.id()))).getText();
    }
}
