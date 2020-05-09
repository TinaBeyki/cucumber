package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "Features/Cucumber.feature",
        glue = "stepDefinition",
        strict = true)
public class TestRunner {

}
