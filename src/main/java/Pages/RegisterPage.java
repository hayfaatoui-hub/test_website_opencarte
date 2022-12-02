package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageBase{
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="input-firstname")
    WebElement firstNameTxt;

    @FindBy(id="input-lastname")
    WebElement lastNameTxt;

    @FindBy(id="input-email")
    WebElement emailTxt;

    @FindBy(id="input-telephone")
    WebElement phoneTxt;

    @FindBy(id="input-password")
    WebElement passwordTxt;

    @FindBy(id="input-confirm")
    WebElement confirmPasswordTxt;

    @FindBy(name="agree")
    WebElement checkPrivacy;

    @FindBy(css="input.btn.btn-primary")
    WebElement continueBtn;


    public void UserCanRegister(
            String firstname, String lastname, String email, String password, String phone){

        firstNameTxt.sendKeys(firstname);
        lastNameTxt.sendKeys(lastname);
        emailTxt.sendKeys(email);
        phoneTxt.sendKeys(phone);
        passwordTxt.sendKeys(password);
        confirmPasswordTxt.sendKeys(password);
        checkPrivacy.click();
        continueBtn.click();
    }

}
