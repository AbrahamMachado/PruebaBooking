import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class createBooking extends BaseTest{

    @Test
    public void createTest(){

        given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"firstname\" : \"Abraham\",\n" +
                        "    \"lastname\" : \"Machado\",\n" +
                        "    \"totalprice\" : 222,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2021-01-01\",\n" +
                        "        \"checkout\" : \"2022-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}")
                .post("booking")
                .then()
                .statusCode(HttpStatus.SC_OK).body("bookingid",notNullValue());
    }

}
