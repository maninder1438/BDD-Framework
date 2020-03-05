package com.mani.selenium.steps_definations;

import com.mani.selenium.pages.ResultsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PriceSteps {
    private ResultsPage resultsPage = new ResultsPage();

    @And("^Select the price \"([^\"]*)\" from price filter$")
    public void selectThePriceFromPriceFilter(String price) {
        resultsPage.selectPriceFilter(price);
    }

    @Then("^I should be able to see the products having price between \"([^\"]*)\"$")
    public void iShouldBeAbleToSeeTheProductsHavingPriceBetween(String priceRange) {

        List<Double> expectedPriceList = resultsPage.getAllProductPrices();

        String[] selectedPrice = priceRange.replace("£", "").split("-");
        double minValuePriceFilter = Double.parseDouble(selectedPrice[0]);
        double maxValuePriceFilter = Double.parseDouble(selectedPrice[1].trim());

        for (double indPrice : expectedPriceList) {
            assertThat(indPrice,both(is(greaterThanOrEqualTo(minValuePriceFilter))).and(is(lessThan(maxValuePriceFilter))));

        }
    }

}
