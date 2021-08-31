package hoffnerProject.pages;

import hoffnerProject.objects.EmailObj;
import hoffnerProject.support.DriverWait;
import hoffnerProject.utils.PropertieUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class EmailPage {



    private EmailObj emailObj;
    private DriverWait wait;
    static Logger log = Logger.getLogger(EmailPage.class.getName());

    public EmailPage(final WebDriver driver) {
        this.emailObj = new EmailObj(driver);
        this.wait = new DriverWait(driver);
        PageFactory.initElements(driver, this);
        driver.get(PropertieUtils.getValue("urlemail"));
    }


    public String getEmail() {
        String newEmail = this.wait.waitForVisibleElement(this.emailObj.newEmailField).getText();
        log.info("New email created >>> " + newEmail + " ***");
        return newEmail;
    }

    public boolean checkEmailLink(){
        this.wait.waitForVisibleElement(this.emailObj.emailLink).isDisplayed();
        return true;
    }

    public void clickEmailLink() {
        wait.waitForVisibleElement(this.emailObj.emailLink).click();
    }
}
