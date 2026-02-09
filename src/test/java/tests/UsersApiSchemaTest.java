package tests;

import base.BaseWireMock;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

class UsersApiSchemaTest extends BaseWireMock {

  @Test
  void usersShouldMatchSchema() {
    get("/user/get/all")
        .then()
        .statusCode(200)
        .body(matchesJsonSchemaInClasspath("schemas/users.schema.json"));
  }
}
