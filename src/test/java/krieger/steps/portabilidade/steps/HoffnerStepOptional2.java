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

public class HoffnerStepOptional2 {
    private WebDriver driver;
    private String newEmail;
    static Logger log = Logger.getLogger(HoffnerStepOptional2.class.getName());

    @Before(value = "@HoffnerScenario04")
    public void init03(){ this.driver = new TestBase().getDriver();    }

    @Given("a Hoffner page")
    public void a_Hoffner_page() {
        System.out.println("to be implemented");
    }

    @When("I open a page www.hoeffner.de")
    public void i_open_a_page_https_www_hoeffner_de() {
        System.out.println("to be implemented");
    }

    @Then("I can see the Search field")
    public void i_can_see_the_Search_field() {
        System.out.println("to be implemented");
    }

    @When("I enter my {string} in the search field")
    public void i_enter_my_in_the_search_field(String string) {
        System.out.println("to be implemented");
    }

    @Then("should be automatically displayed some similar goods on screen")
    public void should_be_automatically_displayed_some_similar_goods_on_screen() {
        System.out.println("to be implemented");
    }

    @When("I click on the product I want to buy")
    public void i_click_on_the_product_productName_I_want_to_buy() {
        System.out.println("to be implemented");
    }

    @Then("I can see the product page")
    public void i_can_see_the_product_page() {
        System.out.println("to be implemented");
    }

    @When("I put my address code")
    public void i_put_my_address_code() {
        System.out.println("to be implemented");
    }

    @When("I click on In den Warenkorb button")
    public void i_click_on_In_den_Warenkorb_button() {
        System.out.println("to be implemented");
    }

    @Then("I can see a popup with Zum Warenkorb button")
    public void i_can_see_a_popup_with_Zum_Warenkorb_button() {
        System.out.println("to be implemented");
    }

    @When("I click on Zum Warenkorb button")
    public void i_click_on_Zum_Warenkorb_button() {
        System.out.println("to be implemented");
    }

    @Then("I can see the Zur Kasse button")
    public void i_can_see_the_Zur_Kasse_button() {
        System.out.println("to be implemented");
    }

    @When("I click on Zur Kasse button")
    public void i_click_on_Zur_Kasse_button() {
        System.out.println("to be implemented");
    }

    @Then("I can see the Weiter als Gast button")
    public void i_can_see_the_Weiter_als_Gast_button() {
        System.out.println("to be implemented");
    }

    @When("I clck on Weiter als Gast button")
    public void i_clck_on_Weiter_als_Gast_button() {
        System.out.println("to be implemented");
    }

    @Then("I can see the Ihre Rechnungsadresse fields")
    public void i_can_see_the_Ihre_Rechnungsadresse_fields() {
        System.out.println("to be implemented");
    }

    @When("I fill all the fields and click on Weiter button")
    public void i_fill_all_the_fields_and_click_on_Weiter_button() {
        System.out.println("to be implemented");
    }

    @Then("I can see the Bitte wählen Sie eine Zahlart page")
    public void i_can_see_the_Bitte_wählen_Sie_eine_Zahlart_page() {
        System.out.println("to be implemented");
    }

    @When("I click on Zahlung bei Lieferung \\(Nachnahme) and click on Weiter button")
    public void i_click_on_Zahlung_bei_Lieferung_Nachnahme_and_click_on_Weiter_button() {
        System.out.println("to be implemented");
    }

    @Then("I can see Bitte überprüfen und bestätigen Sie Ihre Bestellung page")
    public void i_can_see_Bitte_überprüfen_und_bestätigen_Sie_Ihre_Bestellung_page() {
        System.out.println("to be implemented");
    }

    @Then("press the Jetzt kaufen button")
    public void press_the_Jetzt_kaufen_button() {
        System.out.println("to be implemented");
    }

    @Then("the order is created")
    public void the_order_is_created() {
        System.out.println("to be implemented");
    }

}





