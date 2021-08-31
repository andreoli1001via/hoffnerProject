package hoffnerProject.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HoffnerObj {

    @FindBy(xpath = "//*[@id=\"responsive\"]/div[15]/div/div/div[2]/div[2]/button")
    public WebElement acceptCookieButton;

    @FindBy(css = "#email")
    public WebElement inputFieldEmail;

    @FindBy(css = "#newsletterFormSubmitBtn")
    public WebElement absendenButton;

    @FindBy(css = ".simpleText.simpleText--gray.simpleText--boldFont.simpleText--size13")
    public WebElement confirmationMessage;

    @FindBy(css = ".-museo-light")
    public WebElement emailConfirmationText;

    @FindBy(css = "#email-error")
    public WebElement emailError;

    public HoffnerObj(final WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
