package org.nutrien.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/java/org/nutrien/feature",
        glue = "org.nutrien.stepdefs",
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json"
        },
        tags = "@BASIC_AUTH"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}