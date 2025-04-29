import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class ContactDeleteTests extends TestBase{

    @Test
    public void delete() {
        driver.findElement(By.id("MassCB")).click();
        driver.findElement(By.xpath("//input[@value=\'Delete\']")).click();
        driver.switchTo().alert().accept();
    }
}
