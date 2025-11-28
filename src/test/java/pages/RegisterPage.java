package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    WebDriver driver;
    WebDriverWait wait;
    //                  ===== LOCATORS =====
    By firstName = By.id("input-firstname");
    By lastName = By.id("input-lastname");
    By email = By.id("input-email");
    By password = By.id("input-password");
    By newsletterCheckbox = By.id("input-newsletter");
    By agreePolicy = By.name("agree");
    By continueBtn = By.xpath("//button[@class='btn btn-primary']");
    By errorMessage = By.xpath("//*[@id=\"alert\"]/div");
    By firstNameError = By.id("error-firstname");
    By lastNameError = By.id("error-lastname");
    By emailError = By.id("error-email");
    By passwordError = By.id("error-password");
    By acceptpolicyerror = By.xpath("//*[@id=\"alert\"]/div");
    //                  ===== Constructor ======
    public RegisterPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));}
    //                  ===== ACTIONS =====
    public void registerNewUser(String fName, String lName, String emailValue, String pass, boolean subscribeNewsletter) {
        wait.until(ExpectedConditions.presenceOfElementLocated(firstName));
        driver.findElements(firstName).clear();
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(lName);
        driver.findElements(email).clear();
        driver.findElement(email).sendKeys(emailValue);
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
        if(subscribeNewsletter==true){
            driver.findElement(newsletterCheckbox).click();}}
    public void agreeToPrivacyPolicy() {
        wait.until(ExpectedConditions.presenceOfElementLocated(agreePolicy));
        driver.findElement(agreePolicy).click();}
    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        driver.findElement(continueBtn).click();}
    //                  ===== ASSERTION  =====

}
