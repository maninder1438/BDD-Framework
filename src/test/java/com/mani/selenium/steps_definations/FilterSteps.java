package com.mani.selenium.steps_definations;

import com.mani.selenium.pages.ResultsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class FilterSteps {
    ResultsPage resultsPage = new ResultsPage();

    private String selectedRating;
    @And("^Select the product rating \"([^\"]*)\" from the rating filter$")
    public void selectTheProductRatingFromTheRatingFilter(String rating) throws InterruptedException {
        selectedRating = resultsPage.selectProductRatingFilter(rating);
        Thread.sleep(5000);
    }

    @Then("^I should be able to see the products of selected rating only$")
    public void iShouldBeAbleToSeeTheProductsOfSelectedRatingOnly() {
        List<String> actualRatingList = resultsPage.getAllProductRatings();
        for (String indRating : actualRatingList) {
            assertTrue("Current Products have different Rating ", Double.parseDouble(indRating) >= Double.parseDouble(selectedRating));
        }
    }

    @And("^Select the price \"([^\"]*)\" from price filter$")
    public void selectThePriceFromPriceFilter(String price) throws InterruptedException {
        resultsPage.selectPriceFilter(price);
        Thread.sleep(5000);
    }

    @Then("^I should be able to see the products having price between \"([^\"]*)\"$")
    public void iShouldBeAbleToSeeTheProductsHavingPriceBetween(String priceRange)  {
        List<Double> expectedPriceList = resultsPage.getAllProductPrices();

        String[] selectedPrice = priceRange.replace("£","").split("-");
        double minValuePriceFilter = Double.parseDouble(selectedPrice[0]);
        double maxValuePriceFilter = Double.parseDouble(selectedPrice[1].trim());

        for (double indPrice : expectedPriceList) {
            assertTrue(indPrice>=minValuePriceFilter);
            assertTrue(indPrice<maxValuePriceFilter);
            System.out.println(indPrice);
        }
    }
}
