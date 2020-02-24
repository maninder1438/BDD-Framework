package com.mani.selenium.pages;

import com.mani.selenium.driver.DriverFactory;
import com.mani.selenium.utils.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ResultsPage extends DriverFactory {

    public String getSearchTitle() {return driver.findElement(By.cssSelector(".search-title h1")).getText().toLowerCase(); }

    public List<String> getAllProductNames() {
        List<String> productNamesList = new ArrayList<>();
        List<WebElement> productWebElements = productNameList();
        for (WebElement indProduct : productWebElements) {
            String actual = indProduct.getText();
            productNamesList.add(actual);
        }
        return productNamesList;
    }

    public List<String> getAllProductRatings() {
        List<String> productRatingList = new ArrayList<>();
        List<WebElement> productWebElements = productRatingList();
        for (WebElement indProduct : productWebElements) {
            String currentRating = indProduct.getAttribute("data-star-rating");
            productRatingList.add(currentRating);
        }
        return productRatingList;
    }

    public List<Double> getAllProductPrices() {
        List<Double> productPriceList = new ArrayList<>();
        List<WebElement> productWebElementsPrice = productPriceList();
        for (WebElement indProductPrice : productWebElementsPrice) {
            double actual = Double.parseDouble(indProductPrice.getText().replace("£",""));
            productPriceList.add(actual);
        }
        return productPriceList;
    }

    public String selectAnyProduct() {
        List<WebElement> productWebElements = productNameList();
        int productSize = productWebElements.size();
        int randomNumber = new Helpers().randomNumberGenerator(productSize);
        WebElement selectedElement = productWebElements.get(randomNumber);
        String selectedProductName = selectedElement.getText();
        selectedElement.click();
        return selectedProductName;
    }

    private List<WebElement> productNameList() {
        List<WebElement> productWebElements = driver.findElements(By.cssSelector("a[data-test='component-product-card-title']"));
        return productWebElements;
    }

    private List<WebElement> productRatingList() {
        List<WebElement> productWebElements = driver.findElements(By.cssSelector("div[data-test=\"component-ratings\"]"));
        return productWebElements;
    }
    private List<WebElement> productPriceList() {
        List<WebElement> productWebElements = driver.findElements(By.cssSelector(".ProductCardstyles__PriceText-l8f8q8-14.gHrEdF"));
        return productWebElements;
    }
    public String selectProductRatingFilter(String selectRating) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("div[data-facet=\"customer rating\"]")).click();
        Thread.sleep(4000);
       try {
           driver.findElement(By.cssSelector("label[data-e2e^=\"" + selectRating + "\"]")).click();
       }
       catch(Exception ex){
           throw new RuntimeException("No Product Found with Rating " + selectRating);
       }
        return selectRating;
    }

    public String selectPriceFilter(String selectPrice) throws InterruptedException {
         Thread.sleep(4000);
        try {
            driver.findElement(By.cssSelector("label[data-filter-id=\"" + selectPrice + "\"]")).click();
        }
        catch(Exception ex){
            throw new RuntimeException("No Product Found with selected Price Filter " + selectPrice);
        }
        return selectPrice;
    }
}
