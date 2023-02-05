package com.actum.interview.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        tags = "",
        features = {
                "src/test/resources/features/signup.feature",
                "src/test/resources/features/login.feature",
                "src/test/resources/features/categories.feature",
                "src/test/resources/features/cart.feature"
        },
        glue = {
                "com.actum.interview.definitions"
        },
        plugin = {"html:target/cucumber/report.html", "json:target/cucumber/report.json"})

public class TestNGCucumberRunnerTest extends AbstractTestNGCucumberTests {

}
