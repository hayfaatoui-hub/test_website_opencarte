package Tests;

import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeCurrencyTest extends TestBase{


    HomePage homeObject;
    @Test(priority = 1)
    public void UserCanChangeCurrency() throws InterruptedException {
        homeObject = new HomePage(driver);
        homeObject.ChangeCurrency();
        Thread.sleep(2000);
        Assert.assertTrue(homeObject.cartTotal.getText().contains("€"));
    }

}
