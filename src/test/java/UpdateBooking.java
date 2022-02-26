import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UpdateBooking extends BaseTest{
    @Test
    public void createToken(){
        String token = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"username\" : \"admin\",\n" +
                        "    \"password\" : \"password123\"\n" +
                        "}")
                .post("/auth")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .jsonPath()
                .getString("token");

        updateTest(token);
    }

    public void updateTest(String token){

        given()
                .contentType(ContentType.JSON)
                .cookie("token",token)
                .body("{\n" +
                        "    \"firstname\" : \"Abraham\",\n" +
                        "    \"lastname\" : \"Machado\",\n" +
                        "    \"totalprice\" : 2323,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2021-01-01\",\n" +
                        "        \"checkout\" : \"2022-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}")
                .pathParam("id",3)
                .put("https://restful-booker.herokuapp.com/booking/{id}")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
