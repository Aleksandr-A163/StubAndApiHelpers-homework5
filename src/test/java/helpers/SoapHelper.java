package helpers;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class SoapHelper {

  private final OkHttpClient client = new OkHttpClient();
  private final String baseUrl;

  public SoapHelper(final String baseUrl) {
    this.baseUrl = baseUrl;
  }

  public String postSoap(final String path, final String xml) throws Exception {
    final RequestBody body = RequestBody.create(xml, MediaType.parse("text/xml; charset=utf-8"));
    final Request request = new Request.Builder()
        .url(baseUrl + path)
        .post(body)
        .build();

    try (Response response = client.newCall(request).execute()) {
      if (!response.isSuccessful()) {
        throw new RuntimeException("SOAP call failed: HTTP " + response.code());
      }
      final ResponseBody rb = response.body();
      return rb == null ? "" : rb.string();
    }
  }
}
