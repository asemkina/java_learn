import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContactCreationTests extends TestBase{

    @Test
    public void contact() {
        driver.findElement(By.linkText("add new")).click();
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).sendKeys("Анна");
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).sendKeys("Семкина");
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).sendKeys("ул.Богдана Хмельницкого, 3-62");
        driver.findElement(By.name("home")).click();
        driver.findElement(By.name("home")).sendKeys("89191990515");
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("semkina.an@yandex.ru");
        driver.findElement(By.xpath("(//input[@name=\'submit\'])[2]")).click();
        driver.findElement(By.linkText("home page")).click();
          }
}
