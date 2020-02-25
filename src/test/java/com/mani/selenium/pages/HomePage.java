package com.mani.selenium.pages;

import com.mani.selenium.driver.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends DriverManager {

    @FindBy(css = "input[data-test='search-input']")
    private WebElement searchBox;

    @FindBy(css = "a[data-test='component-product-card-title']")
    private List<WebElement> searchedProduct;

    public void doSearch(String searchTerm)  {
        searchBox.sendKeys(searchTerm);
        searchBox.sendKeys(Keys.ENTER);

        if (searchedProduct.size()==0)
        {
            throw new RuntimeException("Sorry, we couldn't find any products with the term " + searchTerm);
        }
    }
    
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
