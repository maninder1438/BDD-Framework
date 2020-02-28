package com.mani.selenium.pages;

import com.mani.selenium.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductDescriptionPage extends DriverManager {

    @FindBy(css = "button[data-test='component-att-button']")
    private WebElement addToTrolleyButton;

    @FindBy(css = "button[data-test=\"component-att-button-continue\"]")
    private WebElement continueShoppingButton;

    @FindBy(css = ".xs-row a[data-test='component-att-button-basket']")
    private WebElement goToTrolleyButton;

    @FindBy(css = "select[id=\"add-to-trolley-quantity\"]")
    private WebElement selectQuantityButton;

    @FindBy(css = "li.price.product-price-primary h2")
    private WebElement priceOfProduct;

    public void addToTrolley() {sleep(4000);addToTrolleyButton.click();}

    public void continueShopping() {sleep(4000);continueShoppingButton.click();}

    public void goToTrolley() {sleep(4000);goToTrolleyButton.click();}

    public String quantityToSelect(String qty) {
        sleep(3000);
        new Select(selectQuantityButton).selectByVisibleText(qty);
        return qty;
    }
    
    public Double productPrice()  {
        sleep(4000);
       Double price = Double.parseDouble(priceOfProduct.getText().replace("£", ""));
        return price;
    }
}
