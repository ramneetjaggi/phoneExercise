package com.cisco.phone.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/UpdateUserInfo.feature",
        glue = "com.cisco.phone.cucumber")
public class TestCucumber {
}
