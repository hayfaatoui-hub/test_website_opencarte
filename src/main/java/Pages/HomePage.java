package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {
  public HomePage(WebDriver driver) {
    super(driver);
  }

  @FindBy(css="a.dropdown-toggle")
  WebElement loggListBtn;

  @FindBy(linkText="Register")
  WebElement registerLink;

  @FindBy(linkText="Login")
  WebElement loginLink;

  @FindBy(linkText = "Logout")
  WebElement logOutLink;

  @FindBy(css = "button.btn.btn-link.dropdown-toggle")
  WebElement currencyLink;

  @FindBy(css = "button.currency-select.btn.btn-link.btn-block")
  WebElement euroCurrency;

  @FindBy(id = "cart-total")
  public WebElement cartTotal;

  @FindBy(css="input.form-control.input-lg")
  WebElement searchTxt;

  @FindBy(css = "button.btn.btn-default.btn-lg")
  WebElement searchBtn;

  /*@FindBy(linkText = "Phones & PDAs")
  WebElement phonesLink;*/

  @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[4]")
  WebElement shoppingCartIconLink;

  @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[1]/div/div[3]/button[1] ")
  WebElement addToCartBtn;

  @FindBy(linkText = "shopping cart")
  WebElement ShoppingCartPageBtn;

  @FindBy(xpath = "//*[@id=\"logo\"]/h1/a")
  public WebElement homeLink;



  public void OpenRegisterPage() throws InterruptedException {
    loggListBtn.click();
    Thread.sleep(2000);
    registerLink.click();
  }
  public void  LogOutClick(){
    loggListBtn.click();
    logOutLink.click();
  }

  public void OpenLoginPage() throws InterruptedException {
    loggListBtn.click();
    Thread.sleep(2000);
    loginLink.click();

  }
  public void ChangeCurrency() throws InterruptedException {
    currencyLink.click();
    Thread.sleep(1000);
    euroCurrency.click();
  }

  public void SearchForProduct(String product){
    searchTxt.sendKeys(product);
    searchBtn.click();
  }

  public void AddProductToCart() throws InterruptedException {
    addToCartBtn.click();
    Thread.sleep(3000);
    ShoppingCartPageBtn.click();
  }

}
