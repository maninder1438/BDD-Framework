package com.mani.selenium.pages;

import com.mani.selenium.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ProductDescriptionPage extends DriverManager {

    public void addToTrolley() throws InterruptedException {
        Thread.sleep(2500);
        driver.findElement(By.cssSelector("button[data-test='component-att-button']")).click();
    }

    public void continueShopping() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("button[data-test=\"component-att-button-continue\"]")).click();
    }

    public void goToTrolley() throws InterruptedException {
        Thread.sleep(6000);
        driver.findElement(By.cssSelector(".xs-row a[data-test='component-att-button-basket']")).click();
    }

    public String quantityToSelect(String qty) throws InterruptedException {
        Thread.sleep(2000);
        new Select(driver.findElement(By.cssSelector("select[id=\"add-to-trolley-quantity\"]"))).selectByVisibleText(qty);
        return qty;
    }

    public String productPrice() throws InterruptedException {
        Thread.sleep(4000);
        String price = driver.findElement(By.cssSelector("li.price.product-price-primary h2")).getText().replace("£", "");
        return price;
    }
}
