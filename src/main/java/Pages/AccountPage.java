package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends PageBase{


    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="content")
    public WebElement congMsg;

    @FindBy(tagName = "h2")
    public WebElement accountTitle;

    @FindBy(id ="" )
    WebElement continueBtn;


    @FindBy(css = "a.btn.btn-primary")
    WebElement returnToHome;


    public void ReturnToHome(){
        returnToHome.click();
    }

}
