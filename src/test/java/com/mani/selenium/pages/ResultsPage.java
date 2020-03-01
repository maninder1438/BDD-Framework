package com.mani.selenium.pages;

import com.mani.selenium.driver.DriverManager;
import com.mani.selenium.utils.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ResultsPage extends DriverManager {
    @FindBy(css = ".search-title h1")
    private WebElement searchTitle;

    @FindBy(css = "a[data-test='component-product-card-title']")
    private List<WebElement> productNameList;

    @FindBy(css = "div[data-test='component-ratings']")
    private List<WebElement> ratingStar;

    @FindBy(css = ".findability-facet__rating-label")
    private List<WebElement> ratingWebElements;

    @FindBy(css = "div[data-facet='customer rating']")
    private WebElement customerRatingDropdown;

    @FindBy(css = ".ProductCardstyles__PriceText-l8f8q8-14.gHrEdF")
    private List<WebElement> productPrice;

    @FindBy(css = "label[name='price']")
    private List<WebElement> priceFilter;

    @FindBy(css = "div[data-facet='price']> button.Accordionstyles__ButtonLink-pegw6j-3.bRQRVq")
    private WebElement priceFilterShowMore;

    @FindBy(css = "div[data-facet='brands']> button.Accordionstyles__ButtonLink-pegw6j-3.bRQRVq")
    private WebElement brandFilterShowMore;

    @FindBy(css = "label[name='brands']")
    private List<WebElement> brandFilter;

    public String getSearchTitle() {
        return searchTitle.getText().toLowerCase();
    }

    public List<String> getAllProductNames() {
        escapeKey();
        List<String> productNamesList = new ArrayList<>();
        for (WebElement indProduct : productNameList) {
            String actual = indProduct.getText();
            productNamesList.add(actual);
        }
        return productNamesList;
    }

    public List<Double> getAllProductRatings() {
        sleep(5000);
        escapeKey();
        List<Double> productRatingList = new ArrayList<>();
        for (WebElement rating : ratingStar) {
            String currentRatingInString = rating.getAttribute("data-star-rating");
            Double currentRatingInDouble = Double.parseDouble(currentRatingInString);
            productRatingList.add(currentRatingInDouble);
        }
        return productRatingList;
    }

    public List<Double> getAllProductPrices() {
        escapeKey();
        List<Double> productPriceList = new ArrayList<>();
        for (WebElement indProductPrice : productPrice) {
            double actual = Double.parseDouble(indProductPrice.getText().replace("£", ""));
            productPriceList.add(actual);
        }
        return productPriceList;
    }

    public String selectAnyProduct() {
        sleep(4000);
        escapeKey();
        int productSize = productNameList.size();
        int randomNumber = new Helpers().randomNumberGenerator(productSize);
        WebElement selectedElement = productNameList.get(randomNumber);
        String selectedProductName = selectedElement.getText();
        selectedElement.click();
        return selectedProductName;
    }

    public void selectProductRatingFilter(String selectRating) {
//        new WebDriverWait(driver, 10)
//                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".findability-facet__rating-label"), 5));
        sleep(3000);
        escapeKey();
        customerRatingDropdown.click();
        sleep(2000);
        for (WebElement review : ratingWebElements) {
            String availableFilter = review.getText();
            if (availableFilter.equalsIgnoreCase(selectRating)) {
                review.click();
                break;
            }
        }
    }

    public void selectPriceFilter(String selectPrice) {
        /**below explicit is not working**/
//        new WebDriverWait(driver, 10)
//                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("label[name=\"price\"]"), 4));
        /**need to ask how to run this faster**/
        sleep(2000);
        escapeKey();
        if (priceFilter.size() == 0) {
            throw new RuntimeException("Sorry, no product available with price " + priceFilter);
        }
        try {
            if (priceFilterShowMore.isDisplayed()) {
                priceFilterShowMore.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
           for (WebElement review : priceFilter) {
            String availableFilter = review.getAttribute("value");
            if (availableFilter.equalsIgnoreCase(selectPrice)) {
                review.click();
                break;
            }
        }
    }

    public void selectBrandFilter(String selectBrand) {
//        new WebDriverWait(driver, 10)
//                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".findability-facet__rating-label"), 5));
        sleep(4000);
        escapeKey();
        try {
            if (brandFilterShowMore.isDisplayed()) {
                brandFilterShowMore.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (WebElement review : brandFilter) {
            String availableFilter = review.getAttribute("value");
            if (availableFilter.equalsIgnoreCase(selectBrand)) {
                review.click();
                 break;
            }
        }
    }
}



