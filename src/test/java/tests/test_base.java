package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;

public class test_base {

    protected WebDriver driver;
    protected HomePage home;
    protected RegisterPage register;
    protected SucseesRegPage sucseesRegPage ;
    protected newsletterpage newsletterpage;
    protected LoginPage login;
    protected AccountPage account;
    protected logoutsuccesspage logout ;
    protected SearchPage search;
    protected Simple_ProductPage product;
    protected CartPage cart;
    protected CheckoutPage checkout;
    protected CategoryPage category;

    @BeforeMethod
    public void setUp() {
        //  ===== Use WebDriverManager to automatically manage driver binaries =====
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //  ===== Initialize Pages =====
        home = new HomePage(driver);
        register = new RegisterPage(driver);
        sucseesRegPage =new SucseesRegPage(driver);
        newsletterpage = new newsletterpage(driver);
        login = new LoginPage(driver);
        account = new AccountPage(driver);
        logout = new logoutsuccesspage(driver);
        search = new SearchPage(driver);
        product = new Simple_ProductPage(driver);
        cart = new CartPage(driver);
        checkout = new CheckoutPage(driver);
        category = new CategoryPage(driver);
        // Navigate to Home Page (Your Local Project)
        driver.get("http://localhost/opencartproject/index.php?route=common/home&language=en-gb");
    }
  /* @AfterMethod
    public void tearDown() {
        driver.quit();
    }*/
    //  ===== Helper method to preconditions =====
    protected void access_newsletter_bage() {
      sucseesRegPage.clickContinue();
      account.clickNewsletter();}
    protected void loginWithExistingAccount() {
        home.openLoginPage();
        login.login("testuser2@gmail.com", "password123");
        login.click_login_btn();}
    protected void open_products_page() {
        loginWithExistingAccount();
        account.openhomepage();}

}
