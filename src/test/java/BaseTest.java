import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {


    private WebDriver driver;

    @BeforeMethod
    private void setup() {

        this.driver = new ChromeDriver();

    }


    @AfterMethod
    private void teardown() {

        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

}
