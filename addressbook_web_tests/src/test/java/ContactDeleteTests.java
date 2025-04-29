import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContactDeleteTests {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void delete() {
        driver.get("http://localhost/addressbook/");
        driver.manage().window().setSize(new Dimension(1552, 840));
        driver.findElement(By.name("user")).sendKeys("admin");
        driver.findElement(By.name("pass")).click();
        driver.findElement(By.name("pass")).sendKeys("secret");
        driver.findElement(By.id("LoginForm")).click();
        driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
        driver.findElement(By.id("MassCB")).click();
        driver.findElement(By.xpath("//input[@value=\'Delete\']")).click();
        driver.switchTo().alert().accept();
        driver.findElement(By.linkText("Logout")).click();
    }
}
