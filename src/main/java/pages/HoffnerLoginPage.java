package pages;

import hoffnerProject.objects.HoffnerObj;
import hoffnerProject.support.DriverWait;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class HoffnerLoginPage {

    private HoffnerObj hoffnerObj;
    private DriverWait wait;

    public HoffnerLoginPage(WebDriver driver){
        hoffnerObj = new HoffnerObj(driver);
        wait = new DriverWait(driver);
        PageFactory.initElements(driver, this);
    }

    public void acceptCookies(){
        wait.waitForClickableButton(hoffnerObj.acceptCookieButton).click();
    }

    public void fillEmail(String email){
        wait.waitForVisibleElement(hoffnerObj.inputFieldEmail).sendKeys(email);
    }

    public void fillEmailTemp(String emailTemp){
        wait.waitForVisibleElement(hoffnerObj.inputFieldEmail).sendKeys(emailTemp);
    }

    public void clickSendButton(){
        wait.waitForClickableButton(hoffnerObj.absendenButton).click();
    }

    public Boolean confirmSubscriptionInProgress(){
        String confirmationMessage = wait.waitForClickableButton(hoffnerObj.confirmationMessage).getText();
        Assertions.assertEquals(confirmationMessage, "Nur noch ein Klick und Sie haben es geschafft!");
        return true;
    }

    public Boolean confirmSubscriptionEmailText(){
        wait.switchTab();
        String confirmationMessage = wait.waitForVisibleElement(hoffnerObj.emailConfirmationText).getText();
        Assertions.assertEquals(confirmationMessage, "Anmeldung abgeschlossen!");
        return true;
    }

    public Boolean checkMessageEmailError(){
        String errorMessage = wait.waitForVisibleElement(hoffnerObj.emailError).getText();
        Assertions.assertEquals(errorMessage, "Bitte geben Sie eine gültige E-Mail-Adresse an!");
        return true;
    }

    public boolean checkFieldInput(){
        this.wait.waitForVisibleElement(this.hoffnerObj.inputFieldEmail).isDisplayed();
        return true;
    }

}
