package runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "step_definitions",
        tags = "@Smoke",
        plugin= {"pretty","html:target/site/cucumber-pretty.html", "html:html-report/report.html", "json:target/cucumber.json"}
)

public class SmokeRunner {
}