package com.mani.selenium.pages;

import com.mani.selenium.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void addToTrolley() {sleep(4000);escapeKey();addToTrolleyButton.click();}

    public void continueShopping() {sleep(5000);continueShoppingButton.click();}

    public void goToTrolley() {sleep(5000);goToTrolleyButton.click();}

    public String quantityToSelect(String qty) {
        escapeKey();
        sleep(2000);
        new WebDriverWait(driver, 60)
             .until(ExpectedConditions.elementToBeClickable(By.cssSelector("select[id='add-to-trolley-quantity']")));

        new Select(selectQuantityButton).selectByVisibleText(qty);
        return qty;
    }
    public Double productPrice()  {
        sleep(2000);
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
