package eBayProject.Pages;

import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage() {
        this.driver = singletonDesignPattern.Initialize();
    }

    public void LoginToEbay() {
        driver.get("https://www.ebay.com/");
    }
}
