package Tests;

import Pages.AccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    HomePage homeObject;
    LoginPage loginObject;
    AccountPage accountObject;

    @Test
    public void UserCanLogin() throws InterruptedException {
        homeObject = new HomePage(driver);
        loginObject = new LoginPage(driver);
        accountObject = new AccountPage(driver);
        homeObject.OpenLoginPage();
        loginObject.Login("qqq@q.q","qqqq");
        Assert.assertTrue(accountObject.accountTitle.getText().equals("My Account"));
        Thread.sleep(4000);

    }
}
