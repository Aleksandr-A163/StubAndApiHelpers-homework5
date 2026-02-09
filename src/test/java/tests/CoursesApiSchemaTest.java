package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

class CoursesApiSchemaTest extends BaseWireMockTest {

  @Test
  void coursesShouldMatchSchema() {
    get("/cource/get/all")
        .then()
        .statusCode(200)
        .body(matchesJsonSchemaInClasspath("schemas/courses.schema.json"));
  }
}
