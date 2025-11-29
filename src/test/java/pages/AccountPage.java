package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AccountPage {
    WebDriver driver;
    WebDriverWait wait;
    //                  ===== LOCATORS =====
    By pageTitle = By.xpath("//*[@id=\"content\"]/h1");
    By editAccountLink = By.linkText("Edit your account information");
    By changePasswordLink = By.linkText("Change your password");
    By addressBookLink = By.linkText("Modify your address book entries");
    By wishlistLink = By.linkText("Modify your wish list");
    By orderHistoryLink = By.linkText("View your order history");
    By newsletterLink = By.linkText("Subscribe / unsubscribe to newsletter");
    By logoutLink = By.xpath("//*[@id=\"column-right\"]/div/a[14]");

    //                  ===== Constructor ======
    public AccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    //                  ===== ACTIONS =====
    public void clickEditAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(editAccountLink));
        driver.findElement(editAccountLink).click();}
    public void clickChangePassword() {
        wait.until(ExpectedConditions.elementToBeClickable(changePasswordLink));
        driver.findElement(changePasswordLink).click();}
    public void clickAddressBook() {
        wait.until(ExpectedConditions.elementToBeClickable(addressBookLink));
        driver.findElement(addressBookLink).click();}
    public void clickWishlist() {
        wait.until(ExpectedConditions.elementToBeClickable(wishlistLink));
        driver.findElement(wishlistLink).click();}
    public void clickOrderHistory() {
        wait.until(ExpectedConditions.elementToBeClickable(orderHistoryLink));
        driver.findElement(orderHistoryLink).click();}
    public void clickNewsletter() {
        wait.until(ExpectedConditions.elementToBeClickable(newsletterLink));
        driver.findElement(newsletterLink).click();}
    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        driver.findElement(logoutLink).click();}
    //                  ===== ASSERTION  =====

}
