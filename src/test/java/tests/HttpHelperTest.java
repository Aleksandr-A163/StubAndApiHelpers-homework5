package tests;

import base.BaseWireMock;
import helpers.HttpHelper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HttpHelperTest extends BaseWireMock {

  @Test
  void httpHelperShouldGetCourses() {
    final HttpHelper http = new HttpHelper();
    final var resp = http.get("/cource/get/all");

    assertEquals(200, resp.statusCode());
    assertTrue(resp.asString().contains("QA java"));
  }
}
