package com.mani.selenium.steps_definations;

import com.mani.selenium.pages.HomePage;
import com.mani.selenium.pages.ResultsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

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
    public void iShouldBeAbleToSeeTheProductsOfRating(double expected) throws Throwable {
        List<Double> actualRatingList = resultsPage.getAllProductRatings();
        assertThat(actualRatingList, everyItem(is(greaterThanOrEqualTo(expected))));
    }

    @And("^Select the price \"([^\"]*)\" from price filter$")
    public void selectThePriceFromPriceFilter(String price)  {
        resultsPage.selectPriceFilter(price);

    }

    @Then("^I should be able to see the products having price between \"([^\"]*)\"$")
    public void iShouldBeAbleToSeeTheProductsHavingPriceBetween(String priceRange)  {

        List<Double> expectedPriceList = resultsPage.getAllProductPrices();

        String[] selectedPrice = priceRange.replace("£","").split("-");
        double minValuePriceFilter = Double.parseDouble(selectedPrice[0]);
        double maxValuePriceFilter = Double.parseDouble(selectedPrice[1].trim());

        for (double indPrice : expectedPriceList) {
            assertThat(indPrice,is(greaterThanOrEqualTo(minValuePriceFilter)));
            assertThat(indPrice,is(lessThan(maxValuePriceFilter)));
           }
    }


}
