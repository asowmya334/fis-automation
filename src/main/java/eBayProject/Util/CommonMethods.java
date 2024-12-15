package eBayProject.Util;

import eBayProject.Pages.singletonDesignPattern;
import io.cucumber.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class CommonMethods {

    private WebDriver driver;


    public CommonMethods() {
        this.driver = singletonDesignPattern.Initialize();
    }

    public WebElement findByXpath(String xpath) {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public void enterText(String locator, String value) {
        WebElement element = findByXpath(locator);
        element.click();
        element.sendKeys(value);
    }

    public void clickElement(String locator)
    {
        WebElement element = findByXpath(locator);
        element.click();
    }

    public String updateXpath(String xPath ,String path)
    {
       return xPath.replace("$input",path.toLowerCase());

    }

    public String getText(String locator)
    {
        WebElement element = findByXpath(locator);
        return element.getText();
    }

    @After
    public void afterScenario() {
        singletonDesignPattern.quit();
    }
}
