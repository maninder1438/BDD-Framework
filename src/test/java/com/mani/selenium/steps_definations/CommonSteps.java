package com.mani.selenium.steps_definations;

import com.mani.selenium.pages.HomePage;
import com.mani.selenium.pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.endsWith;

public class CommonSteps {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Given("^I am on homepage$")
    public void i_am_on_homepage() {
        String actual = homePage.getCurrentUrl();
        assertThat(actual, endsWith("co.uk/"));
    }

    @When("^I search for a product of \"([^\"]*)\"$")
    public void iSearchForAProductOf(String term) {
        homePage.doSearch(term);
    }

    @When("^I click on account button$")
    public void i_click_on_account_button() {
        loginPage.accountLoginPage();
    }

    @Given("^I am on account login page$")
    public void iAmOnAccountLoginPage() {
        loginPage.accountLoginPage();
    }
}
