package com.mani.selenium.pages;

import com.mani.selenium.driver.DriverFactory;
import org.openqa.selenium.By;

public class LoginPage extends DriverFactory {

    public String accountLoginPage() {
        driver.findElement(By.cssSelector("a[data-test=\"account\"]")).click();
        String url = driver.getCurrentUrl();
        return url;
    }

    public String accountLoginPageMessage(){
        String message = driver.findElement(By.cssSelector(".panel-header h2")).getText();
        return message;
    }
    public String accountLoggedInMessage(){
        String message = driver.findElement(By.cssSelector(".Title__container__2arEZ >p")).getText();
        return message;
    }
    public String enterEmailAddress(String email){
        driver.findElement(By.cssSelector("#email-address")).sendKeys(email);
        return email;
    }
    public String enterPassword(String password){
        driver.findElement(By.cssSelector("#current-password")).sendKeys(password);
        return password;
    }
    public void signInSecurely() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[data-bdd-test-id=\"yourEmailSubmitButton\"]")).click();
    }
    public String getFirstNameAfterLogin() throws InterruptedException {
        Thread.sleep(4000);
        String firstName = driver.findElement(By.cssSelector("span[class=\"_2WxI4\"]")).getText();
        return firstName;
    }
    public String signOutButton(){
        String signOut = driver.findElement(By.cssSelector(".Bh-zw")).getText();
        return signOut;
    }
}