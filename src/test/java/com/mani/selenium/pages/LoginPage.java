package com.mani.selenium.pages;

import com.mani.selenium.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends DriverManager {

    @FindBy (css = "a[data-test='account']")
    private WebElement accountButton;

    @FindBy(css = ".panel-header h2")
    private WebElement accountPageTitleMessageBeforeLogin;

    @FindBy(css = ".Title__container__2arEZ >p")
    private WebElement accountPageTitleMessageAfterLogin;

    @FindBy(css = "#email-address")
    private WebElement emailBox;

    @FindBy(css = "#current-password")
    private WebElement passwordBox;

    @FindBy(css = "button[data-bdd-test-id='yourEmailSubmitButton']")
    private WebElement signInButton;

    @FindBy(css = "span[class='_2WxI4']")
    private WebElement firstnameAfterLogin;

    @FindBy(css = ".Bh-zw")
    private WebElement signOutButton;

    public String accountLoginPage() {
        accountButton.click();
        String url = driver.getCurrentUrl();
        return url;
    }

    public String accountLoginPageMessageBeforeLogin(){
         String message = accountPageTitleMessageBeforeLogin.getText();
        return message;
    }
    public String accountLoginPageMessageAfterLogin(){
        String message = accountPageTitleMessageAfterLogin.getText();
        return message;
    }
    public void enterEmailAddress(String email){
         emailBox.sendKeys(email);
     }
    public void enterPassword(String password){
        passwordBox.sendKeys(password);
    }
    public void signInSecurely() {
        sleep(3000);
        signInButton.click();
    }
    public String getFirstNameAfterLogin() {
        sleep(30000);
        String firstName = firstnameAfterLogin.getText();
        return firstName;
    }
    public String signOutButton(){
        String signOut = signOutButton.getText();
        return signOut;
    }
}