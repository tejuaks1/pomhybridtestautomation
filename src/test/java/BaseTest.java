import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigFileReader;

import java.io.IOException;

public class BaseTest {


    private WebDriver driver;
    private String appURL;
    private String username;
    private String password;
    private ConfigFileReader configFileReader;  // Move here


    @BeforeMethod
    public void setup() throws IOException {

        this.driver = new ChromeDriver();
        this.configFileReader = new ConfigFileReader();
    }


    @AfterMethod
    private void teardown() {

        driver.quit();
    }

    public String getUsername() {
        return configFileReader.getUsername();
    }

    public String getPassword() {
        return configFileReader.getPassword();
    }
    public String getAppURL() {
        return configFileReader.getBaseUrl();
    }
    public WebDriver getDriver() {
        return driver;
    }
    public ConfigFileReader getConfigFileReader() {
        return configFileReader;
    }


}
