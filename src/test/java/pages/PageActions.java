package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageActions {

    protected WebDriver driver;
    protected WebDriverWait wait;  // 15s default, customizable

    public PageActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Generic wait methods (reusable)
    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean waitForPresence(By locator, int timeoutSeconds) {
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return !shortWait.until(driver -> driver.findElements(locator).isEmpty());
    }

    // Fluent actions with built-in waits
    public void click(By locator) {
        waitForClickable(locator).click();
    }

    public void sendKeys(By locator, String text) {
        waitForVisibility(locator).clear();
        waitForVisibility(locator).sendKeys(text);
    }
}
