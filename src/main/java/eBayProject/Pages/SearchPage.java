package eBayProject.Pages;

import eBayProject.Util.CommonMethods;
import eBayProject.Util.eBayException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.Set;

public class SearchPage {
    private WebDriver driver;
    public CommonMethods methods = new CommonMethods();

    public static String searchEditBox = "//input[@class = 'gh-tb ui-autocomplete-input']";
    public static String suggestionLink = "//*[@id='ui-id-1']//a[@aria-label = '" + "$input" + "']";
    public static String firstSearchItem = "//li[2]//div[@class = 's-item__info clearfix']/a";
    public static String addToCartButton = "//span[contains(text() ,'Add to cart')]";
    public static String cartCount = "//li[@id= 'gh-minicart-hover']//i";

    public SearchPage() {
        this.driver = singletonDesignPattern.Initialize();
    }

    public void EnterSearchBox(String input) throws eBayException {
        try {
            methods.enterText(searchEditBox, input);
            String suggestionText = methods.updateXpath(suggestionLink, input);
            methods.clickElement(suggestionText);
        }
        catch (Exception e)
        {
            String errorMsg = String.format("Not able to serach the element : %s", e.getMessage());
        throw new eBayException(errorMsg);
        }

    }

    public void selectFirstElementAndAddToCart() throws eBayException {
        try {
            methods.clickElement(firstSearchItem);
            Set<String> windowHandles = driver.getWindowHandles();
            ArrayList<String> handlesList = new ArrayList<>(windowHandles);
            // Switch to the last window
            String lastWindowHandle = handlesList.get(handlesList.size() - 1);
            driver.switchTo().window(lastWindowHandle);
            methods.clickElement(addToCartButton);
        }
        catch (Exception e)
        {
            String errorMsg = String.format("Not able to serach the element : %s", e.getMessage());
            throw new eBayException(errorMsg);
        }
    }

    public void CheckAddToCartCount(int totalCount) throws eBayException {
        try {
            Assert.assertEquals(String.valueOf(totalCount), methods.getText(cartCount));
        }
        catch (Exception e)
        {
            String errorMsg = String.format("Not able to serach the element : %s", e.getMessage());
            throw new eBayException(errorMsg);
        }
    }
}
