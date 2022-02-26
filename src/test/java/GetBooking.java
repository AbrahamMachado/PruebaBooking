import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetBooking extends BaseTest{
    @Test
    public void getTest(){

        given()
                .contentType(ContentType.JSON)
                .pathParam("id",3)
                .get("/booking/{id}")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
