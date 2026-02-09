package tests;

import base.BaseWireMock;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.containsString;

class StubFrontendTest extends BaseWireMock {

  @Test
  void frontendShouldReturnHtml() {
    get("/")
        .then()
        .statusCode(200)
        .header("Content-Type", containsString("text/html"))
        .body(containsString("Stub Frontend OK"));
  }
}
