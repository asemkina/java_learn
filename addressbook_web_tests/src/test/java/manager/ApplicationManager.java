package manager;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class ApplicationManager {
    protected WebDriver driver;
    private LoginHelper session;
    private GroupHelper groups;
    private ContactHelper contacts;
    private Properties properties;
    private JdbcHelper jdbc;
    private HibernateHelper hbm;

    public void init(String browser, Properties properties) throws MalformedURLException {
        this.properties = properties;
        var seleniumServer = properties.getProperty("seleniumServer");
        if (driver == null) {
            if ("chrome".equals(browser)){
                if (seleniumServer != null) {
                    driver = new RemoteWebDriver(new URL(seleniumServer), new ChromeOptions());
                } else {
                    driver = new ChromeDriver();
                }
            } else if ("firefox".equals(browser)){
                if (seleniumServer != null) {
                    driver = new RemoteWebDriver(new URL(seleniumServer), new FirefoxOptions());
                } else {
                    driver = new FirefoxDriver();
                }
            } else {
                throw new IllegalArgumentException(String.format("Unknown browser %s", browser));
            }
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get(properties.getProperty("web.baseUrl"));
            session().login(properties.getProperty("web.userName"), properties.getProperty("web.password"));
        }
    }

    public LoginHelper session(){
        if (session == null){
            session = new LoginHelper(this);
        }
        return session;
    }
    public GroupHelper groups(){
        if (groups == null){
            groups = new GroupHelper(this);
        }
        return groups;
    }

    public ContactHelper contacts(){
        if (contacts == null){
            contacts = new ContactHelper(this);
        }
        return contacts;
    }
    public JdbcHelper jdbc(){
        if (jdbc == null){
            jdbc = new JdbcHelper(this);
        }
        return jdbc;
    }

    public HibernateHelper hbm(){
        if (hbm == null){
            hbm = new HibernateHelper(this);
        }
        return hbm;
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    @AfterEach
    public void tearDown() {
        driver.findElement(By.linkText("Logout")).click();
        driver.quit();
    }

}
