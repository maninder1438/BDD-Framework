package com.mani.selenium;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",    //feature files path
        dryRun = true,                     //check the complete implementation of all the mentioned steps present in the Feature file. Before the execution starts . Dry Run is Checking the implementionation not about the execution  of scripts.
        strict = true,                     // if Strict option is set to true then at execution time if cucumber encounters any undefined/pending steps then cucumber does fails the execution and undefined steps are marked as fail and BUILD is FAILURE.
        plugin = {"json:target/cucumber.json"}  //it is used to create reports, here we supply the the path of json file

)
public class RunCucumberTest {
}

