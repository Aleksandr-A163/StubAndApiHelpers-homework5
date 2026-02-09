package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

class UserScoreApiSchemaTest extends BaseWireMockTest {

  @Test
  void scoreShouldMatchSchema() {
    get("/user/get/1")
        .then()
        .statusCode(200)
        .body(matchesJsonSchemaInClasspath("schemas/score.schema.json"));
  }
}
