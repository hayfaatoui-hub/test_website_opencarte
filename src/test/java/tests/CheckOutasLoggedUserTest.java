package Tests;

import Pages.HomePage;
import Pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutasLoggedUserTest extends TestBase {

    HomePage homeObject;
    ShoppingCartPage shoppingCartObject;
    UserRegistrationTest registrationObject;
    CheckShoppingCartTest checkShoppingCartObject;



    @Test(priority = 1)
    public  void UserCanRegister() throws InterruptedException {
        registrationObject = new UserRegistrationTest();
        homeObject = new HomePage(driver);
        registrationObject.UserCanRegister();
        homeObject.homeLink.click();
        Thread.sleep(3000);
    }

    /*@Test(priority = 2)
    public void CheckCart() throws InterruptedException {
        checkShoppingCartObject = new CheckShoppingCartTest();
        checkShoppingCartObject.UpDateCart();
    }*/

    @Test(priority = 2)
    public void AddProductAndCheckOut() throws InterruptedException {
        shoppingCartObject = new ShoppingCartPage(driver);
        homeObject.AddProductToCart();
        //shoppingCartObject.UpdateQuantityProduct();
        Thread.sleep(4000);
        shoppingCartObject.CheckOutProcess(
                "kkkk","kkkk", "kkkk","dsjh");
        Thread.sleep(3000);
        Assert.assertTrue(shoppingCartObject.successMsg.getText().contains("Your order has been placed!"));
    }
}
