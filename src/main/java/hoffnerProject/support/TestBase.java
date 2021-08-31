package hoffnerProject.support;

import hoffnerProject.utils.ScreenShotUtils;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {

    private WebDriver driver;

    public TestBase(){
//        this.driver = new Browsers().setupSeleniumGrid();
         this.driver = new Browsers().setupChromeDriver();


        this.driver.manage().window().maximize();
//        this.driver.get(getValue("urlkrieger"));

        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    public WebDriver getDriver(){
        return this.driver;
    }

    public void close(final Scenario scenario) {
        final byte[] screenshot = new ScreenShotUtils(this.driver).captureEvidence();
        scenario.attach(screenshot, "image/png", scenario.getName());
        this.driver.quit();
    }

}
