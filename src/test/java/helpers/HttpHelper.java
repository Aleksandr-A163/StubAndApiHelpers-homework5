package helpers;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class HttpHelper {

  public Response get(final String path) {
    return given()
        .log().all()
        .when()
        .get(path)
        .then()
        .log().all()
        .extract()
        .response();
  }
}
