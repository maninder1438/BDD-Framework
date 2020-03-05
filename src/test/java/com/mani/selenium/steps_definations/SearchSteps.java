package com.mani.selenium.steps_definations;

import com.mani.selenium.pages.ResultsPage;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SearchSteps {

    private ResultsPage resultsPage = new ResultsPage();

    @Then("^I should be able to see \"([^\"]*)\" product$")
    public void iShouldBeAbleToSeeProduct(String term) {
        List<String> allProductNames = resultsPage.getAllProductNames();
        Assert.assertTrue(resultsPage.getSearchTitle().contains(term));
        for (String item : allProductNames) {assertThat(item.toLowerCase(), containsString(term));}
    }
}