package com.actum.interview.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        tags = "",
        features = {

        },
        glue = {
                "com.actum.interview.definitions"
        },
        plugin = {})
public class TestNGCucumberRunnerTest extends AbstractTestNGCucumberTests {

}
