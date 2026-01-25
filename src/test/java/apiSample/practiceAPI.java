package apiSample;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.Matchers.*;


public class practiceAPI {

    private final RequestSpecification requestSpecification = RestAssured.given()
            .and().baseUri("https://restful-booker.herokuapp.com")
            .and().filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

    @Test
    public void simpleProductListApi() {
        // Init the request spec class
        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.baseUri("https://automationexercise.com")
                .basePath("/api/productsList")
                .contentType(ContentType.JSON)
                .get();
        System.out.println(response.asString());
    }

    @Test
    public void deletewithBasicAuth() {
        Response deleteApiResponse = this.requestSpecification
                .and().basePath("/booking/{bookingId}")
                .and().auth().preemptive().basic("admin", "password123")
                .and().pathParam("bookingId", 10)
                .and().delete();

    }

    @Test
    public void simplePostApiToCreateBooking() {
        Map<String, Object> requestBody = getCreateBookingPayload("Sam", "Alton", 500);
        Response createBookingApiResponse = this.requestSpecification.basePath("/booking")
                // Always use ContentType enum for defining contentType
                .and().contentType(ContentType.JSON)
                .and().body(requestBody)
                .when().post()
                .then().assertThat().statusCode(200)
                .and().body("bookingid", is(not(equalTo(0))))
                .extract().response();
    }





 //**Methods ***///

    private Map<String, Object> getCreateBookingPayload(String firstName, String lastName, int totalPrice) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("firstname", firstName);
        requestBody.put("lastname", lastName);
        requestBody.put("totalprice", totalPrice);
        requestBody.put("depositpaid", false);
        requestBody.put("additionalneeds", "Nothing else");

        // Create booking date map
        Map<String, Object> bookingDatesMap = new HashMap<>();
        bookingDatesMap.put("checkin", "2024-01-01");
        bookingDatesMap.put("checkout", "2024-02-01");
        requestBody.put("bookingdates", bookingDatesMap);
        return requestBody;
    }

}
