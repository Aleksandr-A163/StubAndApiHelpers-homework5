package tests;

import base.BaseWireMock;
import helpers.SoapHelper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SoapHelperTest extends BaseWireMock {

  @Test
  void soapHelperShouldReturnScore() throws Exception {
    final SoapHelper soap = new SoapHelper("http://localhost:" + wm.port());

    final String requestXml = """
      <soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
        <soap:Body>
          <getScoreRequest>
            <id>1</id>
          </getScoreRequest>
        </soap:Body>
      </soap:Envelope>
    """;

    final String responseXml = soap.postSoap("/soap/user/getScore", requestXml);

    assertTrue(responseXml.contains("<name>Test user</name>"));
    assertTrue(responseXml.contains("<score>78</score>"));
  }
}
