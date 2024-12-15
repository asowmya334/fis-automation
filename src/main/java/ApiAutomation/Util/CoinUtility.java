package ApiAutomation.Util;

import ApiAutomation.pojoClasses.CoinDeskResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CoinUtility {

    public static Response submitRequest(String endpoint)
            throws CoinException {
        try {
            Response res = RestAssured.given().when().log().all().get(endpoint).then().log()
                    .all().extract().response();
            return res;
        } catch (Exception e) {
            String errorMsg = String.format("Error while sending request : %s", e.getMessage());
            throw new CoinException(errorMsg);
        }
    }

    public CoinDeskResponse JsonConvert(Response response) throws CoinException {
        try {
            ObjectMapper objMapper = new ObjectMapper();
            return objMapper.readValue(response.getBody().asString(), CoinDeskResponse.class);
        } catch (Exception e) {
            String errorMsg = String.format("Error while setting response in Pojo : %s", e.getMessage());
            throw new CoinException(errorMsg);
        }
    }

}
