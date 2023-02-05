package com.actum.interview.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        tags = "",
        features = {
                "src/test/resources/features/signup.feature",
                "src/test/resources/features/login.feature",
                "src/test/resources/features/categories.feature"
        },
        glue = {
                "com.actum.interview.definitions"
        },
        plugin = {})
public class TestNGCucumberRunnerTest extends AbstractTestNGCucumberTests {

}
