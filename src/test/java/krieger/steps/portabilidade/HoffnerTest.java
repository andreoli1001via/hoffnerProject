package krieger.steps.portabilidade;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        tags = "@HoffnerScenario02",
        glue = {"/krieger/steps/portabilidade"},
        monochrome = true, dryRun = false,
        plugin = {"pretty", "com.epam.reportportal.cucumber.StepReporter", "html:target/cucumber"})
public class HoffnerTest {
    public HoffnerTest() {
    }
}
