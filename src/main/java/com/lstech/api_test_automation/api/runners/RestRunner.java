package com.lstech.api_test_automation.api.runners;

import io.cucumber.testng.CucumberOptions;
import suport.CustomTestNGCucumberTestRest;

@CucumberOptions(
        features = "classpath:features",
        tags = "@rest",
        plugin = {
                "pretty",
                "json:target/cucumber-report/cucumber.json"
        },
        monochrome = true
)
public class RestRunner extends CustomTestNGCucumberTestRest {
}