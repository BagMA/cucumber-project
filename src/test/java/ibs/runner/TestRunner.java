package ibs.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@all",
        glue = "ibs/steps",
        features = "src/test/java/resources",
        plugin = {"io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm", "pretty"}
)
public class TestRunner {
}
