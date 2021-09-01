package krieger.steps.portabilidade.steps;

import hoffnerProject.pages.EmailPage;
import hoffnerProject.support.TestBase;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.HoffnerLoginPage;
import java.util.logging.Logger;

import static hoffnerProject.utils.PropertieUtils.getValue;

public class HoffnerStep {
    private WebDriver driver;
    private String newEmail;
    static Logger log = Logger.getLogger(HoffnerStep.class.getName());

    @Before(value = "@HoffnerScenario01")
    public void init01(){
        this.driver = new TestBase().getDriver();
    }

    @Before(value = "@HoffnerScenario02")
    public void init02(){ this.driver = new TestBase().getDriver();    }

    @Before(value = "@HoffnerScenario03")
    public void init03(){ this.driver = new TestBase().getDriver();    }


    @Given("a Hoffner login page")
    public void a_Hoffner_login_page() {
        log.info("Go to acess login page: " + getValue("urlkrieger") + " ***");
    }

    @When("I open a page")
    public void i_open_a_page() {
        this.driver.get(getValue("urlkrieger"));
    }

    @When("I accept the cookie popup")
    public void i_accept_popup() {
        HoffnerLoginPage hoffnerLoginPage = new HoffnerLoginPage(driver);
        hoffnerLoginPage.acceptCookies();
    }

    @When("I accept cookie popup")
    public void i_accept_cookie_popup() {
//        HoffnerLoginPage hoffnerLoginPage = new HoffnerLoginPage(driver);
//        hoffnerLoginPage.acceptCookies();
        System.out.println("to be discomented");
    }

    @Then("I can see a newsletter subscription input")
    public void i_can_see_a_newsletter_subscription_input() {
        HoffnerLoginPage hoffnerLoginPage = new HoffnerLoginPage(driver);
        Assertions.assertTrue(hoffnerLoginPage.checkFieldInput());
    }

    @Given("I enter my {string} in the input field")
    public void i_enter_my_email_in_the_input_field(String email) {
        HoffnerLoginPage hoffnerLoginPage = new HoffnerLoginPage(driver);
        hoffnerLoginPage.fillEmail(email);
    }

    @Given("I enter my temporary email in the input field")
    public void i_enter_my_email_temporary_in_the_input_field() {
        HoffnerLoginPage hoffnerLoginPage = new HoffnerLoginPage(driver);
        hoffnerLoginPage.fillEmailTemp(newEmail);
    }

    @Given("I press Absenden button")
    public void i_press_button() {
        HoffnerLoginPage hoffnerLoginPage = new HoffnerLoginPage(driver);
        hoffnerLoginPage.clickSendButton();
    }

    @Then("I can see a confirmation message that my subscription is in progress")
    public void i_can_see_a_confirmation_message_that_my_subscription_is_in_progress() {
        HoffnerLoginPage hoffnerLoginPage = new HoffnerLoginPage(driver);
        Assertions.assertTrue(hoffnerLoginPage.confirmSubscriptionInProgress());
        log.info("Subscription is in progress ***");
    }

    @Given("I create a temporary email")
    public void i_create_temp_email() {
        final EmailPage emailPage = new EmailPage(this.driver);
        newEmail = emailPage.getEmail();
    }

    @Then("I receive an email asking to confirm my email")
    public void i_receive_an_email_asking_to_confirm_my_email() {
        log.info("Email Received ***");
    }

    @When("I open the email")
    public void i_open_the_email() {
        final EmailPage emailPage = new EmailPage(this.driver);
        newEmail = emailPage.getEmail();
    }

    @Then("there is a link to finish registration process")
    public void there_is_a_link_to_finish_registration_process() {
        final EmailPage emailPage = new EmailPage(this.driver);
        Assertions.assertTrue(emailPage.checkEmailLink());
    }

    @When("I click on Jetzt Anmeldung abschließen")
    public void i_click_email_link() {
        final EmailPage emailPage = new EmailPage(this.driver);
        emailPage.clickEmailLink();
    }

    @Then("I am redirected to page confirming subscription")
    public void i_am_redirected_to_page_confirming_subscription() {
        HoffnerLoginPage hoffnerLoginPage = new HoffnerLoginPage(driver);
        Assertions.assertTrue(hoffnerLoginPage.confirmSubscriptionEmailText());
        log.info("Confirming Subscription page loaded successfuly ***");
    }

    @Then("I can see an email error message")
    public void i_can_see_an_email_error_message() {
        HoffnerLoginPage hoffnerLoginPage = new HoffnerLoginPage(driver);
        Assertions.assertTrue(hoffnerLoginPage.checkMessageEmailError());
        log.info("Confirming message is displayed: Bitte geben Sie eine gültige E-Mail-Adresse an! ***");
    }
}





