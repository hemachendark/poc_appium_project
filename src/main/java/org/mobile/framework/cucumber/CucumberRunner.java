package org.mobile.framework.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"org.mobile.framework.StepDefinations;"},
        features = {"src/test/resources/features"},
        dryRun = false,
        plugin = {
                "pretty",
                "html:target/cucumber.html",
                "junit:target/junitreports.xml",
                "html:target/site/cucumber-pretty",
                "json:target/cucumber/cucumber.json"
        },

        monochrome = false

)
public class CucumberRunner {
}
