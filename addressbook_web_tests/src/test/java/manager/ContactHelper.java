package manager;

import model.ContactData;
import org.openqa.selenium.By;

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

    public void removeContact() {
        selectContact();
        click(By.xpath("//input[@value=\'Delete\']"));
        ///driver.switchTo().alert().accept();}
    }

    private void selectContact() {
        click(By.name("selected[]"));
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

    public boolean isContactPresent() {
        return manager.isElementPresent(By.name("selected[]")); }

    private void returnToHomePage() {
        click(By.linkText("home page"));
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
    }

    private void initModifyContact() {
        click(By.xpath("//img[@alt=\'Edit\']"));
    }
}
