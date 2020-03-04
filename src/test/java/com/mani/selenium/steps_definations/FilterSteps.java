package com.mani.selenium.steps_definations;

import com.mani.selenium.pages.ResultsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FilterSteps {
    ResultsPage resultsPage = new ResultsPage();

    @And("^Select the product rating \"([^\"]*)\" from the rating filter$")
    public void selectTheProductRatingFromTheRatingFilter(String rating) {
        resultsPage.selectProductRatingFilter(rating);
    }

    @Then("^I should be able to see the products of rating \"([^\"]*)\"$")
    public void iShouldBeAbleToSeeTheProductsOfRating(double expected) {
        List<Double> actualRatingList = resultsPage.getAllProductRatings();
        assertThat(actualRatingList, everyItem(is(greaterThanOrEqualTo(expected))));
    }

    @And("^Select the brand name \"([^\"]*)\" from the brands filter$")
    public void selectTheBrandNameFromTheBrandsFilter(String brandName) {
        resultsPage.selectBrandFilter(brandName);
    }

    @Then("^I should be able to see \"([^\"]*)\" brand products only$")
    public void iShouldBeAbleToSeeBrandProductsOnly(String brandName) {
        List<String> allProductNames = resultsPage.getAllProductNames();
        for (String item : allProductNames) {
            assertThat(item.toLowerCase(), containsString(brandName));
        }
    }
}

