package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage extends PageBase{
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/input")
    WebElement quantityTxt;

    @FindBy(css = "button.btn.btn-primary")
    WebElement updateQuantityBtn;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/span/button[2]")
    WebElement removeProductBtn;

    /*@FindBy(css = "a.btn.btn-default")
    WebElement continueShoppingBtn;*/

    @FindBy(css = "a.btn.btn-primary")
    WebElement checkOutBtn;

    @FindBy(xpath ="//*[@id=\"content\"]/form/div/table/tbody/tr/td[6]" )
    public WebElement totalPriceProduct;
/*
    @FindBy(xpath = "//*[@id=\"content\"]/form/div/table/tbody/tr/td[5]")
    public WebElement uPriceProduct;*/

    @FindBy(xpath = "//*[@id=\"content\"]/p")
    public WebElement cartEmpty;

    // checkout fields/elements

    @FindBy(id = "input-payment-firstname")
    WebElement firstNameTxt;

    @FindBy(id="input-payment-lastname")
    WebElement lastNameTxt;

    @FindBy(id = "input-payment-address-1")
    WebElement addressTxt;

    @FindBy(id="input-payment-city")
    WebElement cityTxt;

    @FindBy(id = "input-payment-country")
    WebElement countrySelect;

    @FindBy(id = "input-payment-zone")
    WebElement regionSelect;

    @FindBy(id = "button-payment-address")
    WebElement continueStep2;

    @FindBy(name = "agree")
    WebElement checkTermsCheckBox;

    @FindBy(id = "button-payment-method")
    WebElement continueStep3;

    @FindBy(id = "button-confirm")
    WebElement confirmOrder;

    @FindBy(id = "content")
    public WebElement successMsg;


    public void UpdateQuantityProduct() throws InterruptedException {
        quantityTxt.clear();
        quantityTxt.sendKeys("2");
        Thread.sleep(3000);
        updateQuantityBtn.click();
    }

    public void RemoveProductFromCart(){
        removeProductBtn.click();
    }

    public void CheckOutProcess(
            String fName, String lName, String address, String city ) throws InterruptedException {

        checkOutBtn.click();

        firstNameTxt.sendKeys(fName);
        lastNameTxt.sendKeys(lName);
        addressTxt.sendKeys(address);
        cityTxt.sendKeys(city);

        Select country = new Select(countrySelect);
        country.selectByVisibleText("Norway");

        Thread.sleep(3000);

        Select region = new Select(regionSelect);
        region.selectByIndex(3);
        Thread.sleep(3000);
        continueStep2.click();

        Thread.sleep(3000);
        checkTermsCheckBox.click();
        continueStep3.click();
        Thread.sleep(3000);
        confirmOrder.click();


    }


}
