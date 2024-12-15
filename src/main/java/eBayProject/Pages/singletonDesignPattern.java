package eBayProject.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class singletonDesignPattern {

    public static WebDriver driver = null;
    public static String  browser = "chrome";

    private singletonDesignPattern()
    {

    }


    public static WebDriver Initialize()
    {
        if(driver == null)
        {
            if(browser.equalsIgnoreCase("chrome"))
            {
                System.setProperty("webdriver.chrome.driver","src/main/resources/driver/chromedriver.exe");
                driver = new ChromeDriver();
            }
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
