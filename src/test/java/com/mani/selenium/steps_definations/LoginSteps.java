package com.mani.selenium.steps_definations;

import com.mani.selenium.pages.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.endsWith;

public class LoginSteps {
    private LoginPage loginPage = new LoginPage();

    @Then("^I should be able to see account login page$")
    public void i_should_be_able_to_see_account_login_page() throws InterruptedException {
        Thread.sleep(2000);
        String actual = loginPage.accountLoginPage();
        assertThat(actual, endsWith("account"));
    }

    @And("^the message should be visible \"([^\"]*)\"$")
    public void theMessageShouldBeVisible(String message) throws InterruptedException {
        Thread.sleep(3000);
        String actualMessage = loginPage.accountLoginPageMessageBeforeLogin();
        Assert.assertTrue(actualMessage.contains(message));
    }

    @When("^I enter my valid email address \"([^\"]*)\"$")
    public void iEnterMyValidEmailAddress(String email) throws InterruptedException {
        Thread.sleep(4000);
        loginPage.enterEmailAddress(email);
    }

    @And("^I enter my valid password \"([^\"]*)\"$")
    public void iEnterMyValidPassword(String password) {
        loginPage.enterPassword(password);
    }
    @And("^Click sign in securely button$")
    public void clickSignInSecurelyButton() throws InterruptedException {
        loginPage.signInSecurely();
    }

    @Then("^I should be logged in successfully & able to see my first name \"([^\"]*)\" on top right corner$")
    public void iShouldBeLoggedInSuccessfullyAbleToSeeMyFirstNameOnTopRightCorner(String actualFirstName) throws InterruptedException {

        String expectedFirstName = loginPage.getFirstNameAfterLogin();
        Assert.assertEquals(expectedFirstName,actualFirstName);
    }
    @And("^\"([^\"]*)\" link will be visible on top right corner$")
    public void linkWillBeVisibleOnTopRightCorner(String signOutLink)  {
        Assert.assertEquals(loginPage.signOutButton(),signOutLink);
    }

}