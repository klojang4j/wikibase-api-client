package org.klojang.wbapiclient;

import java.util.Map;

import static java.net.URLEncoder.encode;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.Map.Entry;

class RequestUtil {

  private RequestUtil() { throw new UnsupportedOperationException(); }

  static String urlEncodeFormData(Map<String, Object> formData) {
    StringBuilder sb = new StringBuilder();
    for (Entry<String, Object> entry : formData.entrySet()) {
      if (sb.length() > 0) {
        sb.append("&");
      }
      sb.append(encode(entry.getKey(), UTF_8));
      sb.append("=");
      String val = switch (entry.getValue()) {
        case null -> "";
        case String x -> encode(x, UTF_8);
        case Number x -> x.toString();
        case Boolean x -> x.toString();
        case Character x -> encode(x.toString(), UTF_8);
        default -> encode(JsonUtil.toJson(entry.getValue()), UTF_8);
      };
      sb.append(val);
    }
    return sb.toString();
  }
}
