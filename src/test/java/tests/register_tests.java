package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class register_tests extends test_base {

    @Test
    public void successful_user_registration() {
        home.openRegisterPage();
        register.registerNewUser("Test", "User", "testuser@gmail.com", "password123", true);
        register.agreeToPrivacyPolicy();
        register.clickContinue();
        sucseesRegPage.Assert_user_reg_succesful();
    }
    @Test
    public void registration_with_existing_email() {
        home.openRegisterPage();
        register.registerNewUser("Test", "User", "testuser@gmail.com", "password123", true);
        register.agreeToPrivacyPolicy();
        register.clickContinue();
        register.Assert_dublicateacc_errormsg();
    }
    @Test
    public void registration_without_accept_policy() {
        home.openRegisterPage();
        register.registerNewUser("Test", "User", "testuser2@gmail.com", "password123", true);
        register.clickContinue();
        register.Assert_reg_without_accept_policy();
    }
    @Test
    public void registration_without_subscripe_newsletter() {
        home.openRegisterPage();
        register.registerNewUser("Test2", "User2", "testuser2@gmail.com", "password123", false);
        register.agreeToPrivacyPolicy();
        register.clickContinue();

    }
    @Test
    public void register_with_invalid_email() {
        home.openRegisterPage();
        register.registerNewUser("Test", "User", "invalid-email", "password123",true);
        register.agreeToPrivacyPolicy();
        register.clickContinue();
        register.Assert_invalidacc_errormsg();
    }
    @Test
    public void register_with_empty_fields() {
        home.openRegisterPage();
        register.registerNewUser("", "", "", "",false);
        register.clickContinue();
        A
    }


}
