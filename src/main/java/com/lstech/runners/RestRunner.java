package com.lstech.runners;

import io.cucumber.core.snippets.SnippetType;
import io.cucumber.junit.CucumberOptions;
import suport.CustomTestNGCucumberTestRest;

@CucumberOptions(features = "classpath:features",
        tags = {"@rest"},
        plugin = {"json:target/cucumber-report/cucumber.json"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE
)

public class RestRunner extends CustomTestNGCucumberTestRest {
}
