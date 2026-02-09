package stubs;

import com.github.tomakehurst.wiremock.WireMockServer;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathMatching;

public final class WireMockStubs {

  private WireMockStubs() {
  }

  public static void setup(final WireMockServer wm) {

    wm.stubFor(get(urlPathMatching("/user/get/\\d+"))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader("Content-Type", "application/json")
            .withBody("""
                {
                  "name": "Test user",
                  "score": 78
                }
                """)));

    wm.stubFor(get(urlEqualTo("/user/get/all"))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader("Content-Type", "application/json")
            .withBody("""
                [
                  {
                    "name": "Test user",
                    "cource": "QA",
                    "email": "test@test.test",
                    "age": 23
                  }
                ]
                """)));

    wm.stubFor(get(urlEqualTo("/cource/get/all"))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader("Content-Type", "application/json")
            .withBody("""
                [
                  { "name": "QA java", "price": 15000 },
                  { "name": "Java", "price": 12000 }
                ]
                """)));

    wm.stubFor(get(urlEqualTo("/"))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader("Content-Type", "text/html; charset=utf-8")
            .withBodyFile("index.html")));

    wm.stubFor(post(urlEqualTo("/soap/user/getScore"))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader("Content-Type", "text/xml; charset=utf-8")
            .withBody("""
              <soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
                <soap:Body>
                  <getScoreResponse>
                    <name>Test user</name>
                    <score>78</score>
                  </getScoreResponse>
                </soap:Body>
              </soap:Envelope>
            """)));
  }
}
