package com.selenium.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "classpath:features/",
        glue = {"com.selenium"},
        plugin = {"pretty", "json:target/cucumber-reports/Run_sample.json", "html: target/cucumber-reports/" },
        tags = "@Sample"
)

public class commonRunner {
}
