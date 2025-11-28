package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    //                  ===== LOCATORS =====
    By emailInput = By.id("input-email");
    By passwordInput = By.id("input-password");
    By loginButton = By.xpath("//*[@id=\"form-login\"]/div[3]/button");
    By forgotPasswordLink = By.xpath("//*[@id=\"form-login\"]/div[2]/a");
    By registerLink = By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/a");
    By errorMessage = By.xpath("//*[@id=\"alert\"]/div");
    //                  ===== Constructor ======
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));}
    //                  ===== ACTIONS =====
    public void login(String email, String password) {
        wait.until(ExpectedConditions.presenceOfElementLocated(emailInput));
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();}
    public void clickForgotPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordLink));
        driver.findElement(forgotPasswordLink).click();}
    public void clickRegisterLink() {
        wait.until(ExpectedConditions.elementToBeClickable(registerLink));
        driver.findElement(registerLink).click();}
    //                  ===== ASSERTION  =====

}

