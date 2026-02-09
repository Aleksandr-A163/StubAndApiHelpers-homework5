package base;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import stubs.WireMockStubs;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

public abstract class BaseWireMock {

  protected static WireMockServer wm;

  @BeforeAll
  static void startWireMock() {
    wm = new WireMockServer(0);
    wm.start();
    WireMockStubs.setup(wm);

    baseURI = "http://localhost";
    port = wm.port();
  }

  @AfterAll
  static void stopWireMock() {
    if (wm != null) {
      wm.stop();
    }
  }
}
