import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;
    private String username;
    private String password;

    @BeforeMethod
    void initPages() {
        loginPage = new LoginPage(getDriver());
       this.username = getUsername();
        this.password = getPassword();
    }

    @Test
    public void validateLogin() {
        //write code to test login functionality and assert
        loginPage.openHomePage(getAppURL());
        loginPage.login(username, password);
    }


}
