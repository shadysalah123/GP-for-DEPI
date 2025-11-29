package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Simple_ProductPage {
    WebDriver driver;
    WebDriverWait wait;
    //                  ===== LOCATORS =====
    By productName = By.xpath("//*[@id=\"content\"]/div[1]/div[2]/h1");
    By productPrice = By.className("price-new");
    By addToCartButton = By.id("button-cart");
    By quantityInput = By.id("input-quantity");
    By addToWishlistButton = By.xpath("//button[@aria-label=\"Add to Wish List\"]");
    By productDescription = By.xpath("a[@href=\"#tab-description\"]");
    By prod_descs_form = By.id("tab-description");
    By prod_specs = By.xpath("//a[@href=\"#tab-specification\"]");
    By prod_specs_form = By.id("tab-description");
    By prod_review = By.xpath("//a[@href=\"#tab-review\"]");
    By prod_review_form = By.id("tab-description");
    By successcartMessage = By.xpath("//div[contains(@class, 'alert-success')]");
    By cartButton = By.xpath("//button[@class=\"btn btn-lg btn-dark d-block dropdown-toggle\"]");

    //                  ===== Constructor ======
    public Simple_ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    //                  ===== ACTIONS =====
    public String getProductName() {
        wait.until(ExpectedConditions.presenceOfElementLocated(productName));
        return driver.findElement(productName).getText();}
    public String getProductPrice() {
        wait.until(ExpectedConditions.presenceOfElementLocated(productPrice));
        return driver.findElement(productPrice).getText();}
    public void setQuantity(String quantity) {
        wait.until(ExpectedConditions.presenceOfElementLocated(quantityInput));
        driver.findElement(quantityInput).clear();;
        driver.findElement(quantityInput).sendKeys((quantity));}
    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        driver.findElement(addToCartButton).click();}
    public void addToCartWithQuantity(String quantity) {
        setQuantity(quantity);
        addToCart();}
    public void addToWishlist() {
        wait.until(ExpectedConditions.elementToBeClickable(addToWishlistButton));
        driver.findElement(addToWishlistButton).click();}
    public void open_prod_descs(){
        wait.until(ExpectedConditions.elementToBeClickable(productDescription));
        driver.findElement(productDescription).click();}
    public void open_prod_specs(){
        wait.until(ExpectedConditions.elementToBeClickable(prod_specs));
        driver.findElement(prod_specs).click();}
    public void open_prod_reviews(){
        wait.until(ExpectedConditions.elementToBeClickable(prod_review));
        driver.findElement(prod_review).click();}


}



