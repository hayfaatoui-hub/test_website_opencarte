package tests;

import Pages.AccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserRegistrationTest extends TestBase {

    HomePage homeObject;
    RegisterPage registerObject;
    AccountPage accountObject;
    //LoginTest loginObject;
    LoginPage loginObject;

    Faker fakeData = new Faker();
    String firstname = fakeData.name().firstName();
    String lastname = fakeData.name().lastName();
    String email = fakeData.internet().emailAddress();
    String password = fakeData.number().digits(8).toString();
    String phone = fakeData.phoneNumber().phoneNumber();
    @Test(priority = 1)
    public void UserCanRegister() throws InterruptedException {

        homeObject = new HomePage(driver);
        registerObject = new RegisterPage(driver);
        accountObject = new AccountPage(driver);
        homeObject.OpenRegisterPage();
        Thread.sleep(2000);
        registerObject.UserCanRegister(firstname, lastname, email, password, phone);
        Thread.sleep(2000);
        Assert.assertTrue(accountObject.congMsg.getText().contains("Congratulations! Your new account has been"));
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void UserCanLogOut()
    {
        homeObject.LogOutClick();
    }

    @Test(priority = 3)
    public void UserCanLogin() throws InterruptedException {
        homeObject = new HomePage(driver);
        loginObject = new LoginPage(driver);
        accountObject = new AccountPage(driver);
        homeObject.OpenLoginPage();
        loginObject.Login(email,password);
        Assert.assertTrue(accountObject.accountTitle.getText().equals("My Account"));
        Thread.sleep(4000);


    }

    @Test(priority = 4)
    public void LogOut()
    {
        homeObject.LogOutClick();
        homeObject.homeLink.click();
    }
}
