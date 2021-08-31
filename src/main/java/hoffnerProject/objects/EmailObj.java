package hoffnerProject.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailObj {

    @FindBy(css = "#email_ch_text")
    public WebElement newEmailField;

    @FindBy(css = ".ctaf.mctaf")
    public WebElement emailLink;

    public EmailObj(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
