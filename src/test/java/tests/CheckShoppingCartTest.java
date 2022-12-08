package tests;

import Pages.HomePage;
import Pages.ShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckShoppingCartTest extends TestBase{

    ShoppingCartPage shoppingcartObject;
    HomePage homeObject;


    @Test(priority = 1)
    public void UpDateCart() throws InterruptedException {
        shoppingcartObject = new ShoppingCartPage(driver);
        homeObject = new HomePage(driver);
        homeObject.AddProductToCart();
        Thread.sleep(3000);
        shoppingcartObject.UpdateQuantityProduct();
        Thread.sleep(3000);
        Assert.assertTrue(shoppingcartObject.totalPriceProduct.getText().contains("944"));
        Thread.sleep(3000);
    }
    @Test(priority = 2)
    public void RemoveProductFromCart() throws InterruptedException {

        shoppingcartObject = new ShoppingCartPage(driver);
        shoppingcartObject.RemoveProductFromCart();
        Thread.sleep(3000);
        Assert.assertTrue(shoppingcartObject.cartEmpty.getText().contains("empty"));

    }

    @Test(priority = 3)
    public void OpenHomePage(){
        homeObject = new HomePage(driver);
        homeObject.homeLink.click();
    }

}
