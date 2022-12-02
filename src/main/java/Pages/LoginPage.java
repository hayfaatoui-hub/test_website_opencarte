package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="input-email")
    WebElement emailTxt;

    @FindBy(id="input-password")
    WebElement passwordTxt;

    @FindBy(css = "input.btn.btn-primary")
    WebElement logInBtn;


    public  void Login( String email, String password){
        emailTxt.sendKeys(email);
        passwordTxt.sendKeys(password);
        logInBtn.click();
    }
}
