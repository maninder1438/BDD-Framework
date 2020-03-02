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
    private List <WebElement> numberOfProductsInTrolley;

    @FindBy(css = "div[data-e2e='basket-total-price']")
    private WebElement trollyTotalPrice;

    @FindBy (css = ".xs-hidden #basket-FulfilmentSelectorForm")
    private WebElement enterPostcodeForProductAvailability;

    @FindBy (css = ".xs-hidden #basket-FulfilmentSelectorForm-collectButton")
    private WebElement collectionButton;

<<<<<<< HEAD
    @FindBy (css = "button[data-el^='store-selector-result__select-store-button']")
    private  List<WebElement> selectThisStoreButton;
=======
    @FindBy (css = "button[data-el='store-selector-result__select-store-button--4215']")
    private  WebElement selectThisStoreButton;
>>>>>>> master

    @FindBy (css = ".Buttonstyles__Button-q93iwm-2.EhVk > .FulfilmentConfirmationForm__extendedText__2t8LV")
    private WebElement continueWithCollectionButton;

    @FindBy (css = "a[data-test='pay-in-store-button']")
    private WebElement reserveAndPayInStoreButton;

    @FindBy (css = "input[name='reserveDetails.email']")
    private WebElement reserveDetailsEmail;

    @FindBy (css = "button[data-test='reserve-continue-button']")
    private WebElement reserveContinueButton;

    @FindBy (css = "button[data-test='reserve-now-button']")
    private WebElement reserveNowButton;

    @FindBy (css = "h1[data-test='reservation-confirmation-message']")
    private WebElement reservationConfirmationMsg;

    @FindBy (css = "span[data-e2e='product-quantity']")
    private WebElement quantityReserved;

    @FindBy (css = "div[data-test='basket-total']")
    private WebElement priceOfReservedProducts;

    public String getProductNameInTrolley() {
        sleep(4000);
        escapeKey();
         return nameInTrolley.getText();
    }

    public String getProductPriceInTrolley() {
        sleep(4000);
        escapeKey();
        return priceInTrolley.getText().replace("£", "");
    }

    public int numberOfProductsinTrolley() {
        escapeKey();
        int numberOfProductsInBasket = numberOfProductsInTrolley.size();
        sleep(4000);
        return numberOfProductsInBasket;
    }
    
    public String trolleyTotalProductPrice() {
        escapeKey();String trolleyTotal = trollyTotalPrice.getText().replace("£", "").replace(",", "");
        return trolleyTotal;
    }
    public void enterPostcodeForProductAvailability(){
<<<<<<< HEAD
       escapeKey(); enterPostcodeForProductAvailability.sendKeys("ealing");    }
    public void collectionButton(){collectionButton.click(); }
    public void selectThisStore(){escapeKey();selectThisStoreButton.get(0).click(); }
    public void continueWithCollection(){escapeKey();continueWithCollectionButton.click(); }
    public void reserveAndPayInStore(){escapeKey();reserveAndPayInStoreButton.click();  }
    public void reserveDetailsEmail(){escapeKey();reserveDetailsEmail.sendKeys("check@gmail.com");}
=======
        enterPostcodeForProductAvailability.sendKeys("TW5 0PB");
    }
    public void collectionButton(){
        collectionButton.click();
    }
    public void selectThisStore(){
        selectThisStoreButton.click();
    }
    public void continueWithCollection(){
        continueWithCollectionButton.click();
    }
    public void reserveAndPayInStore(){
        reserveAndPayInStoreButton.click();
    }
    public void reserveDetailsEmail(){
        reserveDetailsEmail.sendKeys("demo@gmail.com");
    }
>>>>>>> master
    public void reserveContinueButton(){
        reserveContinueButton.click();
    }
    public void reserveNowButton(){
        reserveNowButton.click();
    }
    public String getReservationConfirmationMsg(){
        String msg= reservationConfirmationMsg.getText();
        sleep(8000);
        return msg;
    }
    public String getQuantityOfReservedProdcuts(){
        String numberOfReservedProducts = quantityReserved.getText();
<<<<<<< HEAD
        sleep(4000);
=======
        sleep(3000);
>>>>>>> master
        return numberOfReservedProducts;
    }
    public String getTotalPriceOfReservedProducts(){
        String trolleyTotal = priceOfReservedProducts.getText().replace("£", "").replace(",", "");
        return trolleyTotal;
    }

}
