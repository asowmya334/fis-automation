package ApiAutomation.StepDefinition;

import ApiAutomation.Util.CoinException;
import ApiAutomation.Util.CoinUtility;
import ApiAutomation.pojoClasses.Bpi;
import ApiAutomation.pojoClasses.CoinDeskResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import io.cucumber.messages.internal.com.google.gson.JsonObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class coinDeskStepDefinition {
    public static CoinUtility coinUtility = new CoinUtility();
    public static Response response;

    private CoinDeskResponse coinDeskResponse;

    public coinDeskStepDefinition(CoinDeskResponse coinDeskResponse)
    {
        this.coinDeskResponse = coinDeskResponse;
    }

    @When("I call create API <endpoint>")
    public void iCallCreateAPIEndpoint(DataTable dataTable) throws CoinException {
         response = coinUtility.submitRequest((String) dataTable.asList(String.class).get(0));
    }

    @Then("I validate the status code is {int}")
    public void iValidateTheStatusCodeIs(int statusCode) {
        Assert.assertEquals(response.getStatusCode(),statusCode);
    }

    @And("I validate below BPI")
    public void iValidateBelowBPI(DataTable table) throws JsonProcessingException, CoinException {
        List<String> listOfBpi = table.asList();

        //Validation using Json Path
        JsonPath path = new JsonPath(response.body().asString());
       for (String list: listOfBpi) {
            String value = path.getString("bpi" + "." + list);
            Assert.assertNotNull(value);
        }

       //Validation using Pojo class
        coinDeskResponse = coinUtility.JsonConvert(response);
        Map<String, Bpi> res = coinDeskResponse.getBpi();
        for (String list: listOfBpi) {
            Assert.assertTrue(res.containsKey(list));
        }
    }
}
