package runner;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
                 features = {"/Users/kikumar/Documents/BDD/AbhibusBDD/src/test/resources/features/DeveloperSiteNavigation.feature"},
                 glue = {"stepdefinitions"},
                 plugin = {"html:target/cucumber-reports"},
                 tags = {"@ui_navigation"})
public class MainRunner {
}
