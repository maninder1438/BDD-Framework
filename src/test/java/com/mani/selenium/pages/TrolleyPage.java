package com.mani.selenium.pages;

import com.mani.selenium.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class TrolleyPage extends DriverManager {

    @FindBy(css = ".ProductCard__content__9U9b1.xsHidden.lgFlex .ProductCard__titleLink__1PgaZ")
    private WebElement nameInTrolley;

    @FindBy(css = ".ProductCard__productLinePrice__3QC7V")
    private WebElement priceInTrolley;

    @FindBy(css = ".ProductCard__productLinePrice__3QC7V")
    private List<WebElement> numberOfProductsInTrolley;

    @FindBy(css = "div[data-e2e='basket-total-price']")
    private WebElement trollyTotalPrice;

    @FindBy(css = ".xs-hidden #basket-FulfilmentSelectorForm")
    private WebElement enterPostcodeForProductAvailability;

    @FindBy(css = ".xs-hidden #basket-FulfilmentSelectorForm-collectButton")
    private WebElement collectionButton;

    @FindBy(css = "button[data-el^='store-selector-result__select-store-button']")
    private List<WebElement> selectThisStoreButton;

    @FindBy(css = "button[data-e2e=\"continue-with-collection-button\"]")
    private WebElement continueWithCollectionButton;

    @FindBy(css = "a[data-test='pay-in-store-button']")
    private WebElement reserveAndPayInStoreButton;

    @FindBy(css = "input[name='reserveDetails.email']")
    private WebElement reserveDetailsEmail;

    @FindBy(css = "button[data-test='reserve-continue-button']")
    private WebElement reserveContinueButton;

    @FindBy(css = ".HeaderContent__basket__3dSvK > span")
    private WebElement checkQtyAndPrice;

    @FindBy(css = "button[data-test='reserve-now-button']")
    private WebElement reseerveNowButton;

    public String getProductNameInTrolley() {
        sleep(3000);
        return nameInTrolley.getText();
    }

    public String getProductPriceInTrolley() {
        return priceInTrolley.getText().replace("£", "");
    }

    public int numberOfProductsinTrolley() {
        int numberOfProductsInBasket = numberOfProductsInTrolley.size();
        sleep(3000);
        return numberOfProductsInBasket;
    }

    public String trolleyTotalProductPrice() {
        String trolleyTotal = trollyTotalPrice.getText().replace("£", "").replace(",", "");
        return trolleyTotal;
    }

    public void enterPostcodeForProductAvailability() {
        enterPostcodeForProductAvailability.sendKeys("london");
    }

    public void collectionButton() {
        collectionButton.click();
    }

    public void selectThisStore() {
        sleep(2000);
        selectThisStoreButton.get(0).click();
    }

    public void continueWithCollection() {
        continueWithCollectionButton.click();
    }

    public void reserveAndPayInStore() {
        reserveAndPayInStoreButton.click();
    }

    public void reserveDetailsEmail() {
        reserveDetailsEmail.sendKeys("demo@gmail.com");
    }

    public void reserveContinueButton() {
        reserveContinueButton.click();
    }

    public String getReserverNowButtonText() {
        return reseerveNowButton.getText();
    }

    public String getQtyFromReservationPage() {
        return checkQtyAndPrice.getText().substring(7, 8);
    }

    public String getPriceFromReservationPage() {
        return checkQtyAndPrice.getText().substring(12, 17);
    }
}
