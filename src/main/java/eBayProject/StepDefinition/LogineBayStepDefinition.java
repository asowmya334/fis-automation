package eBayProject.StepDefinition;

import eBayProject.Pages.LoginPage;
import eBayProject.Pages.SearchPage;
import eBayProject.Pages.singletonDesignPattern;
import eBayProject.Util.eBayException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import java.util.List;

public class LogineBayStepDefinition {

    private WebDriver driver;
    public static LoginPage loginPage = new LoginPage();
    public static SearchPage searchPage = new SearchPage();

    public LogineBayStepDefinition() {
        this.driver = singletonDesignPattern.Initialize();
    }

    @Given("I am on ebay login page and key in user credentials")
    public void iAmOnEbayLoginPageAndKeyInUserCredentials() {
        loginPage.LoginToEbay();
    }

    @When("search the item given below")
    public void searchTheItemGivenBelow(DataTable table) throws eBayException {
        List<String> input = table.asList();
        searchPage.EnterSearchBox(input.get(0));
    }

    @And("I select first item from the list and add to cart")
    public void iSelectFirstItemFromTheListAndAddToCart() throws eBayException {
        searchPage.selectFirstElementAndAddToCart();
    }

    @Then("Verify the cart is updated and displays the number of items in the cart {int}")
    public void verifyTheCartIsUpdatedAndDisplaysTheNumberOfItemsInTheCart(int totalCount) throws eBayException {
        searchPage.CheckAddToCartCount(totalCount);
    }
}
