package Tests;

import Pages.HomePage;
import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductTest extends TestBase{

    HomePage homeObject;
    SearchPage searchObject;

    @Test
    public void UserCanSearchForProduct(){
        homeObject = new HomePage(driver);
        searchObject = new SearchPage(driver);
        homeObject.SearchForProduct("mac");
        System.out.println(searchObject.searchTitle.getText());
        Assert.assertTrue(searchObject.searchTitle.getText().contains("Search - "+"mac"));
    }
}
