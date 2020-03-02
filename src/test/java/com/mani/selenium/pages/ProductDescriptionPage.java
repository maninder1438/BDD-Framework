package com.mani.selenium.pages;

import com.mani.selenium.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductDescriptionPage extends DriverManager {

    @FindBy(css = "button[data-test='component-att-button']")
    private WebElement addToTrolleyButton;

    @FindBy(css = "button[data-test='component-att-button-continue']")
    private WebElement continueShoppingButton;

    @FindBy(css = ".xs-row a[data-test='component-att-button-basket']")
    private WebElement goToTrolleyButton;

    @FindBy(css = "select[id='add-to-trolley-quantity']")
    private WebElement selectQuantityButton;

    @FindBy(css = "li.price.product-price-primary h2")
    private WebElement priceOfProduct;

    @FindBy (css = "div[data-test='heading-ratings']")
    private WebElement ratingOfProduct;

    @FindBy(css = ".product-description-content-text")
    private WebElement productDescriptionText;

    public void addToTrolley() {sleep(2000);addToTrolleyButton.click();}

    public void continueShopping() {sleep(3000);continueShoppingButton.click();}

    public void goToTrolley() {sleep(3000);goToTrolleyButton.click();}

    public String quantityToSelect(String qty) {
        new Select(selectQuantityButton).selectByVisibleText(qty);
        return qty;
    }
    public Double productPrice()  {
         Double price = Double.parseDouble(priceOfProduct.getText().replace("£", ""));
        return price;
    }
    public Double getProductRating(){
         Double rating = Double.parseDouble(ratingOfProduct.getAttribute("data-star-rating"));
        return rating;
    }
    public String getProductDescriptionText(){
           return productDescriptionText.getText().toLowerCase();
    }
}
