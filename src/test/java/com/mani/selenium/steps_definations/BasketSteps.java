package com.mani.selenium.steps_definations;

import com.mani.selenium.pages.HomePage;
import com.mani.selenium.pages.ProductDescriptionPage;
import com.mani.selenium.pages.ResultsPage;
import com.mani.selenium.pages.TrolleyPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BasketSteps {

    private HomePage homePage = new HomePage();
    private ResultsPage resultsPage = new ResultsPage();
    private ProductDescriptionPage productDescriptionPage = new ProductDescriptionPage();
    private TrolleyPage trolleyPage = new TrolleyPage();

    private String actualProduct;

    @And("^Select the random product from product list$")
    public void selectTheRandomProductFromProductList() {
        actualProduct = resultsPage.selectAnyProduct();
    }

    @And("^Add the selected product to basket$")
    public void AddTheSelectedProductToBasket() {

        productDescriptionPage.addToTrolley();
        productDescriptionPage.goToTrolley();
    }

    @Then("^I should be able to see the same selected product in the basket$")
    public void iShouldBeAbleToSeeTheSameSelectedProductInTheBasket() {

        String expected = trolleyPage.getProductNameInTrolley();
        assertThat(expected, is(equalToIgnoringCase(actualProduct)));
    }

    private String totalPriceOfSelectedProducts;

    @And("^change the quantity to \"([^\"]*)\"$")
    public void changeTheQuantityTo(String qty) {
        double qtySelected = Double.parseDouble(productDescriptionPage.quantityToSelect(qty));
        double selectedProductPrice = productDescriptionPage.productPrice();
        totalPriceOfSelectedProducts = String.format("%.2f", selectedProductPrice * qtySelected);
    }

    @Then("^I should be able to see the correct price in the basket$")
    public void iShouldBeAbleToSeeTheCorrectPriceInTheBasket() {
        String totalPriceOfBasketProducts = trolleyPage.getProductPriceInTrolley();
        assertThat(totalPriceOfSelectedProducts, is(equalToIgnoringCase(totalPriceOfBasketProducts)));
    }

    private double selectedProductPrice1;

    @And("^add the selected product to basket and click continue shopping$")
    public void addTheSelectedProductToBasketAndClickContinueShopping() {
        selectedProductPrice1 = productDescriptionPage.productPrice();
        productDescriptionPage.addToTrolley();
        productDescriptionPage.continueShopping();
    }

    private double selectedProductPrice2;

    @And("^add the selected product to basket and click goto trolley$")
    public void addTheSelectedProductToBasketAndClickGotoTrolley() {
        selectedProductPrice2 = productDescriptionPage.productPrice();
        productDescriptionPage.addToTrolley();
        productDescriptionPage.goToTrolley();
    }

    @Then("^I should be able to see \"([^\"]*)\" products in total in the basket$")
    public void iShouldBeAbleToSeeProductsInTotalInTheBasket(byte qty) {
        int numberOfProductsInBasket = trolleyPage.numberOfProductsinTrolley();
        assertEquals(qty, numberOfProductsInBasket);
    }

    @And("^The price should be equal to the total of products in the basket$")
    public void thePriceShouldBeEqualToTheTotalOfProductsInTheBasket() {
        String subTotalActual = String.format("%.2f", selectedProductPrice1 + selectedProductPrice2);
        String subTotalExpected = trolleyPage.trolleyTotalProductPrice();
        assertThat(subTotalActual, is(equalToIgnoringCase(subTotalExpected)));
    }

    @And("^Reserve the item to collect from store$")
    public void reserveTheItemToCollectFromStore() {
        trolleyPage.enterPostcodeForProductAvailability();
        trolleyPage.collectionButton();
        trolleyPage.selectThisStore();
        trolleyPage.continueWithCollection();
        trolleyPage.reserveAndPayInStore();
        trolleyPage.reserveDetailsEmail();
        trolleyPage.reserveContinueButton();
        trolleyPage.reserveNowButton();
    }

    @Then("^I should be able to see the reservation confirmation$")
    public void iShouldBeAbleToSeeTheReservationConfirmation() {
        assertTrue(trolleyPage.getReservationConfirmationMsg().equalsIgnoreCase("Your reservation is complete")
                || trolleyPage.getReservationConfirmationMsg().equalsIgnoreCase("Your reservation is ready to collect"));
    }

    @And("^The selected quantity should be \"([^\"]*)\" on reservation confirmation$")
    public void theSelectedQuantityShouldBeOnReservationConfirmation(String qty) {
        assertThat(trolleyPage.getQuantityOfReservedProdcuts(), is(equalToIgnoringCase(qty)));
    }

    @And("^The total price should be correct$")
    public void theTotalPriceShouldBeCorrect() {
        assertThat(trolleyPage.getTotalPriceOfReservedProducts(), is(equalToIgnoringCase(totalPriceOfSelectedProducts)));
    }

    @And("^Verify that selected product has brand name\"([^\"]*)\"$")
    public void verifyThatSelectedProductHasBrandName(String actualBrandName) {
        String expectedBrandName = productDescriptionPage.getProductDescriptionText();

        assertThat(expectedBrandName, containsString(actualBrandName.toLowerCase()));
    }

    @And("^Verify that selected product has rating\"([^\"]*)\" or more$")
    public void verifyThatSelectedProductHasRatingOrMore(double actualRating) {
        double expectedRating = productDescriptionPage.getProductRating();
        assertThat(expectedRating, is(greaterThanOrEqualTo(actualRating)));
    }
}