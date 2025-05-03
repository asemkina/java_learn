package manager;

import model.ContactData;
import org.openqa.selenium.By;

public class ContactHelper {

    private final ApplicationManager manager;

    public ContactHelper (ApplicationManager manager){
        this.manager = manager;
    }

    public void openContactsPage() {
        if (!manager.isElementPresent(By.xpath("(//input[@name=\'submit\'])[2]"))) {
            manager.driver.findElement(By.linkText("add new")).click();
        }
    }

    public void createContact(ContactData contact) {
        openContactsPage();
        manager.driver.findElement(By.linkText("add new")).click();
        manager.driver.findElement(By.name("firstname")).click();
        manager.driver.findElement(By.name("firstname")).sendKeys(contact.firstname());
        manager.driver.findElement(By.name("lastname")).click();
        manager.driver.findElement(By.name("lastname")).sendKeys(contact.lastname());
        manager.driver.findElement(By.name("address")).click();
        manager.driver.findElement(By.name("address")).sendKeys(contact.address());
        manager.driver.findElement(By.name("home")).click();
        manager.driver.findElement(By.name("home")).sendKeys(contact.home());
        manager.driver.findElement(By.name("email")).click();
        manager.driver.findElement(By.name("email")).sendKeys(contact.email());
        manager.driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
        manager.driver.findElement(By.linkText("home page")).click();
    }

    public void removeContact() {
        manager.driver.findElement(By.name("selected[]")).click();
        manager.driver.findElement(By.xpath("//input[@value=\'Delete\']")).click();
        ///driver.switchTo().alert().accept();}
}

    public boolean isContactPresent() {
        return manager.isElementPresent(By.name("selected[]")); }
}
