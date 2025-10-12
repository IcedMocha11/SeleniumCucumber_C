package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@CucumberOptions(features = {"src/test/java/features/"},
                 glue = {"stepDefinitions", "utilities"},
                 //tags = "@Test2",
                 plugin = {"pretty",
                           "html:target/cucumber-reports.html",
                           "json:target/cucumber.json"},
                 monochrome = true
        )

public class TestRunner extends AbstractTestNGCucumberTests {


    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        super.runScenario(pickleWrapper, featureWrapper);
    }
    //Todo: try to research what is the purpose of thiss




}
//Note; Nasa #32 course content ka na sa course ni  Gianni Bruno
//Note: example on how to run in terminal: mvn clean test -D "cucumber.options=--tags @INGFrameworkDemo" -D "env=ing"