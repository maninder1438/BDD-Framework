package com.mani.selenium.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class DriverManager {


    public DriverManager(){
        PageFactory.initElements(driver,this);
    }


    public static WebDriver driver;
    private String browser = "";

    public void openBrowser() {
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }
    }

    public void maxiBrowser() {
        driver.manage().window().maximize();
    }

    public void applyImpcitWait() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void closeBrowser() {
        driver.quit();
    }

    public void sleep(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     }
     public void escapeKey(){
         Actions action = new Actions(driver);
         action.sendKeys(Keys.ESCAPE).perform();
     }
}
