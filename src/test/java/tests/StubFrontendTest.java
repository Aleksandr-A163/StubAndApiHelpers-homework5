package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.containsString;

class StubFrontendTest extends BaseWireMockTest {

  @Test
  void frontendShouldReturnHtml() {
    get("/")
        .then()
        .statusCode(200)
        .header("Content-Type", containsString("text/html"))
        .body(containsString("Stub Frontend OK"));
  }
}
