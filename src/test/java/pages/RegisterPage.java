package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
    By dublicateerrormsg = By.linkText(" Warning: E-Mail Address is already registered! ");
    By firstNameError = By.id("error-firstname");
    By lastNameError = By.id("error-lastname");
    By emailError = By.id("error-email");
    By passwordError = By.id("error-password");
    By acceptpolicyerror = By.linkText(" Warning: You must agree to the Privacy Policy! ");
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
    public void Assert_dublicateacc_errormsg() {
        Assert.assertTrue(driver.findElement(dublicateerrormsg).isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost/opencartproject/index.php?route=account/register&language=en-gb");}
    public void Assert_reg_without_accept_policy() {
        Assert.assertTrue(driver.findElement(acceptpolicyerror).isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost/opencartproject/index.php?route=account/register&language=en-gb");}
    public void Assert_invalidacc_errormsg() {
        Assert.assertTrue(driver.findElement(emailError).isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost/opencartproject/index.php?route=account/register&language=en-gb");}
    public void Assert_emptyfields_errors_msg() {
        Assert.assertTrue(driver.findElement(firstNameError).isDisplayed());
        Assert.assertTrue(driver.findElement(lastNameError).isDisplayed());
        Assert.assertTrue(driver.findElement(passwordError).isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(),"http://localhost/opencartproject/index.php?route=account/register&language=en-gb");}
}
