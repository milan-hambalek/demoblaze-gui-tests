package com.actum.interview.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;


@CucumberOptions(
        tags = "",
        features = {
                "src/test/resources/features/signup.feature",
                "src/test/resources/features/login.feature"

        },
        glue = {
                "com.actum.interview.definitions"
        },
        plugin = {})
public class TestNGCucumberRunnerTest extends AbstractTestNGCucumberTests {

}
