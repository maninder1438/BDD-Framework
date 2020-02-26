package com.mani.selenium.pages;

import com.mani.selenium.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TrolleyPage extends DriverManager {

    @FindBy(css = ".ProductCard__content__9U9b1.xsHidden.lgFlex .ProductCard__titleLink__1PgaZ")
    private WebElement nameInTrolley;

    @FindBy(css = ".ProductCard__productLinePrice__3QC7V")
    private WebElement priceInTrolley;

    @FindBy(css = ".ProductCard__productLinePrice__3QC7V")
    private List <WebElement> numberOfProductsInTrolley;

    @FindBy(css = "div[data-e2e=\"basket-total-price\"]")
    private WebElement trollyTotalPrice;


    public String getProductNameInTrolley() {
         return nameInTrolley.getText();
    }

    public String getProductPriceInTrolley() {
        return priceInTrolley.getText();
    }

    public int numberOfProductsinTrolley() {
        int numberOfProductsInBasket = numberOfProductsInTrolley.size();
        return numberOfProductsInBasket;
    }
    public String trolleyTotalProductPrice() {
        String trolleyTotal = trollyTotalPrice.getText().replace("£", "").replace(",", "");
        return trolleyTotal;
    }
}
