package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class LoginPage extends PageActions {

    private static final By username = By.id("user-name");
    private static final By password = By.id("password");
    private static final By login = By.id("login-button");
    private static final By productsHeader = By.xpath("//span[@class='title' and text()='Products']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String pageUrl){
        driver.get(pageUrl);
    }

    //locators in page
    public void login(String username, String password) {
        // driver.perform actions

        sendKeys(this.username, username);
        sendKeys(this.password, password);
        click(this.login);
        waitForVisibility(productsHeader);
    }
}
