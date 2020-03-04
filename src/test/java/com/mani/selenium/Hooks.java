package com.mani.selenium;

import com.mani.selenium.driver.DriverManager;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
    DriverManager factory = new DriverManager();

    @Before
    public void setUp() {
        factory.openBrowser();
        // TODO: 2020-02-08 Remove url from code
        factory.navigateTo("https://www.argos.co.uk");
        factory.maxiBrowser();
        factory.applyImpcitWait();
    }

      @After
    public void tearDown() {
        factory.closeBrowser();
    }
}
